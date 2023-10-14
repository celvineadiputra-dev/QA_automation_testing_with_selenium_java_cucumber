Feature: Login feature

  Scenario Outline: User successfully logs in with valid credentials
    Given The user opens the web page or app
    When The user enters <username> as username
    And The user enters <password> as password
    And The user clicks the login button
    Then The user should be logged in successfully

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: User fails to log in with invalid credentials
    Given The user opens the web page or app
    When The user enters <username> as username
    And The user enters <password> as password
    And The user clicks the login button
    Then The user should see an authentication error message

    Examples:
      | username | password |
      | example  | 123      |