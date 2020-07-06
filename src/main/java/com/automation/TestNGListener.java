package com.automation;

import com.enums.TestSummary;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TestNGListener implements ITestListener {

    ArrayList<TestSummary> passedTest = new ArrayList<>();
    ArrayList<TestSummary> failedTest = new ArrayList<>();
    ArrayList<TestSummary> skippedTest = new ArrayList<>();


    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestContext testContext = result.getTestContext();
        testContext.getCurrentXmlTest().getSuite().getName();

        passedTest.add(new TestSummary(result.getMethod().getDescription(),
                result.getTestClass().getName(),
                result.getMethod().getMethodName(),
                (result.getEndMillis()-result.getStartMillis())/1000,
                "PASS",
                testContext.getCurrentXmlTest().getSuite().getName(),
                testContext.getCurrentXmlTest().getSuite().getFileName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestContext testContext = result.getTestContext();
        testContext.getCurrentXmlTest().getSuite().getName();

        failedTest.add(new TestSummary(result.getMethod().getDescription(),
                result.getTestClass().getName(),
                result.getMethod().getMethodName(),
                (result.getEndMillis()-result.getStartMillis())/1000,
                "FAIL",
                testContext.getCurrentXmlTest().getSuite().getName(),
                testContext.getCurrentXmlTest().getSuite().getFileName()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestContext testContext = result.getTestContext();
        testContext.getCurrentXmlTest().getSuite().getName();

        skippedTest.add(new TestSummary(result.getMethod().getDescription(),
                result.getTestClass().getName(),
                result.getMethod().getMethodName(),
                (result.getEndMillis()-result.getStartMillis())/1000,
                "SKIP",
                testContext.getCurrentXmlTest().getSuite().getName(),
                testContext.getCurrentXmlTest().getSuite().getFileName()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            ArrayList<TestSummary> allTest = new ArrayList<>();
            allTest.addAll(passedTest);
            allTest.addAll(failedTest);
            allTest.addAll(skippedTest);

            JsonArray jsonArray = new Gson().toJsonTree(allTest).getAsJsonArray();

            String path = System.getProperty("user.dir") + "\\Results\\JsonReport.json";

            FileWriter fw = new FileWriter(path);
            BufferedWriter writer = new BufferedWriter(fw);
            fw.append(jsonArray.toString());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
