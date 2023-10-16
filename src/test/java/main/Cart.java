package main;

import config.SetupDriver;
import config.elements.ElementFormCart;
import org.junit.jupiter.api.Assertions;

public class Cart {
    private final SetupDriver setupDriver;
    private final ElementFormCart elementFormCart;

    public Cart(SetupDriver setupDriver) {
        this.setupDriver = setupDriver;
        this.elementFormCart = new ElementFormCart(this.setupDriver.getWebDriver());
    }

    public void userNavigateToCartPage() {
        this.setupDriver.getWebDriver().navigate().to(this.setupDriver.getConfig().currentUrl("cart.html"));
    }

    public void assertAtLeastXProductsInShoppingCart() {
        this.elementFormCart.cartList();

        int size = this.elementFormCart.getItemInCartList().getSizeOfCart();

        Assertions.assertTrue(size >= 2);
    }

    public void clickRemoveButtonForFirstItem() {
        this.elementFormCart.getItemInCartList().getIndexOfCartList(0).remove();
    }

    public void assertProductInShoppingCartIsX() {
        this.elementFormCart.cartList();

        int size = this.elementFormCart.getItemInCartList().getSizeOfCart();

        Assertions.assertTrue(size >= 1);
    }

    public void assertShoppingCartIsEmpty() {
        this.elementFormCart.cartList();

        int size = this.elementFormCart.getItemInCartList().getSizeOfCart();

        Assertions.assertTrue(size == 0);
    }
}
