@loginPageOutline
Feature:Login Functionality for WebOrder Page

  Background:
    Given the user navigates to the WebOrder website

  Scenario: Validation of WebOrder Login Positive Scenario
    When the user provides credentials
    Then the user is on the home page

  Scenario Outline: Validation of WebOrder Login Negative Scenario
    When the user provides wrong "<username>" and "<password>"
    Then the user validates the "<validates>" errorMessage
    Examples:
      | username              | password | validates      |

      | ugur                  | ucar     | Sign in Failed |
      | admin                 | 1234     | Sign in Failed |
      |                       |          | Sign in Failed |
      | admin                 |          | Sign in Failed |
      |                       | password | Sign in Failed |
      | guest1@microworks.com |          | Sign in Failed |
      |                       | Guest1!  | Sign in Failed |
      | guest1@microworks.com | 1234     | Sign in Failed |
      | 1234                  | Guest1!  | Sign in Failed |
      | ss                    | dd       | Sign in Failed |





  #Do not touch the positive scenario
    #Create as many as negative scenario with scenario outline