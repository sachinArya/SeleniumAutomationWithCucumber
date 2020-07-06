package com.enums;

public class TestSummary {

    private String testDescription;
    private String testClass;
    private String testMethodName;
    private double testDuration;
    private String testStatus;
    private String suiteName;
    private String testNGFileName;

    public TestSummary(String testDescription, String testClass, String testMethodName, double testDuration, String testStatus, String suiteName, String testNGFileName) {
        this.testDescription = testDescription;
        this.testClass = testClass;
        this.testMethodName = testMethodName;
        this.testDuration = testDuration;
        this.testStatus = testStatus;
        this.suiteName = suiteName;
        this.testNGFileName = testNGFileName;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        suiteName = suiteName;
    }

    public String getTestNGFileName() {
        return testNGFileName;
    }

    public void setTestNGFileName(String testNGFileName) {
        this.testNGFileName = testNGFileName;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    public String getTestClass() {
        return testClass;
    }

    public void setTestClass(String testClass) {
        this.testClass = testClass;
    }

    public String getTestMethodName() {
        return testMethodName;
    }

    public void setTestMethodName(String testMethodName) {
        this.testMethodName = testMethodName;
    }

    public double getTestDuration() {
        return testDuration;
    }

    public void setTestDuration(double testDuration) {
        this.testDuration = testDuration;
    }

    public String getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus;
    }

}
