package com.automation.pom;

import com.automation.FindElement;
import com.automation.ObjectInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

    private static By userName = By.xpath("//*[@id='ap_email']");
    private static By btnContinue = By.xpath("//*[@id='continue']");
    private static By password = By.xpath("//*[@id='ap_password']");
    private static By loginBtn = By.xpath("//*[@id='signInSubmit']");

    public static void enterUserName(WebDriver driver, String name) throws Exception
    {
        WebElement elem = FindElement.findElement(driver,userName);
        ObjectInteractions.enterKeys(driver,elem,name);
    }

    public static void enterPassword(WebDriver driver,String pass) throws Exception
    {
        WebElement elem = FindElement.findElement(driver,password);
        ObjectInteractions.enterKeys(driver,elem,pass);
    }

    public static void clickContinue(WebDriver driver) throws Exception
    {
        WebElement elem = FindElement.findElement(driver,btnContinue);
        ObjectInteractions.click(driver,elem);
    }

    public static void clickLogin(WebDriver driver) throws Exception
    {
        WebElement elem = FindElement.findElement(driver,loginBtn);
        ObjectInteractions.click(driver,elem);
    }

    public static void loginApplication(WebDriver driver,String name, String password) throws Exception
    {
        enterUserName(driver,name);
        clickContinue(driver);
        enterPassword(driver,password);
        clickLogin(driver);
    }


}
