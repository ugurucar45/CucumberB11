Feature: Login Functionality for WebOrder Page
  Scenario: Validation of WebOrder Login Positive Scenario
    Given the user navigates to the WebOrder website
    When the user provides credentials
    Then the user is on the home page

  Scenario: Validation of WebOrder Login Negative Scenario 1
    Given the user navigates to the WebOrder website again
    When the user provides correct username and wrong password
    Then the user validates the "Sign in Failed" errorMessage

  Scenario: Validation of WebOrder Login Negative Scenario 2
    Given the user navigates to the WebOrder website again
    When the user provides wrong "username" and "password"
    Then the user validates the "Sign in Failed" errorMessage

    #last scenario 3 should be provided empty for both
  #and validate same message. parameters are not necessary
  Scenario: Validation of WebOrder Login Negative Scenario 3
    Given the user navigates to the WebOrder website again
    When the user provides wrong "" and ""
    Then the user validates the "Sign in Failed" errorMessage