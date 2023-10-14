package config.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementInventory {
    private final WebDriver webDriver;

    public ElementInventory(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement buttonAddToCart(String productName) {
        return this.webDriver.findElement(By.id("add-to-cart-" + productName));
    }

    public WebElement buttonRemoveFromCart(String productName) {
        return this.webDriver.findElement(By.id("remove-" + productName));
    }

    public WebElement shoppingCart() {
        return this.webDriver.findElement(By.cssSelector(".shopping_cart_link > .shopping_cart_badge"));
    }
}
