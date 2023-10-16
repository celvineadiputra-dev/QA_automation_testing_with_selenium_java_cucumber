Feature: Login feature

  Background:
    Given The user opens the web page or app

  Scenario: User successfully logs in with valid credentials
    When The user enters a valid username
    And The user enters a valid password
    And The user clicks the login button
    Then The user should be logged in successfully

  Scenario: User failed logs in with invalid password with registered user credentials
    When The user enters a valid username
    And The user enters a invalid password
    And The user clicks the login button
    Then The user should be see error message

  Scenario: User failed logs in with invalid credentials
    When The user enters a invalid username
    And The user enters a invalid password
    And The user clicks the login button
    Then The user should be see error message