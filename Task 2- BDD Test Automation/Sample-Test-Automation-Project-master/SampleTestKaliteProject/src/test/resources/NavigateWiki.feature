Feature: Current Page Test

  Scenario: Navigate Wiki URL
    Given Open Browser
    When Navigate Wiki URL
    And Verify Current Page URL

  Scenario: Search and Verify result
    Given Open Browser
    When Navigate Wiki URL
    Then Type "україна"
    Then Click search element
    Then "There is a page named" should be seen


#    Then Close Browser