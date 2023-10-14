Feature: Login feature

  Scenario: Login with correct credential
    Given User already in app login page
    When User input username <email>
    And User input password <password>
    And User click button login
    Then User will be redirect to dashboard screen

  Example:
    | email | password |
    | standard_user | secret_sauce |

  Scenario: Login with wrong password
    Given User already in app login page
    When User input username <email>
    And User input password <password>
    And User click button login
    Then User should see an authentication error message

  Example:
    | email | password |
    | example | 123 |