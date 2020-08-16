package com.automation.cucumber;

import com.automation.pom.TopMenu;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;


public class searchProduct_stepdef {

    CucumberContext context;

    public searchProduct_stepdef(CucumberContext context)
    {
        this.context= context;
    }

    @When("user enters the {string} in searchbox and click search")
    public void enter_product_name_in_searchbox(String product) throws Exception {
        //context.driver.navigate().to("https://www.amazon.co.uk");
        TopMenu.enterProductNameToSearch(context.driver,product);
    }

    @When("select the department")
    public void select_the_department(DataTable departments) throws Exception {
        //context.driver.navigate().to("https://www.amazon.co.uk");
        List<Map<String,String>> listofValues = departments.asMaps(String.class, String.class);
        System.out.println(listofValues.get(0).get("Department").trim());
        TopMenu.selectDepartment(context.driver,listofValues.get(0).get("Department").trim());
    }

    @Then("user gets search results")
    public void verify_search() throws Exception{
        TopMenu.clickSearchButton(context.driver);
    }
}
