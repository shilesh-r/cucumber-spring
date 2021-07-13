package com.automation.demo.stepdefinitions;

import com.automation.demo.api.ApiHelper;
import com.automation.demo.integration.SpringIntegration;
import com.automation.demo.models.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class BookStepDefinitions extends SpringIntegration {

    List<Book> addBookRequests;
    List<Map<String, String>> addBookResponses;
    ApiHelper apiHelper;
    ObjectMapper objectMapper;

    @Before
    public void setUp() {
        addBookRequests = new ArrayList<>();
        addBookResponses = new ArrayList<>();
        apiHelper = new ApiHelper();
        objectMapper = new ObjectMapper();
    }

    @Given("User creates a request to add books with below data")
    public void userCreatesARequestToAddBooksWithBelowData(DataTable books) {
        Book addBookRequest;

        List<Map<String, String>> requestRows = books.asMaps(String.class, String.class);

        for (Map<String, String> requestRow : requestRows) {
            addBookRequest = new Book();
            addBookRequest.setTitle(requestRow.get("Title"));
            addBookRequest.setAuthor(requestRow.get("Author"));
            addBookRequests.add(addBookRequest);
        }
    }

    @When("User submits {string} endpoint")
    public void userSubmitsEndpoint(String endpoint) {
        for (Book addBookRequest : addBookRequests) {
            addBookResponses.add(apiHelper.submitPostRequestAndReturnResponseString("http://localhost:8081/api/books", addBookRequest));
        }
    }

    @Then("Verify {string} response")
    public void verifyResponse(String responseStatus) {
        for(Map<String, String> addBookResponse: addBookResponses) {
            Assert.assertEquals("Add Book Response code is not as expected", responseStatus, addBookResponse.get("ResponseCode"));
        }
    }
}
