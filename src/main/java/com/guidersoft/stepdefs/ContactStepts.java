package com.guidersoft.stepdefs;

import com.guidersoft.base.BaseTest;
import com.guidersoft.pageobjects.ContactUs;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class ContactStepts extends BaseTest {
    ContactUs contactUs = new ContactUs();
    @Then("^the (CONTACT|HOME|SIGNUP|CART|LOGIN) page should be visible$")
    public void thePageShouldBeVisible(String page) {
        switch (page){
            case "CONTACT":
                contactUs.pageISVisible();
                break;

        }
    }

    @When("user submits the contact form as follows")
    public void userSubmitsTheContactFormAsFollows(DataTable table) {
        Map<String, String> map = table.asMap();
        contactUs.fillTheFormAndSubmit(map);
    }

    @Then("accept popup")
    public void acceptPopup() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();

    }
    @Then("dismiss popup")
    public void dismissPopup() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }
}
