package com.automation.cucumber;

import com.automation.DriverSetup;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

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
    public void cleanUpDriver()
    {
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
