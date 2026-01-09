Feature: Login Functionality
  In order to access my account and make purchases
  As a registered AskOmDch customer
  I want to log in successfully

Scenario: Login with multiple valid accounts
    Given I am on the AskOmDch account page
    When I log in with valid credentials
      | Isaro |
      | I$ar0_2026!Rocks# |
    Then I should be logged into my account


