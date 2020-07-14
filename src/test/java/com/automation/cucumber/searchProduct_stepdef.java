package com.automation.cucumber;

import com.automation.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class searchProduct_stepdef {

    CucumberContext context;

    public searchProduct_stepdef(CucumberContext context)
    {
        this.context= context;
    }

    @When("user enters the {string} in searchbox and click search")
    public void enter_product_name_in_searchbox(String product) throws Exception {
        //context.driver.navigate().to("https://www.amazon.co.uk");
        com.automation.pom.LandingPage.enterProductNameToSearch(context.driver,product);
    }

    @Then("user gets search results")
    public void verify_search() throws Exception{
        com.automation.pom.LandingPage.clickSearchButton(context.driver);
    }
}
