package com.automation.cucumber;

import com.automation.Utils;
import io.cucumber.java.Scenario;
import io.cucumber.testng.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;

@CucumberOptions(features = "features/amazon"
        ,glue="com.automation.cucumber"
        ,tags = "@tt1"
        ,dryRun = true
        , plugin = {"json:target/cucumber-reports/cucumber.json",
        "com.automation.cucumber.DryRunPlugin"})

public class CucumberDryRun extends AbstractTestNGCucumberTests {

    static String resultFolder;
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeClass
    public void intialize() throws Exception {
        resultFolder =  Utils.createTestReportFolder();
        if(resultFolder==null)
        {
            throw new Exception("Unable to create a result folder");
        }

    }

}
