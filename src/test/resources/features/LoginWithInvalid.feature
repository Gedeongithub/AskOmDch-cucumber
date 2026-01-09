Feature: Login functionality
  As a customer
  I want to log in through the Account page
  So that I can access my account

  Scenario Outline: Login with invalid credentials
    Given the user is on the Askmodch homepage
    And the user opens the Account menu
    When the user enters invalid <username> and <password>
    And clicks the Login button
    Then an error message is displayed

    Examples:
      | username | password |
      | "sabine"   | "sabine "  |
