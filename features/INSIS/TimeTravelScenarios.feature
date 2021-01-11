Feature: to test time travel parallel execution

  Background:
    Given user is on login page
      |BK |BK1|
      |0  |1  |
      |2  |3  |

  @tt @tt1
  Scenario: sc2
    Given user has waited for "2" seconds
    When  user has to travel "1" days
    Then validates that the scenarios completes successfully
    When  user has to travel "2" days


  @sc1 @tt1
  Scenario Outline: sc1
    Given user has waited for "1" seconds
    |FirstName|LastName|
    |abc      |def     |
    |ghj      |kil     |
    When  user has to travel "<BACS_DAYS>" days
    Then validates that the scenarios completes successfully

    Examples:
    |BACS_Days|
    |1        |
    |2        |
    |3        |
    |4        |
    |5        |
    |6        |
    |7        |
    |8        |
    |9        |
    |10        |
    |11        |
    |12        |

  @sc3 @tt1
  Scenario: sc3
    Given user has waited for "3" seconds
    When  user has to travel "7" days
    Then validates that the scenarios completes successfully

  @sc4 @tt1
  Scenario: sc4
    Given user has waited for "4" seconds
    When  user has to travel "4" days
    Then validates that the scenarios completes successfully
    When  user has to travel "8" days
    Then validates that the scenarios completes successfully

  @sc5 @tt1
  Scenario: sc5
    Given user has waited for "4" seconds
    When  user has to travel "4" days
    Then validates that the scenarios completes successfully
    When  user has to travel "8" days
    Then validates that the scenarios completes successfully

  @sc6 @tt1
  Scenario: sc6
    Given user has waited for "4" seconds
    When  user has to travel "4" days
    Then validates that the scenarios completes successfully
    When  user has to travel "8" days
    Then validates that the scenarios completes successfully

  @sc7 @tt1
  Scenario: sc7
    Given user has waited for "4" seconds
    When  user has to travel "4" days
    Then validates that the scenarios completes successfully
    When  user has to travel "8" days
    Then validates that the scenarios completes successfully

  @sc8 @tt1
  Scenario: sc8
    Given user has waited for "4" seconds
    When  user has to travel "4" days
    Then validates that the scenarios completes successfully
    When  user has to travel "8" days
    Then validates that the scenarios completes successfully

  @sc9 @tt1
  Scenario: sc9
    Given user has waited for "4" seconds
    When  user has to travel "4" days
    Then validates that the scenarios completes successfully
    When  user has to travel "8" days
    Then validates that the scenarios completes successfully

  @sc10 @tt1
  Scenario: sc10
    Given user has waited for "4" seconds
    When  user has to travel "4" days
    Then validates that the scenarios completes successfully
    When  user has to travel "8" days
    Then validates that the scenarios completes successfully

  @sc11 @tt1
  Scenario: sc11
    Given user has waited for "4" seconds
    When  user has to travel "4" days
    Then validates that the scenarios completes successfully
    When  user has to travel "8" days
    Then validates that the scenarios completes successfully

  @sc12 @tt1
  Scenario: sc12
    Given user has waited for "4" seconds
    When  user has to travel "4" days
    Then validates that the scenarios completes successfully
    When  user has to travel "8" days
    Then validates that the scenarios completes successfully

  @sc13 @tt1
  Scenario: sc13
    Given user has waited for "4" seconds
    When  user has to travel "4" days
    Then validates that the scenarios completes successfully
    When  user has to travel "8" days
    Then validates that the scenarios completes successfully
