package com.automation.demo.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookStepDefinitions {
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
