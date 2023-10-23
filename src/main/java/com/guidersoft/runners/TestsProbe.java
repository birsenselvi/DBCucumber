package com.guidersoft.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features/02ContactUs.feature"},
        glue = {"com/guidersoft/stepdefs"},
        plugin = {"pretty"},tags = "@ContactUs"
)
public class TestsProbe {
}
