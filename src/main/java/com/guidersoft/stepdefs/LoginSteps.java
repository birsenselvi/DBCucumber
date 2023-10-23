package com.guidersoft.stepdefs;



import com.guidersoft.base.BaseTest;
import com.guidersoft.pageobjects.HomePage;
import com.guidersoft.pageobjects.LoginSignup;
import com.guidersoft.pageobjects.Menu;
import com.guidersoft.utils.Utils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.guidersoft.pageobjects.MenuObjects;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class LoginSteps extends BaseTest {

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
        switch (menuText) {
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

    @When("^user clicks (LOGIN|SIGNUP|HOME|CART|PRODUCTS|CONTACTUS|DELETEACCOUNT) on menu with Enum$")
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

    @And("user login with following credentials")
    public void userLoginWithFollowingCredentials(DataTable table) {
        Map<String, String> data = table.asMap();
        String email = data.get("email");
        String password = data.get("password");
        loginSignup.login(email, password);
    }


    @And("user fills the New User Sigup form as follows then clicks signup")
    public void userFillsTheNewUserSigupFormAsFollows(DataTable table) {
        Map<String, String> data = table.asMap();
        String name = data.get("name");
        String email = data.get("email");
        loginSignup.signup(name, email);
    }

    @Then("login should be successful")
    public void loginShouldBeSuccessful() {

        // Menu.LOGOUT.shouldBeVisible();
    }

    Properties properties = new Properties();

    @When("user save {string} as {string}")
    public void userSaveAs(String variable, String value) {
        properties.setProperty(variable, value);
    }

    @Then("{string} degeri {string} olmali")
    public void degeriOlmali(String variable, String value) {
        String val = properties.getProperty(variable);
        Assert.assertEquals(val, value);
    }

    @When("user fill the input {string} as {string}")
    public void userFillTheInputAs(String arg0, String arg1) {

    }

    @And("user clicks the button {string}")
    public void userClicksTheButton(String labelOrAttribute) {
        click(getButton(labelOrAttribute));

    }

    @Then("verify the text {string} is visible")
    public void verifyTheTextIsVisible(String text) {
        String body = driver.findElement(By.cssSelector("body")).getText();
        Assert.assertTrue(body.contains(text));
    }

    @Then("title should be {string}")
    public void titleShouldBe(String title) {
       // Assert.assertTrue(driver.getTitle().contains(title));
        Utils.sleep(2);
        wait.until(ExpectedConditions.titleContains(title));
    }
    @And("user select {string} as Day, {string} as Month, {string} as Year")
    public void userSelectAsDayAsMonthAsYear(String day, String month, String year) {
        Select selectDay = new Select(loginSignup.registerDayOfBirth);
        selectDay.selectByVisibleText(day);

        Select selectMonth = new Select(loginSignup.registerMonthOfBirth);
        selectMonth.selectByVisibleText(month);

        Select selectYear = new Select(loginSignup.registerYearOfBirth);
        selectYear.selectByVisibleText(year);

    }

    @And("user fill the registerform as follows")
    public void userFillTheRegisterformAsFollows(DataTable table) {

        Map<String, String> data = table.asMap();

        sendKeys(getInput("Password"), data.get("Password"));
        select("days",data.get("days"));
        select("months",data.get("months"));
        select("years",data.get("years"));
        sendKeys(getInput("First name"), data.get("First name"));
        sendKeys(getInput("Last name"), data.get("Last name"));
        sendKeys(getInput("Company"), data.get("Company"));
        sendKeys(getInput("Address *"), data.get("Address *"));
        sendKeys(getInput("Address 2"), data.get("Address 2"));
        sendKeys(getInput("Country "), data.get("Canada"));
        sendKeys(getInput("State"), data.get("State"));
        sendKeys(getInput("City"), data.get("City"));
        sendKeys(getInput("Zipcode"), data.get("Zipcode"));
        sendKeys(getInput("Mobile Number"), data.get("Mobile Number"));

    }

    @Then("the text {string} is visible")
    public void theTextIsVisible(String text) {

        By locator = By.xpath("//*[contains(text(), '"+ text +"')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

       /* String body = driver.findElement(By.cssSelector("body")).getText();
        Assert.assertTrue(body.contains(text));*/
    }
    @Then("the text {string} is not visible")
    public void theTextIsInVisible(String text) {

        By locator = By.xpath("//*[contains(text(), '"+ text +"')]");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

        /*String body = driver.findElement(By.cssSelector("body")).getText();
        Assert.assertFalse(body.contains(text));*/
    }

    @When("user fill the registerform as follows with list")
    public void userFillTheRegisterformAsFollowsWithList(DataTable table){

        List<List<String>> data = table.asLists();
        for(List<String> row : data){
            switch (row.get(0)){
                case "input" :
                    sendKeys(getInput(row.get(1)), row.get(2));
                    break;
                case "select":
                    select(row.get(1), row.get(2));
                    break;
                case "checkbox" :
                    getCheckbox(row.get(1), row.get(2));
                    break;
                case "radio" :
                    getGender(row.get(1), row.get(2));
                    break;
                case "button":
                    click(getButton(row.get(1)));

            }
        }
    }
}
