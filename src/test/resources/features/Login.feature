Feature: Login Functionality

  In order to do a purchase of product
  As a valid Askohmdch customer
  I want to login successfully

  Scenario: Login Successful
    Given I am in the login page of the Askohmdch web app
    When I enter valid credentials "fuad" "fuad"
    Then I should be taken to the dashboard page