package main;

import config.SetupDriver;
import config.elements.ElementFormCart;
import config.elements.ElementFormCheckout;
import config.elements.ElementInventory;
import org.junit.jupiter.api.Assertions;

public class Checkout {
    private SetupDriver setupDriver;
    private final ElementFormCart elementFormCart;
    private final ElementFormCheckout elementFormCheckout;
    private final ElementInventory elementInventory;

    public Checkout(SetupDriver setupDriver) {
        this.setupDriver = setupDriver;
        this.elementFormCart = new ElementFormCart(this.setupDriver.getWebDriver());
        this.elementFormCheckout = new ElementFormCheckout(this.setupDriver.getWebDriver());
        this.elementInventory = new ElementInventory(this.setupDriver.getWebDriver());
    }

    public void clickCheckOutButton() {
        this.elementFormCart.cartList();
        this.elementFormCart.checkoutButton().click();
    }

    public void userShouldBeOnCheckoutPage() {

    }

    public void userEntersExampleAsFirstName(String firstName) {
        this.elementFormCheckout.typeField("first-name", firstName);
    }

    public void userEntersExampleLastNameAsLastName(String lastName) {
        this.elementFormCheckout.typeField("last-name", lastName);
    }

    public void userEntersPostalCode(int postalCode) {
        this.elementFormCheckout.typeField("postal-code", Integer.toString(postalCode));
    }

    public void userClicksContinueButton() {
        this.elementFormCheckout.clickNextButton("continue");
    }

    public void userShouldBeRedirectedToCheckoutPageStep(String stepNumber) {
        String currentUrl = this.setupDriver.getCurrentUrl();
        String expectedUrl = this.setupDriver.getConfig().currentUrl("checkout-step-" + stepNumber + ".html");

        Assertions.assertEquals(expectedUrl, currentUrl);
    }

    public void userClicksFinishButton() {
        this.elementFormCheckout.clickNextButton("finish");
    }

    public void userShouldBeRedirectedToCheckoutCompletePage() {
        String currentUrl = this.setupDriver.getCurrentUrl();
        String expectedUrl = this.setupDriver.getConfig().currentUrl("checkout-complete.html");

        Assertions.assertEquals(expectedUrl, currentUrl);
    }

    public void userClicksBackHomeButton() {
        this.elementFormCheckout.clickNextButton("back-to-products");
    }

    public void numberOfItemsInCartIconShouldBeEmpty() {
        Assertions.assertEquals("", this.elementInventory.sh());
    }

}
