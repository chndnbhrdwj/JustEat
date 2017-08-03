Feature: Addition Test

  @test
  Scenario: Test Addition
    When I want to add 2 and 4
    Then I should see result as 6

  @test
  Scenario: Test Minus
    When I want to minus 6 and 4
    Then I should see result as 2