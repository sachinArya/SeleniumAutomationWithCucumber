package com.automation.pom;

import com.automation.CheckBox;
import com.automation.FindElement;
import com.automation.ObjectInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private static By searchPanel = By.xpath("//*[@id='search']");
    private static By sortDropDownBtn = By.xpath("//span[contains(text(),'Sort by:')]/parent::span");
    private static By selectFreeDelivery = By.xpath("//li[@aria-label='Free UK Delivery by Amazon']/descendant::input[@type='checkbox']");

    public static boolean isSearchPageLoaded(WebDriver driver) throws Exception
    {
        List<WebElement> element = FindElement.findElements(driver,searchPanel);

        return element.size()>0 ? true : false;
    }

    public static void sort(WebDriver driver, String value) throws Exception
    {
        By item = By.xpath("//*[starts-with(@aria-labelledby,'s-result-sort-select')]/a[contains(text(),'" + value + "')]");

        WebElement element = FindElement.findElement(driver,sortDropDownBtn);
        ObjectInteractions.click(driver,element);

        // for user to realize the pop up opened
        Thread.sleep(3000);

        element = FindElement.findElement(driver,item);
        element.click();

        //for user to realize the sort value is selected
        Thread.sleep(6000);

        element = FindElement.findElement(driver,sortDropDownBtn);

        String sortedBy = element.getAttribute("innerText");

        if(!(sortedBy.contains(value)))
        {
            throw new Exception("Unable to perform on sort");
        }
    }

    public static void selectFreeUKDelivery(WebDriver driver) throws Exception
    {
        WebElement element = FindElement.findElement(driver,selectFreeDelivery);

        CheckBox.tickCheckbox(driver,element);
    }

}
