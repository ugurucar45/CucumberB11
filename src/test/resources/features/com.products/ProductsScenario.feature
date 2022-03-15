@productproject
Feature: Validation of Products

  @productfirst
  Scenario:
    Given the user navigates to product website homepage and click orderButton
    When the user enters the product information "MyMoney" and "3"
    And the users enters the adress information "Techtorial", "2200","des","tx","55111"
    And the users enter the card information "Visa", "3333444455556666","11/23"
    Then the user validates success message
    And the user validates product details "Techtorial","MyMoney","3","2200","des","tx","55111","Visa","3333444455556666","11/23"

  @productOutline
  Scenario Outline: Validation of New Product Creation
    Given the user navigates to product website homepage and click orderButton
    When the user enters the product information "<productName>" and "<quantity>"
    And the users enters the adress information "<customerName>", "<street>","<city>","<state>","<zipcode>"
    And the users enter the card information "<cardType>", "<cardNumber>","<expireDate>"
    Then the user validates success message
    And the user validates product details "<customerName>","<productName>","<quantity>","<street>","<city>","<state>","<zipcode>","<cardType>","<cardNumber>","<expireDate>"

    Examples:
      | productName | quantity | customerName | street | city   | state | zipcode | cardType         | cardNumber   | expireDate |
      | MyMoney     | 3        | Techtorial   | des    | plains | il    | 66332   | Visa             | 111122223333 | 11/22      |
      | FamilyAlbum | 2        | ss           | dd     | ss     | tx    | 77498   | MasterCard       | 111122223333 | 11/22      |
      | ScreenSaver | 2        | ss           | dd     | ss     | tx    | 77498   | American Express | 111122223333 | 11/22      |
