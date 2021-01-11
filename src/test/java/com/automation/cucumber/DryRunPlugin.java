package com.automation.cucumber;

import com.automation.cucumber.util.CucumberExamples;
import com.automation.cucumber.util.GherkinParser;
import io.cucumber.messages.Messages;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;

import java.io.*;
import java.util.*;

public class DryRunPlugin implements EventListener {

    final static int THREAD_COUNT = 50;
    static int Counter = 1;
    static int folderCount = 0;
    static HashSet<String> parsed = new HashSet<>();
    static String tempSpecs = System.getProperty("user.dir") + "//tempspecs";
    static String targetSubFolder = "";
    static StringBuffer ClockMovements = new StringBuffer();

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this::EHTestCaseStarted);
    }

    private void EHTestCaseStarted(TestCaseStarted event) {
        try {

            String ffPath = event.getTestCase().getUri().getPath();
            String scnType = event.getTestCase().getKeyword();
            List<String> tags = event.getTestCase().getTags();

            String UUID = GherkinParser.getUUIDForScenario(ffPath, tags);

            if (parsed.contains(UUID)) {
                return;
            } else {
                parsed.add(UUID);
                Messages.GherkinDocument.Feature feature = GherkinParser.getFeature(ffPath);
                String featureName = feature.getName();
                Messages.GherkinDocument.Feature.FeatureChild scenario = GherkinParser.getScenario(feature, tags);
                Messages.GherkinDocument.Feature.FeatureChild bg = null;
                CucumberExamples cucumberExamples = null;

                if (scenario != null) {
                    bg = GherkinParser.getBackground(feature);
                }

                String scenarioString = GherkinParser.getScenarioString(scenario, featureName, bg, tags);

                //get Examples
                if (scnType.equalsIgnoreCase("Scenario Outline")) {
                    cucumberExamples = GherkinParser.getExamplesObject(scenario);
                }

                //while (Counter <= THREAD_COUNT) {
                    //Create new Directory when the counter is re-initialized
                    if (Counter == 1) {
                        targetSubFolder = "\\suite_" + folderCount;
                        File folder = new File(tempSpecs + targetSubFolder);
                        folder.mkdirs();
                        //folderCount = folderCount + 1;
                    }

                    //Handle Simple scenarios
                    if (scnType.equalsIgnoreCase("Scenario")) {
                        String fileName = Counter + "_ " +
                                scenario.getScenario().getName().replace(" ", "_");
                        GherkinParser.saveFile(tempSpecs + "//" + targetSubFolder, fileName, scenarioString);
                        Counter = Counter + 1;
                    }

                    //Handle Scenarios with examples
                    else {
                        int examplesCount = cucumberExamples.getBody().size();
                        for (int i = 0; i < examplesCount; i++) {
                            if (Counter == (THREAD_COUNT+1)) {
                                folderCount = folderCount + 1;
                                targetSubFolder = "\\suite_" + folderCount;
                                Counter = 1;
                            }
                            StringBuffer completeScenario = new StringBuffer();
                            completeScenario.append(scenarioString).append(System.lineSeparator());
                            completeScenario.append("Examples: ").append(System.lineSeparator());
                            completeScenario.append(cucumberExamples.getHeader().trim()).append(System.lineSeparator());
                            if(!(cucumberExamples.getBody().get(i).trim().equals("")))
                                completeScenario.append(cucumberExamples.getBody().get(i).trim());
                            else
                            {
                                break;
                            }
                            String fileName = Counter + "_ " +
                                    scenario.getScenario().getName().replace(" ", "_");
                            GherkinParser.saveFile(tempSpecs + targetSubFolder, fileName, completeScenario.toString());
                            Counter = Counter + 1;
                            //saveFile();
                        }
                    }

                    //Restart Counter when it reaches maximum thread count
                    if (Counter == (THREAD_COUNT+1)) {
                        folderCount = folderCount +1;
                        Counter = 1;
                        ClockMovements.setLength(0);
                    }


                //}
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }


}
