@All @Customer
Feature: Customer purchase Functionality

  Background:
    Given I navigate to the StoreFront Demo home page "Customer purchase Functionality Tests"
    When I click on the login link


  Scenario Outline: Customer can delete items from their cart
    And I then enter in username "<username>" and password "<password>"
    And I click on the login button
    And I view the product list and I select a product to view
    And I add the product to my cart
    And I click on the cart image
    And I view items in my cart and I select a product to remove
    And I click on the link remove the item
    Then the removed product should no longer be displayed in the cart items list
    Examples:
      |username |password |
      |ssmith   |password |


  Scenario Outline: Customer can checkout with items in cart and place an order
    And I then enter in username "<username>" and password "<password>"
    And I click on the login button
    And I view the product list and I select a product to view
    And I add the product to my cart
    And I click on the checkout button
    And I click on the place order button
    Then the order should be placed
    Examples:
      |username |password |
      |mweston   |password |