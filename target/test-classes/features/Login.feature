Feature: Login functionality

  Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When User enters valid email address <Username> into email field
    And User enters valid password <Password> into password field
    And User clicks on login button
    Then User should get successfully logged in

    Examples: 
      | Username            | Password |
      | dilip123@gmail.com  |    12345 |
      | gaurav123@gmail.com |    12345 |
      | mandal123@gmail.com |    12345 |

  Scenario: Login with invalid credentials
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters invalid password "123456" into password field
    And User clicks on login button
    Then User should get a proper warning message about credential mismatch

  Scenario: Login with vaild email and invalid password
    Given User navigates to login page
    When User enters valid email address "gaurav123@gmail.com" into email field
    And User enters invalid password "123456" into password field
    And User clicks on login button
    Then User should get a proper warning message about credential mismatch

  Scenario: Login with invalid email and valid password
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters valid password "qwerty" into password field
    And User clicks on login button
    Then User should get a proper warning message about credential mismatch

  Scenario: Login without any credentials
    Given User navigates to login page
    When User doesnt enter email address into email field
    And User doesnt enter password address into password field
    And User clicks on login button
    Then User should get a proper warning message about credential mismatch
