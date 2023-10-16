package stepDef;

import config.SetupDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.AddToProductCart;
import main.Cart;
import main.Checkout;
import main.Login;

public class StepTest extends SetupDriver {
    private final Login login;
    private final AddToProductCart addToProductCart;
    private final Cart cart;
    private final Checkout checkout;

    public StepTest() {
        this.login = new Login(this.getSetUpDriver());
        this.addToProductCart = new AddToProductCart(this.getSetUpDriver());
        this.cart = new Cart(this.getSetUpDriver());
        this.checkout = new Checkout(this.getSetUpDriver());
    }

    // START OPEN APP
    @Given("The user opens the web page or app")
    public void openApp() {
        this.openDefaultApp();
    }
    // END OPEN APP

    // START LOGIN
    @When("The user enters a valid username")
    public void enterValidUserName() {
        this.login.enterValidUserName();
    }

    @When("The user enters a invalid username")
    public void enterInValidUserName() {
        this.login.enterInValidUserName();
    }

    @And("The user enters a valid password")
    public void enterValidPassword() {
        this.login.enterValidPassword();
    }

    @And("The user enters a invalid password")
    public void enterInValidPassword() {
        this.login.enterInValidPassword();
    }

    @And("The user clicks the login button")
    public void clickLoginButton() {
        this.login.clickLoginButton();
    }

    @Then("The user should be logged in successfully")
    public void verifyUserLoggedIn() {
        this.login.verifyUserLoggedIn();
    }

    @Then("The user should be see error message")
    public void verifyAlert() {
        this.login.verifyAlert();
    }
    // END LOGIN

    // START ADD TO CART
    @When("The user clicks the add to cart button")
    public void addToCartFirstProduct() {
        this.addToProductCart.addToCartFirstProduct();
    }

    @Then("The text on the add to cart button should change to remove")
    public void verifyFirstProductButton() {
        this.addToProductCart.addToCartTextWillBeChangeToRemove();
    }

    @Then("The number of items in the cart icon should be 1")
    public void cartNumberWillBePlusOne() {
        this.addToProductCart.cartNumberWillBePlusOne();
    }

    @When("The user clicks the add to cart button for another product")
    public void userClickAddToCartOtherProductButton() {
        this.addToProductCart.userClickAddToCartOtherProductButton();
    }

    @Then("The text on the add to cart button other product should change to remove")
    public void addToCartTextForOtherProductWillBeChangeToRemove() {
        this.addToProductCart.addToCartTextForOtherProductWillBeChangeToRemove();
    }

    @Then("The number of items in the cart icon should be 2")
    public void cartNumberWillBePlusTwo() {
        this.addToProductCart.cartNumberWillBePlusTwo();
    }
    // END ADD TO CART

    // START CART
    @Then("The user is on the cart page")
    public void userNavigateToCartPage() {
        this.cart.userNavigateToCartPage();
    }

    @Then("The user should see at least {int} products in their cart")
    public void assertAtLeastXProductsInShoppingCart(int number) {
        this.cart.assertAtLeastXProductsInShoppingCart(number);
    }

    @When("The user clicks the remove button for the first item")
    public void clickRemoveButtonForFirstItem() {
        this.cart.clickRemoveButtonForFirstItem();
    }

    @Then("The shopping cart should be empty")
    public void assertShoppingCartIsEmpty() {
        this.cart.assertShoppingCartIsEmpty();
    }
    // END CART

    // Start Checkout
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

    // End Checkout

    // DONE
    @After(order = 0)
    public void closeBrowser() {
        this.getWebDriver().close();
    }
    // DONE
}
