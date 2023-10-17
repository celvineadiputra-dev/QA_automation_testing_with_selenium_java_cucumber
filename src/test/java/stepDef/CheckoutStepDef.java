package stepDef;

import io.cucumber.java.en.Then;
import main.Checkout;

public class CheckoutStepDef {
    private Hook hook;
    private Checkout checkout;

    public CheckoutStepDef(Hook hook) {
        this.hook = hook;
        this.checkout = new Checkout(this.hook.getSetUpDriver());
    }

    @Then("The user clicks the checkout button")
    public void clickCheckOutButton() {
        this.checkout.clickCheckOutButton();
    }

    @Then("The user should be on the checkout page")
    public void userShouldBeOnCheckoutPage() {
        this.checkout.userShouldBeOnCheckoutPage();
    }

    @Then("The user enters (.*) as the first name$")
    public void userEntersExampleAsFirstName(String firstName) {
        this.checkout.userEntersExampleAsFirstName(firstName);
    }

    @Then("The user enters (.*) as the last name$")
    public void userEntersExampleLastNameAsLastName(String lastName) {
        this.checkout.userEntersExampleLastNameAsLastName(lastName);
    }

    @Then("The user enters (.*) as the postal code$")
    public void userEntersPostalCode(int postalCode) {
        this.checkout.userEntersPostalCode(postalCode);
    }

    @Then("The user clicks the continue button")
    public void userClicksContinueButton() {
        this.checkout.userClicksContinueButton();
    }

    @Then("The user should be redirected to the checkout page step {string}")
    public void userShouldBeRedirectedToCheckoutPageStep(String stepNumber) {
        this.checkout.userShouldBeRedirectedToCheckoutPageStep(stepNumber);
    }

    @Then("The user clicks the finish button")
    public void userClicksFinishButton() {
        this.checkout.userClicksFinishButton();
    }

    @Then("The user should be redirected to the checkout complete page")
    public void userShouldBeRedirectedToCheckoutCompletePage() {
        this.checkout.userShouldBeRedirectedToCheckoutCompletePage();
    }

    @Then("The user clicks the back home button")
    public void userClicksBackHomeButton() {
        this.checkout.userClicksBackHomeButton();
    }

    @Then("The number of items in the cart icon should be empty")
    public void numberOfItemsInCartIconShouldBeEmpty() {
        this.checkout.numberOfItemsInCartIconShouldBeEmpty();
    }
}
