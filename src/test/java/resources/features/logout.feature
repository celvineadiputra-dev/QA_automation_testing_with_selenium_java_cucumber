Feature: Logout

  Background:
    Given The user opens the web page or app
    When The user enters a valid username
    And The user enters a valid password
    And The user clicks the login button

  Scenario: User logout after login
    Given The user should be logged in successfully
    When The user clicks the burger button
    Then The user should see the slide menu
    And The user clicks logout
    Then The user should be redirected to the login page
