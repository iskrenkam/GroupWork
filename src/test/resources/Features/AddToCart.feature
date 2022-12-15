@AUT-9
Feature: Cart Functionality

  @AddItemToCart
  Scenario: Adding Item to Cart
    Given I have navigated to an item Page
    When I click add to cart
    Then Item is added to cart
