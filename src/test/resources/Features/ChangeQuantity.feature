@AUT-19
 Feature:  Change the quantity of the product & basket

   @ChangingQuantityOfProduct
   Scenario: Trying to change the quantity of the product
     Given I am on the homepage
     When I click on the product I want
     And I will change the quantity of the product
     Then I will add product to cart

