package com.automation.cucumber;

import com.automation.DriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class loginAmazon_stepdef {

    static WebDriver driver;

    @Given("User is on {string}")
    public static void navigate_to_url(String url) throws Exception
    {
        driver = DriverSetup.getDriver();
        driver.navigate().to(url);
    }

    @When("user enter user name as {string}")
    public void enterUserName(String userName) throws Exception {
       com.automation.pom.LandingPage.clickSignIn(driver);
       com.automation.pom.Login.enterUserName(driver,userName);
    }

    @When("user enters password as {string}")
    public void enterpassword(String password) throws Exception {
        com.automation.pom.Login.clickContinue(driver);
        com.automation.pom.Login.enterPassword(driver,password);
    }

    @Then("User is unable to login successfully")
    public void clickSignIn() throws Exception {
        com.automation.pom.Login.clickLogin(driver);
        driver.quit();
    }


}
