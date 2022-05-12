Feature: Login Functionality
  This is to verify that only users with valid credentials are able to login into MyStoreFront Demo.

  Scenario Outline: User should only be able to login with valid credentials
    Given I navigate to the StoreFront Demo home page
    When I click on the login link
    And I then enter in username "<username>" and password "<password>"
    And I click on the login button
    Then the login status as of "<loginstatus>" should be expected
    Examples:
      |username   |password   |loginstatus
      |ssmith    |password   |successful
      |           |           |failure
      |tomsmith  |nopass     |failure
      |mweston   |password   |successful
