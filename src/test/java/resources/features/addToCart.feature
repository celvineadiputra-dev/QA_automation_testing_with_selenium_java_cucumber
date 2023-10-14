Feature: Add Product to Cart

  Background:
    Given The user is logged in

  Scenario: User successfully adds a product to the cart
    When The user clicks the add to cart button
    Then The text on the add to cart button should change to remove
    Then The number of items in the cart icon should be 1
    When The user click the add to cart button other product
    Then The text on the add to cart button other product should change to remove
    Then The number of items in the cart icon should be 2