package com.automation.testNG;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTestParallelMethod extends testNGHooks{

    @Test(groups = {"myTest"},description = "Test To Login to application")
    @Parameters("URL")
    public static void Login(String URL, ITestContext context) throws Exception
    {
        String cntx = testNGHooks.getContextName();
        WebDriver driver = (WebDriver)context.getAttribute(cntx);
        System.out.println("Executing Login");
        driver.get(URL);
        com.automation.pom.LandingPage.clickSignIn(driver);
        com.automation.pom.Login.enterUserName(driver,"abc@gmail.com");
        com.automation.pom.Login.clickContinue(driver);
        com.automation.pom.Login.enterPassword(driver,"test");
        com.automation.pom.Login.clickLogin(driver);
    }
}
