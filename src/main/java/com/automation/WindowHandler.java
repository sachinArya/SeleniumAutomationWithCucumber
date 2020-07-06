package com.automation;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHandler {

    public void switchToWindow(WebDriver driver, String title) throws Exception
    {
        String parentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();


        for(String wndw:windows)
        {
            if(driver.switchTo().window(wndw).getTitle().equals(title))
            {
                break;
            }
            else
            {
                driver.switchTo().window(parentWindow);
            }
        }
    }

    public void navigateTo(WebDriver driver, String url) throws Exception
    {
        driver.navigate().to(url);
    }

}
