package com.guidersoft.stepdefs;

import com.guidersoft.webdriver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;


public class CucumberHooks {

    // before scenario
    @Before
    public void beforeScenario(){
        Driver.getDriver();
    }

    @AfterStep
    public void afterStep(Scenario scenario){
      if(scenario.isFailed()){
          byte[] resim = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        //  Allure.addAttachment("Screenshot", new ByteArrayInputStream(resim));

          // hem extend reporta hemde Allureye scrennshot i ekler.
          scenario.attach(resim, "image/png", "Screenshot");
          scenario.log(scenario.getName() + " is failed");

      }
    }

    // after scenario
    @After
    public void afterScenario(){
        Driver.quit();
    }

}
