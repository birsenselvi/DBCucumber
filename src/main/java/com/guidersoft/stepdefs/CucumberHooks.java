package com.guidersoft.stepdefs;

import com.guidersoft.webdriver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.guidersoft.utils.Utils;


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
        Utils.sleep(5); //reklam ciktigi icin  süre koyduk
        Driver.quit();
    }

}
