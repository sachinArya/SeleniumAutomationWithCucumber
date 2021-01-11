package com.automation.cucumber;

import com.automation.cucumber.CucumberContext;
import com.automation.pom.SearchPage;
import com.automation.pom.TopMenu;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

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
        TopMenu.enterProductNameToSearch(context.driver,product);
    }

    @When("select the department")
    public void select_the_department(DataTable departments) throws Exception {
        List<Map<String,String>> listofValues = departments.asMaps(String.class, String.class);
        TopMenu.selectDepartment(context.driver,listofValues.get(0).get("Department").trim());
    }

    @Then("user gets search results")
    public void verify_search() throws Exception{
        TopMenu.clickSearchButton(context.driver);
        Assert.assertTrue(SearchPage.isSearchPageLoaded(context.driver),"Unable to show search results");

    }

    @Then("user sorts the item by {string}")
    public void sort_Item(String sortBy) throws Exception{
        //TopMenu.clickSearchButton(context.driver);
        SearchPage.sort(context.driver,sortBy);
    }

    @And("filter results for free UK delivery")
    public void filterForUKDelivery() throws Exception
    {
        SearchPage.selectFreeUKDelivery(context.driver);
        Thread.sleep(5000);
    }

}
