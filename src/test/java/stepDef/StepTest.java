package stepDef;

import config.SetupDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.AddToProductCart;
import main.Cart;
import main.Login;

public class StepTest extends SetupDriver {
    private final Login login;
    private final AddToProductCart addToProductCart;
    private final Cart cart;

    public StepTest() {
        this.login = new Login(this.getSetUpDriver());
        this.addToProductCart = new AddToProductCart(this.getSetUpDriver());
        this.cart = new Cart(this.getSetUpDriver());
    }

    // START OPEN APP
    @Given("The user opens the web page or app")
    public void openApp() {
        this.openDefaultApp();
    }
    // END OPEN APP

    // START LOGIN
    @When("The user enters valid as username")
    public void enterValidUserName() {
        this.login.enterValidUserName();
    }

    @When("The user enters invalid as username")
    public void enterInValidUserName() {
        this.login.enterInValidUserName();
    }

    @And("The user enters valid as password")
    public void enterValidPassword() {
        this.login.enterValidPassword();
    }

    @And("The user enters invalid as password")
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

    @When("The user click the add to cart button other product")
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
    @Then("The user in cart page")
    public void userNavigateToCartPage() {
        this.cart.userNavigateToCartPage();
    }

    @Then("The user should see at least 2 products in their cart")
    public void assertAtLeastXProductsInShoppingCart() {
        this.cart.assertAtLeastXProductsInShoppingCart();
    }

    @When("The user clicks the remove button for the first item")
    public void clickRemoveButtonForFirstItem() {
        this.cart.clickRemoveButtonForFirstItem();
    }

    @Then("The product in the shopping cart should be 1")
    public void assertProductInShoppingCartIsX() {
        this.cart.assertProductInShoppingCartIsX();
    }

    @Then("The shopping cart should be empty")
    public void assertShoppingCartIsEmpty() {
        this.cart.assertShoppingCartIsEmpty();
    }
    // END CART

    // DONE
    @After(order = 0)
    public void closeBrowser() {
        this.getWebDriver().close();
    }
    // DONE
}
