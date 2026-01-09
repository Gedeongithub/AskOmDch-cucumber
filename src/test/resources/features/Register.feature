Feature: User Registration
  In order to use the Askomdch application
  As a new user
  I want to register successfully

  Scenario Outline: Successful Registration
    Given I am on the registration page
    When I register with username "<username>", email "<email>", and password "<password>"
    Then I should be taken to Account page

    Examples:
      | username | email            | password |
      | eric18   | eric28@test.com  | 12345    |
      | john18   | john18@test.com  | 12345    |
