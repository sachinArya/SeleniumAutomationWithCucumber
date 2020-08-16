package com.automation.cucumber;

import com.automation.Utils;
import io.cucumber.testng.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;

@CucumberOptions(features = "features/amazon"
        ,glue="com.automation.cucumber"
        ,tags = "@searchProductInADepartment"
        , plugin = {"json:target/cucumber-reports/cucumber.json"})

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

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

    }

}
