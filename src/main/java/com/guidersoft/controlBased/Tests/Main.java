package com.guidersoft.controlBased.Tests;

import com.guidersoft.base.BaseTest;
import com.guidersoft.controlBased.controls.ButtonControl;
import com.guidersoft.controlBased.controls.TextFieldConrol;
import org.junit.Test;
import org.openqa.selenium.By;

public class Main extends BaseTest {
   /* @Test
    public void test1(){
        By username = By.xpath("");
        ButtonControl button = new ButtonControl(username);
        button.click();
    ButtonControl class inda constructer private yapip klass in kendi icerisinde obje olusturma
     islemini gerceklestirdik bu yüzden bu duruma gerek kalmadi
    }*/
    @Test
    public void test2(){
        ButtonControl.fromText("Continue").click();
        TextFieldConrol.fromText("Username").sendKeys("user");


    }
}
