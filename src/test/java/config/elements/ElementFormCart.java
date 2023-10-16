package config.elements;

import config.utils.ConvertStringToKebabCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementFormCart {
    private final WebDriver webDriver;
    private WebElement cartList;
    private List<WebElement> itemInCartList;

    private WebElement selectedItem;

    private String productName;

    public ElementFormCart(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ElementFormCart cartList() {
        this.cartList = this.webDriver.findElement(By.cssSelector("#cart_contents_container"));
        return this;
    }

    public ElementFormCart getItemInCartList() {
        this.itemInCartList = this.cartList.findElements(By.cssSelector(".cart_item"));
        return this;
    }

    public ElementFormCart getIndexOfCartList(int index) {
        this.selectedItem = this.itemInCartList.get(index);
        return this;
    }

    public int getSizeOfCart() {
        return this.itemInCartList.size();
    }

    public String getItemName() {
        String productName = this.selectedItem.findElement(By.cssSelector(".cart_item_label>a>.inventory_item_name")).getText();
        this.productName = new ConvertStringToKebabCase(productName).convert();
        return this.productName;
    }

    public void remove() {
        this.getItemName();
        this.webDriver.findElement(By.id("remove-" + this.productName)).click();
    }
}
