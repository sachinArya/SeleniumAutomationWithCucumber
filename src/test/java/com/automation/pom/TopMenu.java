package com.automation.pom;

import com.automation.DropDown;
import com.automation.FindElement;
import com.automation.ObjectInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenu {

    private static By signIn = By.xpath("//*[@id='nav-link-accountList']");
    private static By searchBar = By.xpath("//*[@id='twotabsearchtextbox']");
    private static By searchButton =  By.xpath("//input[@type='submit' and @value='Go']");
    private static By drpDownDepartment =  By.xpath("//*[@id='searchDropdownBox']");

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

    public static void selectDepartment(WebDriver driver, String value) throws Exception
    {
        WebElement element = FindElement.findElement(driver,drpDownDepartment);
        DropDown.selectValueByText(element,value);
    }


}
