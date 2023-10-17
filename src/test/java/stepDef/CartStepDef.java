package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.Cart;

public class CartStepDef {
    private final Hook hook;
    private Cart cart;

    public CartStepDef(Hook hook) {
        this.hook = hook;
        this.cart = new Cart(this.hook.getSetUpDriver());
    }

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
}
