package com.automation.cucumber;

import com.automation.DriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class searchProduct_stepdef {

    static WebDriver driver= null;

    @When("user enters the {string} in searchbox and click search")
    public void enter_product_name_in_searchbox(String product) throws Exception {
        if(driver== null)
            driver = DriverSetup.getDriver();
        driver.navigate().to("https://www.amazon.co.uk");
        com.automation.pom.LandingPage.enterProductNameToSearch(driver,product);
    }

    @Then("user gets search results")
    public void verify_search() throws Exception{
        com.automation.pom.LandingPage.clickSearchButton(driver);
        driver.quit();
    }
}
