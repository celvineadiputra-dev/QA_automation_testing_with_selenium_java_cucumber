Feature: Remove Items from Cart

  Background:
    Given User Login and In Cart have 2 product

  Scenario: Remove an Item from the Cart
    Then The user should see at least 2 products in their cart
    When The user clicks the remove button for the first item
    Then The product count in the cart should decrease by 1
    Then The product in cart should be 1
    When The user clicks the remove button for the first item again
    Then The cart should be empty