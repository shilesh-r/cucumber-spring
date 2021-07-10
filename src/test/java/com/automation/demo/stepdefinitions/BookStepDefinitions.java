package com.automation.demo.stepdefinitions;

import com.automation.demo.integration.SpringIntegration;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookStepDefinitions extends SpringIntegration {
    @Given("User creates a request to add books with below data")
    public void userCreatesARequestToAddBooksWithBelowData(DataTable books) {
    }

    @When("User submits {string} endpoint")
    public void userSubmitsEndpoint(String endpoint) {
    }

    @Then("Verify {string} response")
    public void verifyResponse(String responseStatus) {
    }
}
