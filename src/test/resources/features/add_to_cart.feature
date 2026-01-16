Feature: Add product to cart

  Scenario: Add a product to the cart by name
    Given I am on the Store page
    When I add "Anchor Bracelet" to the cart
    And open Cart page
    Then "Anchor Bracelet" should be added to the cart