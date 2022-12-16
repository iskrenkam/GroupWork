@AUT-16
  Feature: Checkout
    @SuccessfulCheckout
    Scenario: Checkout successfully with one item
      Given I have navigated to the checkout page
      And I have one item in the cart
      When I click checkout
      Then I have navigated to the Checkout page
