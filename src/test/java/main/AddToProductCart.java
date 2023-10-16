package main;

import config.SetupDriver;
import config.elements.ElementInventory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class AddToProductCart {
    private final SetupDriver setupDriver;

    private final ElementInventory elementInventory;

    public AddToProductCart(SetupDriver setupDriver) {
        this.setupDriver = setupDriver;

        this.elementInventory = new ElementInventory(this.setupDriver.getWebDriver());
    }

    public void addToCartFirstProduct() {
        WebElement pSauceLabsBackpack = this.elementInventory.buttonAddToCart("sauce-labs-backpack");
        pSauceLabsBackpack.click();
    }

    public void addToCartTextWillBeChangeToRemove() {
        WebElement pSauceLabsBackpack = this.elementInventory.buttonRemoveFromCart("sauce-labs-backpack");
        Assertions.assertTrue(pSauceLabsBackpack.isDisplayed());
    }

    public void cartNumberWillBePlusOne() {
        WebElement shoppingCart = this.elementInventory.shoppingCart();
        Assertions.assertEquals("1", shoppingCart.getText());
    }

    public void userClickAddToCartOtherProductButton() {
        WebElement pSauceLabsBikeLight = this.elementInventory.buttonAddToCart("sauce-labs-bike-light");
        pSauceLabsBikeLight.click();
    }

    public void addToCartTextForOtherProductWillBeChangeToRemove() {
        WebElement pSauceLabsBikeLight = this.elementInventory.buttonRemoveFromCart("sauce-labs-bike-light");
        Assertions.assertTrue(pSauceLabsBikeLight.isDisplayed());
    }

    public void cartNumberWillBePlusTwo() {
        WebElement shoppingCart = this.elementInventory.shoppingCart();
        Assertions.assertEquals("2", shoppingCart.getText());
    }

    public void verifyFirstProductButton() {
        System.out.println("RUN ME TOO");
    }
}
