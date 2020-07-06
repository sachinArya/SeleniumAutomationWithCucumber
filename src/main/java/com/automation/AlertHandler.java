package com.automation;

import org.openqa.selenium.WebDriver;

public class AlertHandler {

    public static void clickOK(WebDriver driver) throws Exception
    {
        driver.switchTo().alert().accept();
    }

    public static void clickCancel(WebDriver driver) throws Exception
    {
        driver.switchTo().alert().dismiss();
    }

    public static String getAlertText(WebDriver driver) throws Exception
    {
        return driver.switchTo().alert().getText();
    }

    public static void sendTextToAlert(WebDriver driver, String text) throws Exception
    {
        driver.switchTo().alert().sendKeys(text);
    }
}
