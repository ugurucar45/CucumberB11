Feature: WebOrder Page Food Order

  Background:
    Given the user is on weborder homepage
    When the user selects "Office" options
    And the user is on the groupOrderPage
    And the user sends invites note "Test"
    And the user sends invite list "ugur@gmail.com" and "eric@gmail.com"

  Scenario: Validation of Food order For Office
    Then the user validate the "2012 EMPIRE BLVD" adress
    * the user validates "View Group Order" text
    * the user validates total participants is 1

  Scenario: Validation of Food order For My House
    #Given the user is on weborder homepage
#    When the user selects "Office" options
#    And the user is on the groupOrderPage
#    And the user sends invites note "Test"
#    And the user sends invite list "ugur@gmail.com" and "eric@gmail.com"
    And the user selects "  My House" options
    Then the user validate the "2112 EMPIRE BLVD" adress
    * the user validates "View Group Order" text
    * the user validates total participants is 1
