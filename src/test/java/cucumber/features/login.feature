Feature: Login feature

  Scenario: Success Login
    Given User already in app login page
    When User input correct username
    And User input correct password
    And User click button login
    Then User will be redirect to dashboard screen