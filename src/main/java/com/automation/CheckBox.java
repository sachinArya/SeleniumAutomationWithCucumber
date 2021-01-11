package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {

    public static boolean isChecked(WebElement element) throws Exception
    {
        return element.isSelected();
    }

    public static void tickCheckbox(WebDriver driver,WebElement element) throws Exception
    {
        if(!element.isSelected())
        {
            ObjectInteractions.jsClick(driver,element);
        }

    }

    public static void untickCheckbox(WebElement element) throws Exception
    {
        if(element.isSelected())
        {
            element.click();
        }
    }

}
