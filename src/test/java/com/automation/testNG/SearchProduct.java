package com.automation.testNG;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchProduct extends testNGHooks{

    @Test(description = "Search Products",enabled = true,dataProvider = "Products")
    public static void searchThanos(ITestContext context) throws Exception
    {
        String cntx = testNGHooks.getContextName();
        WebDriver driver = (WebDriver)context.getAttribute(cntx);
        System.out.println("Executing search product");
        driver.get("http://www.amazon.co.uk");
        com.automation.pom.LandingPage.enterProductNameToSearch(driver,"thanos");
        com.automation.pom.LandingPage.clickSearchButton(driver);
    }

    @DataProvider(name = "Products")
    public Object[][] getProducts()
    {
        return new Object[][]{
                {"Thanos"}
                //,{"Lenovo"}
        };
    }

   /* @Test(description = "Search Lenovo",enabled=true)
    public static void searchLenovo(ITestContext context) throws Exception
    {
        String cntx = testNGHooks.getContextName();
        WebDriver driver = (WebDriver)context.getAttribute(cntx);
        System.out.println("Executing search product");
        driver.get("http://www.amazon.co.uk");
        com.automation.pom.LandingPage.enterProductNameToSearch(driver,"lenovo");
        com.automation.pom.LandingPage.clickSearchButton(driver);
    }*/
}
