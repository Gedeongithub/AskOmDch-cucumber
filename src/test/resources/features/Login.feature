Feature: Login Functionality
  In order to access my account and make purchases
  As a registered AskOmDch customer
  I want to log in successfully

Scenario: Login successfully
    Given the customer is on the AskOmDch account page
    When the customer logs in with valid credentials
      | Isaro |
      | I$ar0_2026!Rocks# |
    Then the customer is logged to the account


