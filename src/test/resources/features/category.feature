Feature: DropDown functionality
  In order to perform an online shopping
  As askomd online shop customer
  I want to search product successfully by dropDown

  Scenario Outline: View products by selecting category from dropdown
    Given the user is on the online shop homepage
    When the user selects <Category> from the category dropdown
    Then only products from <Category> category should be displayed

    Examples:
      | Category |
      | "mens-jeans"|
      |  "purses-and-handbags"|
      | "womens-shoes"|
      | "accessories"|


