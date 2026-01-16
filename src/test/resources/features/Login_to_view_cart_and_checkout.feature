Feature: Login and checkout with existing cart items

  As a returning customer
  I want to log in and view my cart
  So that I can checkout items I already added

  Scenario: Login and checkout with items already in cart
    Given I am on the login page
    When I log on with valid credentials
      | Sabine |
      | ^Sabine-Is-Secure-2026^ |
    Then I should be logged in successfully
    And I open the cart page
    And I should see products in the cart
    When I proceed to checkout
    Then I should be on the checkout page
