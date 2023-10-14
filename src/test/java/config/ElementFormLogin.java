package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementFormLogin {
    private final WebDriver webDriver;

    public ElementFormLogin(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement userName() {
        return this.webDriver.findElement(By.id("user-name"));
    }

    public WebElement password() {
        return this.webDriver.findElement(By.id("password"));
    }

    public WebElement loginButton() {
        return this.webDriver.findElement(By.id("login-button"));
    }

    public int sizeErrorAlert() {
        return this.webDriver.findElements(By.cssSelector(".error-message-container.error")).size();
    }
}
