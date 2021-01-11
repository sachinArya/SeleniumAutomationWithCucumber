package com.automation.cucumber;

import com.automation.Utils;
import io.cucumber.java.Scenario;
import io.cucumber.testng.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;

@CucumberOptions(features = "tempspecs/suite_0"
        ,glue="com.automation.cucumber"
        ,tags = "@tt1"
        , plugin = {"json:target/cucumber/report.json", "html:target/cucumber/report.html"})

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    static int threadCount = 10;
    static String resultFolder;
    @DataProvider(parallel = true)
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

        System.out.println();

    }

}
