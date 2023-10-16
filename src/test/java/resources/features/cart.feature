Feature: Remove Items from Cart

  Background:
    Given The user opens the web page or app
    When The user enters a valid username
    And The user enters a valid password
    And The user clicks the login button
    Then The user should be logged in successfully
    Then The user clicks the add to cart button
    Then The user clicks the add to cart button for another product

  Scenario: Remove an Item from the Cart
    Given The user is on the cart page
    Then The user should see at least 2 products in their cart
    When The user clicks the remove button for the first item
    Then The number of items in the cart icon should be 1
    Then The user should see at least 1 products in their cart
    When The user clicks the remove button for the first item
    Then The shopping cart should be empty