Feature: Sign in function

  @CreateAccount
  Scenario: Creating Account
    Given I have navigated to the create an account page
    When I enter valid details
      | First Name | Test              |
      | Last Name  | Tester            |
      | Email      | Test@TestTest.com |
      | Password   | Test1234          |
      | Birthdate  | 11/11/1111        |
    And Hit Save
    Then An account is created and I am logged in

  @SignIn
  Scenario: Logging in with valid details
    Given I have navigated to the login page
    When I input valid details
      | Email    | Test@TestTest.com |
      | Password | Test1234          |
    And Hit Enter
    Then I am logged in successfully