Feature: Create Account

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

@InvalidCreateAccount
Scenario: Attempt create account with bad details
Given I have navigated to the create an account page
When I input bad details
| First Name | 6666    |
| Last Name  | 44444   |
| Email      | Test    |
| Password   | 00oo    |
| Birthdate  | 10/01/1 |
And Hit Enter
Then An account is not created
