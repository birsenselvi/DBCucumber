package com.guidersoft.controlBased.controls;

import com.guidersoft.controlBased.baseControl.BaseControl;
import com.guidersoft.webdriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonControl extends BaseControl {

    private static final String BUTTON1 ="//button[contains(. , '%s')]";
    private static final  String BUTTON2 ="//label[text()='%s']//parent::div//input[@type = 'button']";
    private static final  String BUTTON3 ="//label[text()='%s']//parent::div//button";

    public static ButtonControl fromText(String text){
        String locator1 = String.format(BUTTON1,text);
        String locator2 = String.format(BUTTON2,text);
        String locator3 = String.format(BUTTON3,text);
        String xpath = locator1 + " | " + locator2 + " | " + locator3;
        By locator= By.xpath(xpath);
        return  new ButtonControl(locator);
    }
    private ButtonControl(By locator){

        super(locator);

    }
    public String getText(){
        return element.getText();
    }

  public ButtonControl send(){
        return this;
    }
}
