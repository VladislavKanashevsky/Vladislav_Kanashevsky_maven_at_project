Feature: My 2demo feature

  Scenario Outline: My demo scenario
    Given I open demoG7 site
    When I fill "<word>" in the form
    Then I need to see something
    Examples:
    | word |
    | red |
    | get |
    | ley |
    | way |
