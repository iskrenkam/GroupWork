Feature: Sign in function

  @SignIn
  Scenario: Logging in with valid details
    Given I have navigated to the login page
    When I input valid details
    | | |
    And Hit Enter
    Then I am logged in successfully