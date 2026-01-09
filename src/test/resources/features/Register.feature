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
      | eric17   | eric27@test.com  | 12345    |
      | john17   | john17@test.com  | 12345    |
