Feature: Customer Account Functionality

  Background:
    Given I navigate to the StoreFront Demo home page
    When I click on the login link

  Scenario Outline: Customer can change their current password to a new password
    And I then enter in username "<username>" and password "<password>"
    And I click on the login button
    And I click on the my account link
    And I click on the change password link
    And I enter in current password "<currentPassword>" and new password "<newPassword>" and confirm password "<confirmedPassword>"
    And I click on the change password button
    Then the password should be "<result>"
    Examples:
      |username |password |currentPassword   |newPassword|confirmedPassword|result    |
      |ssmith   |password |password          |password2  |password2      |changed     |
      |ssmith   |password2|password2         |pass111    |pass           |not changed |
      |ssmith   |password2|password          |newpass    |newpass        |not changed |
      |ssmith   |password2|password2         |password   |password       |changed     |

  Scenario Outline: Customer can change their current account information
    And I then enter in username "<username>" and password "<password>"
    And I click on the login button
    And I click on the my account link
    And I click on the customer information link
    And I enter the following customer data
      |firstName      |Staceyx             |
      |lastName       |Smithx              |
      |email          |myemail@gmail.com  |
      |phoneNumber    |6189901234         |
      |address1       |123 North Mainx     |
      |address2       |" "                |
      |city           |Collinsville       |
      |state          |IL                 |
      |zip            |62234              |
      |username       |ssmith             |
    And I click on the update information button
    Then the customer's information should be "<expectedResult>"
    Examples:
      |username |password |expectedResult|
      |ssmith   |password |changed |
      |mweston  |password |not changed|

  Scenario Outline: Customers credit card list must match the credit card information on edit screen
    And I then enter in username "<username>" and password "<password>"
    And I click on the login button
    And I click on the my account link
    And I click on the credit cards link
    And I select the first credit card listed
    And I click on the credit card edit link
    Then the card type and card number should match the information from the credit card list
    Examples:
      |username |password |
      |ssmith   |password |

  Scenario Outline: Customers can add a credit card to their account information
    And I then enter in username "<username>" and password "<password>"
    And I click on the login button
    And I click on the my account link
    And I click on the credit cards link
    And I click on the add credit card link
    And I enter in the following credit card information
      |firstName      |Stacey             |
      |lastName       |Smith              |
      |email          |myemail@gmail.com  |
      |phoneNumber    |6189901234         |
      |address1       |123 North Main     |
      |address2       |" "                |
      |city           |Collinsville       |
      |state          |IL                 |
      |zip            |62234              |
      |creditCardType |VISA               |
      |cardNumber     |1234567890123456   |
      |expMonth       |12                 |
      |expYear        |2023               |
      |verificationCode  |987             |
    And I click on the update credit card information button
    Then the new credit card should be added to the customer's credit list
    Examples:
      |username |password |
      |ssmith   |password |

  Scenario Outline: Customers can delete a credit card from their account information
    And I then enter in username "<username>" and password "<password>"
    And I click on the login button
    And I click on the my account link
    And I click on the credit cards link
    And I select the first card number to delete
    And I click on the delete link for selected credit card
    Then the deleted credit card should no longer be displayed in the list
    Examples:
      |username |password |
      |ssmith   |password |