package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Wait {

    public void setGlobalWait(WebDriver driver, int timeInSeconds) throws Exception
    {
        driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
    }

    public void waitTillClickable(WebDriver driver, int timeInSeconds, By by) throws Exception
    {
        WebDriverWait oWait = new WebDriverWait(driver,120);
        oWait.until(ExpectedConditions.elementToBeClickable(by));
    }


}
