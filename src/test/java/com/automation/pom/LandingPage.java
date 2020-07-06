package com.automation.pom;

import com.automation.FindElement;
import com.automation.ObjectInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    private static By signIn = By.xpath("//*[@id='nav-link-accountList']");
    private static By searchBar = By.xpath("//*[@id='twotabsearchtextbox']");
    private static By searchButton =  By.xpath("//input[@type='submit' and @value='Go']");

    public static void clickSignIn(WebDriver driver) throws Exception
    {
        WebElement elem = FindElement.findElement(driver,signIn);
        ObjectInteractions.click(driver,elem);
    }

    public static void enterProductNameToSearch(WebDriver driver,String product) throws Exception
    {
        WebElement elem = FindElement.findElement(driver,searchBar);
        ObjectInteractions.enterKeys(driver,elem,product);
    }

    public static void clickSearchButton(WebDriver driver) throws Exception
    {
        WebElement elem = FindElement.findElement(driver,searchButton);
        ObjectInteractions.click(driver,elem);
    }


}
