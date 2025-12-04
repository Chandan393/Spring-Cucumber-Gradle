Feature: Calculator Addition

  Background:
    Given I have a calculator

  Scenario Outline: Add numbers with different combinations
    When I add <a> and <b>
    Then the result should be <result>

    Examples:
      | a     | b      | result |
      | 5     | 7      | 12     |
      | 0     | 10     | 10     |
      | 0     | 0      | 0      |
      | -4    | -6     | -10    |
      | 15    | -4     | 11     |
      | 1     | 9999   | 10000  |
      | 10000 | 25000  | 35000  |
      | 3     | 3      | 6      |
      | -10   | 3      | -7     |



