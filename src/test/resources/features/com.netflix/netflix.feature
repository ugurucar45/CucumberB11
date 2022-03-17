Feature:

  Scenario: Negative scenario for login
    Given I navigate to Netflix login page
    When I enter not valid email
    And I enter not valid password
    And I click submit button
    Then I see Incorrect password element