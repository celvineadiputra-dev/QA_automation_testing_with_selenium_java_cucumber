Feature: Add Product to Cart

  Background:
    Given The user opens the web page or app
    When The user enters a valid username
    And The user enters a valid password
    And The user clicks the login button
    Then The user should be logged in successfully

  Scenario: User successfully adds a product to the cart
    When The user clicks the add to cart button
    Then The text on the add to cart button should change to remove
    Then The number of items in the cart icon should be 1
    When The user clicks the add to cart button for another product
    Then The text on the add to cart button other product should change to remove
    Then The number of items in the cart icon should be 2