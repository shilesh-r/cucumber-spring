package com.automation.demo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"com.automation.demo.stepdefinitions", "com.automation.demo.integration","com.automation.demo.api"},
        publish = true
)
public class TestRunner {
}
