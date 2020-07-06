package com.automation;

import org.openqa.selenium.WebDriver;

public class BrowserNavigations {

    public void goToURL(WebDriver driver,String url) throws Exception
    {
        driver.navigate().to(url);
    }

    public void moveForward(WebDriver driver) throws Exception
    {
        driver.navigate().forward();
    }

    public void moveBackward(WebDriver driver) throws Exception
    {
        driver.navigate().back();
    }

    public void refreshPage(WebDriver driver) throws Exception
    {
        driver.navigate().refresh();
    }

    public void maximizeBrowser(WebDriver driver) throws Exception
    {
        driver.manage().window().maximize();
    }

    public void fullScreenBrowser(WebDriver driver) throws Exception
    {
        driver.manage().window().fullscreen();
    }
}
