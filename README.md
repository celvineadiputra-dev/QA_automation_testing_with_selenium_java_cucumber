# Homework 06 | Celvine Adi Putra

### JDK Version

JDK : 20

### Dependency

| No | Group Id                | Artifact Id            | Version |
|----|-------------------------|------------------------|---------|
| 1  | org.seleniumhq.selenium | selenium-java          | 4.10.0  |
| 2  | org.junit.jupiter       | junit-jupiter-api      | 5.10.0  |
| 3  | io.github.bonigarcia    | webdrivermanager       | 5.5.3   |
| 4  | io.cucumber             | cucumber-java          | 7.14.0  |
| 5  | io.cucumber             | cucumber-junit         | 7.14.0  |
| 6  | org.junit.platform      | junit-platform-console | 1.10.0  |

### Test Information

1. URL

```text
https://www.saucedemo.com/
```

2. Users

| Username        | Password     |
|-----------------|--------------|
| standard_user   | secret_sauce |
| locked_out_user | secret_sauce |
| problem_user    | secret_sauce |
| error_user      | secret_sauce |

### Report

#### Login Feature

![](/home/celvine/Downloads/code/Tugas_06_CelvineAdiPutra/report/LoginReport.png)

```gherkin
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
```

#### Add to Cart

![](/home/celvine/Downloads/code/Tugas_06_CelvineAdiPutra/report/AddToCartReport.png)

```gherkin
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
```