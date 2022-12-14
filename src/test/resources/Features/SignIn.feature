@AUT-4
Feature: Sign in function

  @SignIn
  Scenario: Logging in with valid details
    Given I have navigated to the login page
    When I input details
      | Email    | Test@TestTest.com |
      | Password | Test1234          |
    And Hit Enter
    Then I am logged in successfully

  @InvalidSignIn
  Scenario: Attempt to login with invalid information
    Given I have navigated to the login page
    When I input details
      | Email    | Test@test |
      | Password | idihdw    |
    And Hit Enter
    Then I am not logged in


  @emptyFields
  Scenario: Attempt to login with empty fields
    Given I have navigated to the login page
    When  Hit Enter
    Then An error message appears