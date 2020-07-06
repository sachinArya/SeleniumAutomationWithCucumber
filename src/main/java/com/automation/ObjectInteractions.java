package com.automation;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.util.List;


public class ObjectInteractions {

    public static void enterKeys(WebDriver driver,WebElement element, String keys) throws Exception{
        moveToElement(driver,element);
        element.sendKeys(keys);
       /* System.out.println("element = " + element.getText());
            if (!(element.getText().equalsIgnoreCase(keys)))
                throw new Exception("Value not entered properly");

        */
    }

    public static void click(WebDriver driver,WebElement element) throws Exception{
        moveToElement(driver,element);
        element.click();
    }

    public static void moveToElement(WebDriver driver, WebElement element) throws Exception
    {
        Actions builder = new Actions(driver);
        builder.moveToElement(element);
    }

    public static void takeScreenShot(WebDriver driver) throws Exception
    {
        TakesScreenshot scrnshot = (TakesScreenshot)driver;
        File src = scrnshot.getScreenshotAs(OutputType.FILE);
        String pathDir = System.getProperty("user.dir") + "//Results//" + Utils.getCurrentTimeStamp();
        new File(pathDir).mkdirs();
        new File(pathDir + "//screenshots").mkdirs();
        //FileUtils.copyFile(src,);
    }

}
