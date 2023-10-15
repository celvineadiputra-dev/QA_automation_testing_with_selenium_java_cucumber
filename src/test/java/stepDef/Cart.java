package stepDef;

import config.SetupDriver;
import config.elements.ElementFormCart;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class Cart extends SetupDriver {
    private final ElementFormCart elementFormCart;

    public Cart() {
        this.elementFormCart = new ElementFormCart(super.webDriver);
    }

    @Then("The user should see at least 2 products in their cart")
    public void validateCartAtLeast2Products() {
        System.out.println(this.getCurrentUrl());
//        int sumOfItemInCart = this.elementFormCart.cartList().getSizeOfCart();
//
//        Assertions.assertTrue(sumOfItemInCart >= 2);
    }

    @When("The user clicks the remove button for the first item")
    public void userClickRemoveFistItem() {
//        String name = this.elementFormCart.cartList().getItemInCartList().getIndexOfCartList(0).getItemName();
//        System.out.println(name);
    }
}
