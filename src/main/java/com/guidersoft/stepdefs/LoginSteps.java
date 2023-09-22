package com.guidersoft.stepdefs;


import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigReader;
import com.guidersoft.pageobjects.HomePage;
import com.guidersoft.pageobjects.LoginSignup;
import com.guidersoft.pageobjects.Menu;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import com.guidersoft.pageobjects.MenuObjects;

import java.util.Map;

public class LoginSteps {

    HomePage home = new HomePage();
    MenuObjects menu = new MenuObjects();
    LoginSignup loginSignup = new LoginSignup();
    @And("user fills the login form as {string}")
    public void userFillsTheLoginFormAs(String userType) {

        /*TestConfig.User user = TestConfigReader.instance().getConfig().getUsers().stream()
                .filter(u->u.getType().equals(userType)).findFirst().get();*/

        /*TestConfig.User user1 = TestConfigReader.instance().getConfig().getUser(userType);
        loginSignup.login(user1.getUsername(), user1.getPassword());*/

        loginSignup.login(userType);
    }

    @Given("user on homepage")
    public void userOnHomepage() {
        home.gotoPage();

    }

    @And("user should be successful")
    public void userShouldBeSuccessful() {

        Menu.LOGOUT.shouldBeVisible();

        // Enter Account Information--Signup sonrasi
        Menu.ENTERACCOUNT.shouldBeVisible();


    }

    @When("^user clicks (LOGIN|SIGNUP|HOME|CART|PRODUCTS|CONTACTUS) on menu$")
    public void userClicksOnMenu(String menuText) {
     /*   String locatorStr = "//ul[@class='nav navbar-nav']//a[contains(., %s)]";
        By locator = null;*/
        switch (menuText){
            case "LOGIN":
                menu.signupLogin.click();
            break;
            case "HOME":
                menu.home.click();
                break;
            case "CART":
                menu.cart.click();
                break;
            case "PRODUCTS":
                menu.products.click();
                break;
            case "CONTACTUS":
                menu.contactUs.click();
                break;


        }

    }
     @When("^user clicks (LOGIN|SIGNUP|HOME|CART|PRODUCTS|CONTACTUS) on menu with Enum$")
    public void userClicksOnMenuWithEnum(String menuText) {
     /*   String locatorStr = "//ul[@class='nav navbar-nav']//a[contains(., %s)]";
        By locator = null;*/

              Menu.valueOf(menuText).click();

        /*switch (menuText){
            case "LOGIN":
                Menu.LOGIN.click();
                break;
            case "HOME":
               Menu.HOME.click();
                break;
            case "CART":
                Menu.CART.click();
                break;
            case "PRODUCTS":
                Menu.PRODUCTS.click();
                break;
            case "CONTACTUS":
                Menu.CONTACTUS.click();
                break;
        }*/

    }

    @When("verify that home page is visible successfully")
    public void verifyThatHomePageIsVisibleSuccessfully() {
        Menu.LOGO.shouldBeVisible();
    }

    @And("Verify {string} is visible")
    public void verifyNewUserSignupIsVisible() {

        Menu.TEXTSIGNUP.shouldBeVisible();

    }


    @And("user fills the New User Sigup form as follows")
    public void userFillsTheNewUserSigupFormAsFollows(DataTable table) {
        Map<String, String> data = table.asMap();
        String name = data.get("name");
        String email = data.get("email");
        loginSignup.signup(name, email);
    }
}
