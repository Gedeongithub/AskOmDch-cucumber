Feature: Login Functionality
  In order to access my account and make purchases
  As a registered AskOmDch customer
  I want to log in successfully

Scenario Outline: Login with multiple valid accounts
    Given I am on the AskOmDch account page
    When I log in with valid <username> and <password> credentials
    Then I should be logged into my account

    Examples:
      | username| password|
      | tester  | tester  |
      | tester1 | tester1 |
