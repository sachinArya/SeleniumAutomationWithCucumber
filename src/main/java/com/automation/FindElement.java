package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FindElement {

    public static WebElement findElement(WebDriver driver,By by) throws Exception
    {
        WebDriverWait o_wait = new WebDriverWait(driver,120);
        return o_wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static List<WebElement> findElements(WebDriver driver,By by) throws Exception
    {
        WebDriverWait o_wait = new WebDriverWait(driver,120);
        o_wait.until(ExpectedConditions.elementToBeClickable(by));

        return driver.findElements(by);
    }
}
