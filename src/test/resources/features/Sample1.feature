Feature: Introduction to cucumber part 1
  As a test engineer
  I want to be able to write and execute a simple scenario

  Scenario: Simple scenario
    When I am on the home page
    Then I should see home page header
    And I should see home page description
    And I should see menu

#  TODO - Add implementation for missing steps
  @test
  Scenario: New Simple scenario
    When I am on the locators page
    Then I should see both locators page headers
    And Buttons in Locators page are clickable
