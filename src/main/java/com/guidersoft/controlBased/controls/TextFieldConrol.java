package com.guidersoft.controlBased.controls;

import com.guidersoft.controlBased.baseControl.BaseControl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextFieldConrol extends BaseControl {
   private static final String TEXTFIELD1 ="//button[contains(. , '%s')]";
   private static final String TEXTFIELD2 ="//label[text()='%s']//parent::div//input";
   private static final String OPTION ="//label[text()='%s']//parent::div//input";

    public static TextFieldConrol fromText(String text){
        String locator1 = String.format(TEXTFIELD1,text);
        String locator2 = String.format(TEXTFIELD2,text);
        String xpath = locator1 + " | " + locator2;
        By locator= By.xpath(xpath);
        return  new TextFieldConrol(locator);
    }
    private TextFieldConrol(By locator){

        super(locator);

    }
    public String getValue(){
        return element.getAttribute("value");
    }
    public void sendKeys(CharSequence...sequences){
       element.sendKeys(sequences);

    }
    public void select(String textBox){
        By locator = By.xpath(String.format(OPTION, textBox));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
