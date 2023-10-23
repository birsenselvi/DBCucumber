package com.guidersoft.base;

import com.guidersoft.webdriver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public static final String INPUT = "//*[starts-with(.,'%s')]/parent::*//input";
    public static final String ATTRIBUTE = "//*[@*[.='%s']]";
    public static final String BUTTON1 = "//button[starts-with(.,'%s')]";
    public static final String SELECT = "//*[starts-with(.,'%')]/parent::*//select";

    protected BaseTest(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void click(By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);
    }
    public void getGender(String genderAttribute, String text){
        String gender = String.format(ATTRIBUTE,genderAttribute);
        By xpath = By.xpath(gender);
        wait.until(ExpectedConditions.elementToBeClickable(xpath)).click();

    }
    public void getCheckbox(String checkboxInput, CharSequence...text){
        String checkbox = String.format(INPUT, checkboxInput);
        By xpath = By.xpath(checkbox);
        wait.until(ExpectedConditions.elementToBeClickable(xpath)).click();
    }

    public void click(WebElement element){

        // wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        wait.until(driver->{
            try {
                scrollIntoView(element);
                element.click();
                return true;
            }catch (StaleElementReferenceException e){
                return false;
            }catch (Exception e){
                try{
                    new Actions(driver).moveToElement(element).click().perform();
                    return true;
                }catch (Exception e1){
                    try{
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("arguments[0].click()", element);
                        return true;
                    }catch (Exception e2){
                        return false;
                    }
                }
            }
        });
    }
    public void clickByActions(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        new Actions(driver).moveToElement(element).click().perform();
    }



    public WebElement getButton(String text){
     return  getButton(text, 1);

    }
    public WebElement getButton(String text,int index){
        String button1 = String.format(BUTTON1,text);
        String button2 = String.format(ATTRIBUTE,text);
        String xpath = "(" + button1 + "|"+ button2 + ")[" + index +"]";
        By locator = By.xpath(xpath);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement getInput(String text){
        return getInput(text, 1);
    }
    public WebElement getInput(String text, int index){
        String input1 = String.format(INPUT, text);
        String attribute = String.format(ATTRIBUTE, text);

        String xpath = "(" +  input1 + " | " + attribute + ")[" + index + "]";
        By locator = By.xpath(xpath);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
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

    public void select(String labelOrAttribute, String text){
        String select1 = String.format(ATTRIBUTE,labelOrAttribute);
        By xpath = By.xpath(select1);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    public void scrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }
}
