package com.automation.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.openqa.selenium.WebDriver;

public class loginAmazon_stepdef  {

    CucumberContext context;

    public loginAmazon_stepdef(CucumberContext context)
    {
        this.context= context;
    }

    @Given("User is on {string}")
    public void navigate_to_url(String url) throws Exception
    {
        //context.driver = DriverSetup.getDriver();
        context.driver.navigate().to(url);
    }

    @When("user enter user name as {string}")
    public void enterUserName(String userName) throws Exception {
       com.automation.pom.LandingPage.clickSignIn(context.driver);
       com.automation.pom.Login.enterUserName(context.driver,userName);
    }

    @When("user enters password as {string}")
    public void enterpassword(String password) throws Exception {
        com.automation.pom.Login.clickContinue(context.driver);
        com.automation.pom.Login.enterPassword(context.driver,password);
    }

    @Then("User is unable to login successfully")
    public void clickSignIn() throws Exception {
        com.automation.pom.Login.clickLogin(context.driver);
    }



}
