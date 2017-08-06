Feature: Use the website to find restaurants
  So that I can order food
  As a hungry customer
  I want to be able to find restaurants in my area

  Scenario: Search for restaurants in an area
    Given I want food in "AR51 1AA"
    When I search for restaurants
    Then I should see some restaurants in "AR51 1AA"

  Scenario: Search for restaurants for cuisine
    Given I want food in "AR51 1AA"
    When I search for restaurants
    Then I should see some restaurants in "AR51 1AA"
    When I filter results for cuisine "American"
    Then I should see "American" cuisine restaurants

  Scenario: Search for restaurants in an area
    Given I want food in "AR51 1AA"
    When I search for restaurants
    Then I should see some restaurants in "AR51 1AA"
    When I filter results by restaurant name "Burger King"
    Then I should see the "Burger King" restaurants