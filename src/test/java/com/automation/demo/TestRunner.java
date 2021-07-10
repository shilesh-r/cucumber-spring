package com.automation.demo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-html-report",
        "json:target/cucumber-reports/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"com.automation.demo.stepdefinitions", "com.automation.demo.integration"},
        publish = true
)
public class TestRunner {
}
