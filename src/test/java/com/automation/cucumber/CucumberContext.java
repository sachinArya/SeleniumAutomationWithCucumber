package com.automation.cucumber;

import com.automation.DriverSetup;
import com.automation.Snapshot;
import com.automation.Utils;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.sql.Date;
import java.util.HashMap;

public class CucumberContext {

    WebDriver driver;
    HashMap<String, Object> parameters;

    @Before
    public void setDriver()
    {
        this.driver = DriverSetup.getDriver();
    }

    @After
    public void cleanUpDriver(Scenario scenario) throws Exception {
        if(scenario.isFailed())
        {
            String fileName = CucumberTestRunner.resultFolder + "//ScreenShots//";
            fileName += scenario.getName().concat(Utils.getCurrentTimeStamp()).concat(".jpg");
            Snapshot.takeSnapShot(this.driver,fileName);
        }

        this.driver.quit();
        this.driver = null;
    }

    public void setParameters(String key, Object obj) {
        parameters.put(key, obj);
    }

    public Object getParameters(String key) {
        return parameters.get(key);
    }
}
