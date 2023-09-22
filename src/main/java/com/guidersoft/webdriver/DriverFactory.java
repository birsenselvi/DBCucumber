package com.guidersoft.webdriver;

import com.guidersoft.config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class DriverFactory {

    private static ChromeDriver createChrome(TestConfig config){
        ChromeOptions options = new ChromeOptions();
        for (String option : config.getChrome().getOptions()) {
            if(option.trim().length()>0)
            options.addArguments(option);

        }
        options.addExtensions(new File("crx/add_blocker_extension_4_44_0_0 (14).crx"));
        return new ChromeDriver(options);

    }

    private static EdgeDriver createEdge(TestConfig config){
        EdgeOptions options = new EdgeOptions();
        for (String option : config.getEdge().getOptions()) {
            if(option.trim().length()>0)
            options.addArguments(option);
        }
        return new EdgeDriver(options);

    }
    private static FirefoxDriver createFireFox(TestConfig config){
        FirefoxOptions options = new FirefoxOptions();
        return new FirefoxDriver();

    }
    public static WebDriver createDriver(TestConfig config){

        switch (config.getTests().getBrowser()){
            case EDGE:
                return createEdge(config);
            case CHROME:
                return createChrome(config);
            case FIREFOX:
                return createFireFox(config);
            default:
                throw new RuntimeException(config.getTests().getBrowser()+ " ");
        }

    }

}
