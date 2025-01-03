Feature:OrangeHRm Tests
  Scenario:Login should be success
    Given User navigate to the OrangeHRM application
    Given User enter the username
    And User enter the password
    When user click on the login button
    Then Login should be success

  Scenario:Login should not be success
    Given User navigate to the OrangeHRM application
    Given User enter invalid username
    And User enter the password
    When user click on the login button
    Then Login should be fail
