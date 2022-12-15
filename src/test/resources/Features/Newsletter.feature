@AUT-11
  Feature: Newspaper subscription
    @positiveSubscribe
    Scenario: Subscribing to Newspaper
      Given I have navigated to the HomePage
      When I input email into newsletter
      And Hit Subscribe
      Then I am successfully subscribed to the newsletter

      @NegativeSubscribe
      Scenario: Attempt to sign up to newsletter with already registered email
        Given I have navigated to the HomePage
        When I input email into newsletter
        And Hit Subscribe
        Then An error message is displayed