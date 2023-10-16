Feature: Login feature

  Background:
    Given The user opens the web page or app

  Scenario: User successfully logs in with valid credentials
    When The user enters valid as username
    And The user enters valid as password
    And The user clicks the login button
    Then The user should be logged in successfully

  Scenario: User failed logs in with invalid password with registered user credentials
    When The user enters valid as username
    And The user enters invalid as password
    And The user clicks the login button
    Then The user should be see error message

  Scenario: User failed logs in with invalid credentials
    When The user enters invalid as username
    And The user enters invalid as password
    And The user clicks the login button
    Then The user should be see error message