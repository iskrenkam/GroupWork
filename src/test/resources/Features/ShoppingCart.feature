Feature: Shopping Cart functionality

@AddProducts

Scenario: Users should be able to add desired products to cart
  Given User has clicked on the items page
  When User clicks "Add to cart"
  Then User would of added a new item to cart



  @RemoveProducts

  Scenario: Users should be able to remove unwanted items from cart
    Given User is on 'Shopping Cart' tab
    When User clicks on remove button for item
    Then Item would be removed from cart