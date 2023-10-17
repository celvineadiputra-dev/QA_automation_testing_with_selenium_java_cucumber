package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.AddProductToCart;

public class AddProductToCartStepDef {
    private final Hook hook;
    private AddProductToCart addProductToCart;

    public AddProductToCartStepDef(Hook hook) {
        this.hook = hook;
        this.addProductToCart = new AddProductToCart(this.hook.getSetUpDriver());
    }

    @When("The user clicks the add to cart button")
    public void addToCartFirstProduct() {
        this.addProductToCart.addToCartFirstProduct();
    }

    @Then("The text on the add to cart button should change to remove")
    public void verifyFirstProductButton() {
        this.addProductToCart.addToCartTextWillBeChangeToRemove();
    }

    @Then("The number of items in the cart icon should be 1")
    public void cartNumberWillBePlusOne() {
        this.addProductToCart.cartNumberWillBePlusOne();
    }

    @When("The user clicks the add to cart button for another product")
    public void userClickAddToCartOtherProductButton() {
        this.addProductToCart.userClickAddToCartOtherProductButton();
    }

    @Then("The text on the add to cart button other product should change to remove")
    public void addToCartTextForOtherProductWillBeChangeToRemove() {
        this.addProductToCart.addToCartTextForOtherProductWillBeChangeToRemove();
    }

    @Then("The number of items in the cart icon should be 2")
    public void cartNumberWillBePlusTwo() {
        this.addProductToCart.cartNumberWillBePlusTwo();
    }
}
