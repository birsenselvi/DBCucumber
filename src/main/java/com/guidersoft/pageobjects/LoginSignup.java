package com.guidersoft.pageobjects;

import com.guidersoft.base.BaseTest;
import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSignup extends BaseTest {
    public LoginSignup(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".login-form [name='email']")
    public WebElement inputLoginEmail;
    @FindBy(css = ".login-form [name='password']")
    public WebElement inputLoginPassword;
    @FindBy(css = ".login-form button")
    public WebElement buttonLogin;

    @FindBy(css = ".signup-form [name='email']")
    public WebElement inputSignupEmail;
    @FindBy(css = ".signup-form [name='name']")
    public WebElement inputSignupName;
    @FindBy(css = ".signup-form button")
    public WebElement buttonSignup;

    public void login(String email, String password){

        sendKeys(inputLoginEmail, email);
        sendKeys(inputLoginPassword, password);
        click(buttonLogin);
    }

    public void login(String userType){
        TestConfig.User user = TestConfigReader.instance().getConfig().getUser(userType);
        login(user.getUsername(), user.getPassword());


    }

    public void signup(String name, String email){

        sendKeys(inputSignupName, name);
        sendKeys(inputSignupEmail, email);
        click(buttonSignup);

    }

   /* public static By textSignupLogin(String label){
        String xpath = "//h2[text()= " + label + "]";
        return By.xpath(xpath);


    }*/
}
