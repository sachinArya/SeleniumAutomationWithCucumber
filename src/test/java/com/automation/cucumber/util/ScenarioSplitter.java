package com.automation.cucumber.util;

import io.cucumber.messages.Messages;
import java.io.File;

public class ScenarioSplitter {

    final static String tempSpecDir = System.getProperty("user.dir") + "\\tempspecs";
    final static String splitterString = "User is on (.*?) bacs day";
    final static String outputDir = System.getProperty("user.dir") + "\\tempspecs\\Output";

    public static void splitSceanrios() throws Exception{

        File folder = new File(tempSpecDir);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                String path = listOfFiles[i].getPath();
                Messages.GherkinDocument.Feature feature = GherkinParser.getFeature(path);
                String featureName = feature.getName();
                StringBuffer exampleString = new StringBuffer();
                CucumberExamples cucumberExamples = null;

                //Get the first scenario from the file
                Messages.GherkinDocument.Feature.FeatureChild scenario = GherkinParser.getScenario(feature, null);
                String scnType = scenario.getScenario().getKeyword();

                //get Examples
                if (scnType.equalsIgnoreCase("Scenario Outline")) {
                    cucumberExamples = GherkinParser.getExamplesObject(scenario);
                    if(cucumberExamples!=null)
                    {
                        exampleString.append(cucumberExamples.getHeader()).append(System.lineSeparator());
                        for(int j=0;j<cucumberExamples.getBody().size();j++)
                        {
                            exampleString.append(cucumberExamples.getBody().get(j)).append(System.lineSeparator());
                        }
                    }
                }



            } else if (listOfFiles[i].isDirectory()) {

            }
        }

    }

}
