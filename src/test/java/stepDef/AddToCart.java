package stepDef;

import config.SetupDriver;
import config.elements.ElementFormLogin;
import config.elements.ElementInventory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class AddToCart extends SetupDriver {
    private final ElementFormLogin elementFormLogin;
    private final ElementInventory elementInventory;

    public AddToCart() {
        this.elementFormLogin = new ElementFormLogin(super.webDriver);
        this.elementInventory = new ElementInventory(super.webDriver);
    }

    @Before
    public void login() {
        WebElement userNameField = this.elementFormLogin.userName();
        WebElement passwordField = this.elementFormLogin.password();

        userNameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        this.elementFormLogin.loginButton().click();
    }

    @Given("The user is logged in")
    public void userAlreadyLoggedIn() {
        Assertions.assertEquals(this.config.currentUrl("inventory.html"), this.getCurrentUrl());
    }

    @When("The user clicks the add to cart button")
    public void userClickAddToCartButton() {
        WebElement pSauceLabsBackpack = this.elementInventory.buttonAddToCart("sauce-labs-backpack");
        pSauceLabsBackpack.click();
    }

    @Then("The text on the add to cart button should change to remove")
    public void addToCartTextWillBeChangeToRemove() {
        WebElement pSauceLabsBackpack = this.elementInventory.buttonRemoveFromCart("sauce-labs-backpack");
        Assertions.assertTrue(pSauceLabsBackpack.isDisplayed());
    }

    @Then("The number of items in the cart icon should be 1")
    public void cartNumberWillBePlusOne() {
        WebElement shoppingCart = this.elementInventory.shoppingCart();
        Assertions.assertEquals("1", shoppingCart.getText());
    }

    @When("The user click the add to cart button other product")
    public void userClickAddToCartOtherProductButton() {
        WebElement pSauceLabsBikeLight = this.elementInventory.buttonAddToCart("sauce-labs-bike-light");
        pSauceLabsBikeLight.click();
    }

    @Then("The text on the add to cart button other product should change to remove")
    public void addToCartTextForOtherProductWillBeChangeToRemove() {
        WebElement pSauceLabsBikeLight = this.elementInventory.buttonRemoveFromCart("sauce-labs-bike-light");
        Assertions.assertTrue(pSauceLabsBikeLight.isDisplayed());
    }

    @Then("The number of items in the cart icon should be 2")
    public void cartNumberWillBePlusTwo() {
        WebElement shoppingCart = this.elementInventory.shoppingCart();
        Assertions.assertEquals("2", shoppingCart.getText());
    }

    @After(order = 0)
    public void closeBrowser() {
        webDriver.close();
    }
}
