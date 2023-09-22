package com.guidersoft.pageobjects;

import com.guidersoft.webdriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public enum Menu {
    HOME(By.xpath( "//ul[@class='nav navbar-nav']//a[contains(., 'Home')]")),
    LOGIN (By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Signup / Login')]")),
    SIGNUP(By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Signup / Login')]")),
    CART(By.xpath(( "//ul[@class='nav navbar-nav']//a[contains(., 'CART')]"))),
    PRODUCTS (By.xpath( "//ul[@class='nav navbar-nav']//a[contains(., 'Products')]")),
    CONTACTUS(By.xpath( "//ul[@class='nav navbar-nav']//a[contains(., 'Contact us')]")),
    LOGOUT(By.xpath( "//ul[@class='nav navbar-nav']//a[contains(., 'Logout')]")),
    DELETEACCOUNT(By.xpath( "//ul[@class='nav navbar-nav']//a[contains(., 'Delete Account')]")),
    LOGO(By.xpath("//div[@class='logo pull-left']")),
    TEXTSIGNUP(By.xpath("//h2[text()='New User Signup!']")),
    ENTERACCOUNT(By.xpath("//h2[@class='title text-center']"));
    private By locator;

    Menu(By locator){
        this.locator = locator;
    }
    public void click(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }
    public void shouldBeVisible(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }



}
