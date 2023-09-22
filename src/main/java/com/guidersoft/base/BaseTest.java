package com.guidersoft.base;

import com.guidersoft.webdriver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BaseTest(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void click(By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);
    }

    public void click(WebElement element){

        // wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        wait.until(driver->{
            try {
                element.click();
                return true;
            }catch (StaleElementReferenceException e){
                return false;
            }catch (Exception e){
                return false;
            }
        });
    }

    public void sendKeys(By locator, CharSequence...text){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendKeys(element, text);

    }

    public void sendKeys(WebElement element, CharSequence...text){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);

    }

    public void hover(By locator){

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        hover(element);
    }

    public void hover(WebElement element){
        new Actions(driver)
                .moveToElement(element).perform();

        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);*/
    }
}
