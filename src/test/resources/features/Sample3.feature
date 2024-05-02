@regression
Feature: Introduction to cucumber part 3
  As a test engineer
  I want to be able to write and execute a scenario outline

  @debugs
  Scenario Outline: a new scenario outline
    Given I am on age page
    When I enter name: "<name>"
    And I enter age: <age>
    And I click submit age
    Then I see message: "<message>"
  @working
    Examples:
      | name  | age | message                        |
      | Ann   | 5   | Hello, Ann, you are a kid      |
      | Marry | 50  | Hello, Marry, you are an adult |
      | Bob   | 61  | Hello, Bob, you are an adult   |
  @not_working
    Examples:
      | name | age | message                   |
      | Tom  | 15  | Hello, Tom, you are a kid |


#   TODO - create Scenario Outline for 'Give us your feedback!' page
#   URL: https://kristinek.github.io/site/tasks/provide_feedback
  @thirdTest
  Scenario Outline: give us your feedback
#   Navigate to page
  Given I am on feedback page
#   Set name and age based on test Examples
  When Enter name: "<name>"
  And Enter age: <age>
  And Enter language: "<language>"
  And Enter gender: "<gender>"
  And Enter option: "<option>"
  And Enter comment: "<comment>"
  Then Click submit send
    Examples:
      | name    | age |  language | gender | option | comment |
      | Stefano | 29  | English   | male   | Good   | Ciao    |
      | Arturs  | 27  | Spanish   | male   | Ok, i guess   | Sveiki    |
      | Marina | 20  | Chinese   | female   | Why me?  | Bonjour    |
#   Click "Send" button and verify that previous input is displayed in correct fields
