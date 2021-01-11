package com.automation.cucumber.util;

import io.cucumber.gherkin.Gherkin;
import io.cucumber.messages.IdGenerator;
import io.cucumber.messages.Messages;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class GherkinParser {

    public static Messages.GherkinDocument.Feature getFeature(String path) throws Exception {
        IdGenerator idGenerator = new IdGenerator.Incrementing();
        boolean includeSource = false;
        boolean includeAst = true;
        boolean includePickles = false;

        List<String> filePath = Collections.singletonList(path);
        List<Messages.Envelope> envelopes = Gherkin.fromPaths(filePath, includeSource, includeAst, includePickles, idGenerator).collect(Collectors.toList());

        // Get the AST
        Messages.GherkinDocument gherkinDocument = envelopes.get(0).getGherkinDocument();

        // Get the Feature node of the AST
        Messages.GherkinDocument.Feature feature = gherkinDocument.getFeature();

        return feature;

    }

    public static Messages.GherkinDocument.Feature.FeatureChild getBackground(Messages.GherkinDocument.Feature feature) throws Exception {

        Messages.GherkinDocument.Feature.FeatureChild background = null;
        List scenarios = feature.getChildrenList();
        Iterator itr_Scn = scenarios.iterator();

        while (itr_Scn.hasNext()) {
            Messages.GherkinDocument.Feature.FeatureChild child = (Messages.GherkinDocument.Feature.FeatureChild) itr_Scn.next();
            Messages.GherkinDocument.Feature.Background scn = child.getBackground();

            if (scn.getKeyword().equalsIgnoreCase("background")) {
                background = child;
                break;
            }
        }

        return background;
    }

    public static Messages.GherkinDocument.Feature.FeatureChild getScenario(Messages.GherkinDocument.Feature feature, List tags) throws Exception {
        Messages.GherkinDocument.Feature.FeatureChild scenario = null;
        List scenarios = feature.getChildrenList();
        Iterator itr_Scn = scenarios.iterator();

        //pick the correct scenario
        while (itr_Scn.hasNext()) {
            Messages.GherkinDocument.Feature.FeatureChild child = (Messages.GherkinDocument.Feature.FeatureChild) itr_Scn.next();
            Messages.GherkinDocument.Feature.Scenario scn = child.getScenario();
            if (scn.getKeyword().equalsIgnoreCase("scenario") || scn.getKeyword().equalsIgnoreCase("scenario outline")) {

                //if tags is null then return the first Scenario from Feature
                if(tags!=null)
                {
                    scenario = child;
                    break;
                }

                List tagOfScn = child.getScenario().getTagsList();
                Iterator itrTags = tagOfScn.iterator();
                boolean scenarioFound = false;
                while (itrTags.hasNext()) {
                    Messages.GherkinDocument.Feature.Tag tag = (Messages.GherkinDocument.Feature.Tag) itrTags.next();
                    String tagName = tag.getName();
                    if (tags.contains(tagName)) {
                        scenarioFound = true;
                    } else {
                        scenarioFound = false;
                        break;
                    }
                }

                if (scenarioFound) {
                    scenario = child;
                    break;
                }
            }

        }

        return scenario;
    }

    public static String getScenarioString(Messages.GherkinDocument.Feature.FeatureChild child, String name, Messages.GherkinDocument.Feature.FeatureChild bg, List tags) throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("Feature: ").append(name).append(System.lineSeparator()).append(System.lineSeparator());

        //Get Background String
        if (bg != null) {
            List backgroundSteps = bg.getBackground().getStepsList();
            String bgname = bg.getBackground().getName();
            String background = getStepsString(backgroundSteps, bg.getBackground().getKeyword(),bgname,null);
            builder.append(background).append(System.lineSeparator()).append(System.lineSeparator());
        }

        //Get Scenario String
        Messages.GherkinDocument.Feature.Scenario scn = child.getScenario();
        String scnName = scn.getName();
        String scnDesc = getStepsString(child.getScenario().getStepsList(), scn.getKeyword(),scnName, tags);
        builder.append(scnDesc).append(System.lineSeparator());

        return builder.toString();
    }

    public static String getStepsString(List<Messages.GherkinDocument.Feature.Step> steps, String type, String desc, List tags) throws Exception {
        StringBuilder builder = new StringBuilder();
        if(tags!=null)
        {
            Iterator itrTags = tags.iterator();
            while(itrTags.hasNext())
            {
                builder.append(itrTags.next()).append(" ");
            }
            builder.append(System.lineSeparator());
        }
        builder.append(type).append(": ").append(desc).append(System.lineSeparator());
        Iterator itrSteps = steps.iterator();

        while (itrSteps.hasNext()) {
            Messages.GherkinDocument.Feature.Step step = (Messages.GherkinDocument.Feature.Step) itrSteps.next();
            builder.append(step.getKeyword() + " ").append(step.getText()).append(System.lineSeparator());

            if (step.hasDataTable()) {
                Messages.GherkinDocument.Feature.Step.DataTable dataTable = step.getDataTable();
                List<Messages.GherkinDocument.Feature.TableRow> tableRows = dataTable.getRowsList();
                builder.append(convertTableToString(tableRows));
            }
        }

        return builder.toString();
    }

    public static CucumberExamples getExamplesObject(Messages.GherkinDocument.Feature.FeatureChild child) throws Exception {
        CucumberExamples cucumberExamples = new CucumberExamples();
        ArrayList body = new ArrayList();
        List<Messages.GherkinDocument.Feature.Scenario.Examples> examples = child.getScenario().getExamplesList();
        Iterator itrExamples = examples.iterator();
        while (itrExamples.hasNext()) {
            Messages.GherkinDocument.Feature.Scenario.Examples example = (Messages.GherkinDocument.Feature.Scenario.Examples) itrExamples.next();
            if (example.hasTableHeader()) {
                Messages.GherkinDocument.Feature.TableRow header = example.getTableHeader();
                List<Messages.GherkinDocument.Feature.TableRow> headerRows = new ArrayList<Messages.GherkinDocument.Feature.TableRow>();
                headerRows.add(header);
                cucumberExamples.setHeader((convertTableToString(headerRows)));
            }

            if (example.getTableBodyCount() > 0) {
                List<Messages.GherkinDocument.Feature.TableRow> rows = example.getTableBodyList();
                String tableRows = convertTableToString(rows);
                String[] strParts = tableRows.split("\\r?\\n|\\r", -1);
                for (int i = 0; i < strParts.length; i++) {
                    body.add(strParts[i]);
                }
                cucumberExamples.setBody(body);
            }
        }

        return cucumberExamples;
    }

    public static String convertTableToString(List<Messages.GherkinDocument.Feature.TableRow> tableRows) throws Exception {
        StringBuilder builder = new StringBuilder();
        Iterator itrRows = tableRows.iterator();
        while (itrRows.hasNext()) {
            builder.append("|");
            Messages.GherkinDocument.Feature.TableRow row = (Messages.GherkinDocument.Feature.TableRow) itrRows.next();
            List<Messages.GherkinDocument.Feature.TableRow.TableCell> cells = row.getCellsList();
            Iterator itrCells = cells.iterator();

            while (itrCells.hasNext()) {
                Messages.GherkinDocument.Feature.TableRow.TableCell cell = (Messages.GherkinDocument.Feature.TableRow.TableCell) itrCells.next();
                builder.append(cell.getValue()).append("|");
            }

            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }

    public static String getUUIDForScenario(String uri, List<String> tags) throws Exception {
        String UUID = uri + "|";
        for (String s : tags) {
            UUID += s + ",";
        }

        return UUID;
    }

    public static void saveFile(String path, String fileName, String content) throws Exception {

        File file = new File(path);
        if (!file.exists())
            file.mkdirs();

        if (file.isDirectory()) {
            File feature = new File(path + "//" + fileName + ".feature");
            FileWriter writer = new FileWriter(feature);
            writer.write(content);
            writer.flush();
            writer.close();
        }

    }

}
