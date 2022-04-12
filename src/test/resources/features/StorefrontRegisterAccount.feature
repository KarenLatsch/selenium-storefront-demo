Feature: Register Account Functionally
  This is to validate that a user can register a new account.

  @All @Storefront
  Scenario Outline: User should be able to register a new account as new user.
    Given I navigate to the StoreFront Demo home page "Register Account Functionally Test"
    When I click on the register to buy
    And I enter in the customer's information
      |firstName      |Karen              |
      |lastName       |Latsch             |
      |email          |myemail@gmail.com  |
      |phoneNumber    |6189901234         |
      |address1       |123 North Main     |
      |address2       |" "                |
      |city           |Collinsville       |
      |state          |IL                 |
      |zip            |62234              |
      |username       |klatsch2           |
      |password       |password           |
      |confirmPassword|password           |
    And I click on the update button
    Then the new account should be "<result>"
    Examples:
      |result|
      |added |
      |not added|