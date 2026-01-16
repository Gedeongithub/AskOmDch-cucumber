Feature: sorting functionality
  In order to perform an online shopping
  As askomd online shop customer
  I want to search product successfully by dropDown

  Scenario Outline: View products by selecting category from dropdown
    Given the user is on the online shop homepage
    When the user selects <Option> from the sorting dropdown
    Then only products from <Option> sorting should be displayed

    Examples:
      | Option |
      | "Sort by average rating"|
      |  "Sort by popularity"|
      | "Default sorting"|
      | "Sort by latest"|



