package com.automation.cucumber;

import io.cucumber.testng.*;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "features/amazon"
        ,glue="com.automation.cucumber"
        ,tags = "@login and not @searchProduct"
        , plugin = {"json:target/cucumber-reports/cucumber.json"})

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
