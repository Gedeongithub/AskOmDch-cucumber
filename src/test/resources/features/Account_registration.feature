Feature: Account registration
  In order to purchase products and track orders
  As a new customer of AskOmDch
  I want to register an account successfully

Scenario Outline: Register a new account with valid details
  Given I am on the AskOmDch Account page
  When I register with <username>, <email> and <password>
  Then my account should be created successfully

  Examples:
      | username  |email   | password |
      | "testerA1" | "testerA1@gmail.com" | "testerA@gmail.com" |
      | "testerB1"  | "testerB1@gmail.com" | "testerB@gmail.com"|
