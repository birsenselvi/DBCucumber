package com.guidersoft.pageobjects;

import com.guidersoft.base.BaseTest;
import com.guidersoft.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Map;

public class ContactUs extends BaseTest {
    public ContactUs(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name = 'name']")
    public WebElement name;
    @FindBy(css = "inpu[name='email']")
    public WebElement email;
    @FindBy(id = "message")
    public WebElement message;
    @FindBy(css = "input[name ='subject']")
    public WebElement subject;
    @FindBy(xpath = "//h2[.='Contact US']")
    public WebElement title;
    @FindBy(css = "input[name = 'submit']")
    public WebElement submit;
    @FindBy(css = "input[name = 'upload_file']")
    public WebElement file;

    public void pageISVisible(){
        wait.until(ExpectedConditions.visibilityOf(title));
    }
    public void fillTheFormAndSubmit(Map<String, String> map){
        sendKeys(name, map.get("name"));
        sendKeys(email, map.get("email"));
        sendKeys(subject, map.get("subject"));
        sendKeys(message, map.get("message"));
       /* Robot robot;
        try {
           robot = new Robot();
           Thread.sleep(500);
            Utils.write(robot, map.get("file"));
            robot.keyPress(KeyEvent.VK_ENTER);
        }catch (Exception e){
            throw new RuntimeException();
        }

        Utils.sleep(5);*/

         sendKeys(file, map.get("file"));
         click(submit);
    }


}
