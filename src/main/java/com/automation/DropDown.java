package com.automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class DropDown {

    public static ArrayList<String> getListOfValues(WebElement element) throws Exception
    {
        ArrayList<String> values = new ArrayList<String>();
        Select sel = new Select(element);
        for(WebElement option:sel.getOptions())
        {
            values.add(option.getText());
        }
        return values;
    }

    public static void selectValueByText(WebElement elem, String val) throws Exception
    {
        Select select = new Select(elem);
        select.selectByVisibleText(val);
    }

    public static void selectMultipleValuesByText(WebElement element, ArrayList<String> values) throws Exception
    {
        Select select = new Select(element);
        if(select.isMultiple())
        {
            for(String val:values)
            {
                select.deselectByVisibleText(val);
            }
        }
        else
        {
            throw new Exception("Not a multi select drop down");
        }
    }

    public static ArrayList<String> getSelectedValues(WebElement element) throws Exception
    {
        ArrayList<String> values = new ArrayList<String>();
        Select select = new Select(element);
        for(WebElement val:select.getAllSelectedOptions())
        {
            values.add(val.getText());
        }

        return values;
    }

    public static void deSelectAllValues(WebElement element) throws Exception
    {
        Select select = new Select(element);
        select.deselectAll();
    }

}
