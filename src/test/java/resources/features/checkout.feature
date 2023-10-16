Feature: Checkout

  Background:
    Given The user opens the web page or app
    When The user enters a valid username
    And The user enters a valid password
    And The user clicks the login button
    Then The user should be logged in successfully
    And The user clicks the add to cart button
    And The user clicks the add to cart button for another product
    And The user is on the cart page

  Scenario Outline: User Successfully Checks Out Products
    Given The user is on the cart page
    Then The user should see at least 2 products in their cart
    And The user clicks the checkout button
    And The user should be redirected to the checkout page step "one"
    And The user enters <fistName> as the first name
    And The user enters <lastName> as the last name
    And The user enters <postalCode> as the postal code
    And The user clicks the continue button
    And The user should be redirected to the checkout page step "two"
    And The user clicks the finish button
    And The user should be redirected to the checkout complete page
    And The user clicks the back home button
    Then The number of items in the cart icon should be empty

    Examples:
      | fistName | lastName          | postalCode |
      | example  | example_last_name | 3301       |
      | ---      | example_last_name | 3301       |
      | ?        | ---               | 0          |
