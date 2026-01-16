Feature: Login Functionality

  In order to do a purchase of product
  As a valid Askohmdch customer
  I want to login successfully

  Scenario: Login Successful
    Given the customer is on the login page of app
    When the customer enters valid credentials
    Then the customer should be taken to the dashboard page