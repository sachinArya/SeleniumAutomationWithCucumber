package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IFrameHandler {

    public void switchToFrame(WebDriver driver, String title) throws Exception {
        List<WebElement> iframes = FindElement.findElements(driver,By.tagName("iframe"));
        for(WebElement iframe: iframes)
        {
            if(driver.switchTo().frame(iframe).getTitle().equals(title))
            {
                break;
            }
            else
            {
                driver.switchTo().defaultContent();
            }

        }
    }

    public void switchToFrame(WebDriver driver, int index) throws Exception {
        List<WebElement> iframes = FindElement.findElements(driver,By.tagName("iframe"));

        if(iframes.size() > index)
        {
            driver.switchTo().frame(index);
        }
    }

    public void switchToParent(WebDriver driver) throws Exception {
       driver.switchTo().defaultContent();
    }

}
