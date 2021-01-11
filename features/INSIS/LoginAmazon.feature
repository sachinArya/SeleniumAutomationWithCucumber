Feature: Verify amazon login

  @tt1
  @TestGrp @login
  Scenario: verify user is not able to login to amazon with in-valid credentials
    Given User is on "https://www.amazon.co.uk"
    When user enter user name as "abc123@gmail.com"
    And user enters password as "XXXX"
    Then User is unable to login successfully