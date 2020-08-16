package com.automation;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class DriverSetup {

    public static int cntr = 0;

    public static WebDriver getDriver() {
        WebDriver driver = null;
        String nodeUrl = "http://172.27.197.33:4444/wd/hub";

        try {
                String dirPath = System.getProperty("user.dir");
                File file = new File(dirPath + "//conf//DriverSetup.properties");

                Properties prop = new Properties();
                prop.load(new FileReader(file));

                String browser = prop.getProperty("Browser");

                switch (browser) {
                    case "IE":
                        InternetExplorerOptions IEOptions = new InternetExplorerOptions();
                        IEOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                        IEOptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
                        driver = new InternetExplorerDriver(IEOptions);
                        driver.manage().window().maximize();
                        break;
                    case "CHROME":
                        DesiredCapabilities dc = DesiredCapabilities.chrome();
                        dc.setBrowserName("chrome");
                        dc.setPlatform(Platform.ANY);
                        System.setProperty("webdriver.chrome.driver", dirPath + "\\webdrivers\\chromedriver.exe");
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--incognito");
                        chromeOptions.addArguments("--log-level=3");
                        chromeOptions.setExperimentalOption("useAutomationExtension",false);
                        chromeOptions.merge(dc);
                        //driver = new RemoteWebDriver(new URL(nodeUrl), chromeOptions);
                        driver = new ChromeDriver(chromeOptions);
                        driver.manage().window().maximize();
                        break;
                    case "FIREFOX":
                        driver = new FirefoxDriver();
                        driver.manage().window().maximize();
                        break;
                    default:
                        break;
                }

                return driver;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return driver;
    }
}
