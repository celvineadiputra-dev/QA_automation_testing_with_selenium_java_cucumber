Feature: Remove Items from Cart

  Background:
    Given The user opens the web page or app
    When The user enters valid as username
    And The user enters valid as password
    And The user clicks the login button
    Then The user should be logged in successfully
    Then The user clicks the add to cart button
    Then The user click the add to cart button other product

  Scenario: Remove an Item from the Cart
    Given The user in cart page
    Then The user should see at least 2 products in their cart
    When The user clicks the remove button for the first item
    Then The number of items in the cart icon should be 1
    Then The product in the shopping cart should be 1
    When The user clicks the remove button for the first item
    Then The shopping cart should be empty