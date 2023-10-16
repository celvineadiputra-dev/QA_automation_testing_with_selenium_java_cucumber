package config.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementFormCheckout {
    private final WebDriver webDriver;

    public ElementFormCheckout(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void typeField(String id, String value) {
        this.webDriver.findElement(By.id(id)).sendKeys(value);
    }

    public void clickNextButton(String id) {
        this.webDriver.findElement(By.id(id)).click();
    }
}
