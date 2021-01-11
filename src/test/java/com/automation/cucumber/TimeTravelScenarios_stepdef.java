package com.automation.cucumber;

import com.automation.cucumber.CucumberContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class TimeTravelScenarios_stepdef {

    CucumberContext context;

    public TimeTravelScenarios_stepdef(CucumberContext context)
    {
        System.out.println("************** context constructor ********************");
        this.context= context;
    }

    @Given("user has waited for {string} seconds")
    public void user_waiting(String seconds) throws Exception
    {
        Thread.sleep(Integer.parseInt(seconds));
    }

    @When("user has to travel {int} days")
    public void time_travel(String days) throws Exception
    {
    }

    @Then("validates that the scenarios completes successfully")
    public void successful() throws Exception
    {

    }
}


