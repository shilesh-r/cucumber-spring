Feature: Acceptance Tests for Books Application

  @AddBooks
  Scenario: Verify new books can be added to the Books application
    Given User creates a request to add books with below data
      | Title                  | Author    |
      | Jack Reacher: One Shot | Lee Child |
    When User submits "Post" endpoint
    Then Verify "201" response
