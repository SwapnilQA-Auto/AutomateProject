Feature: Verify Login feature

  Scenario: Validate valid user
    Given user on login page
    Then user enter username
    Then user enter password
    And user click on login button

