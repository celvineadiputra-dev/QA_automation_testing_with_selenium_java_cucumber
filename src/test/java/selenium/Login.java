package selenium;

import config.ElementFormLogin;
import config.SetupDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class Login extends SetupDriver {
    private final ElementFormLogin elementFormLogin;

    public Login() {
        this.elementFormLogin = new ElementFormLogin(super.webDriver);
    }

    @Test
    public void validateFieldUserName() {
        WebElement userName = this.elementFormLogin.userName();
        assertTrue(userName.isDisplayed());
    }

    @Test
    public void validateFieldPassword() {
        WebElement password = this.elementFormLogin.password();
        assertTrue(password.isDisplayed());
    }

    @Test
    public void validateButtonLogin() {
        WebElement loginButton = this.elementFormLogin.loginButton();
        assertTrue(loginButton.isDisplayed());
    }

    @Test
    @DisplayName("Login using : standard_user and correct password")
    public void successLogin() {
        WebElement userName = this.elementFormLogin.userName();
        WebElement password = this.elementFormLogin.password();
        WebElement buttonLogin = this.elementFormLogin.loginButton();

        userName.sendKeys(this.config.getStandardUser().getUserName());
        password.sendKeys(this.config.getStandardUser().getPassword());
        buttonLogin.click();

        String currentUrl = webDriver.getCurrentUrl();

        assertEquals(this.config.currenUrl("inventory.html"), currentUrl);
    }

    @Test
    @DisplayName("Login using : standard_user and not valid password")
    public void failedLogin() {
        WebElement userName = this.elementFormLogin.userName();
        WebElement password = this.elementFormLogin.password();
        WebElement buttonLogin = this.elementFormLogin.loginButton();

        userName.sendKeys(this.config.getStandardUser().getUserName());
        password.sendKeys(this.config.getStandardUser().getWrongPassword());
        buttonLogin.click();

        int errorAlert = webDriver.findElements(By.cssSelector(".error-message-container.error")).size();

        assertNotEquals(this.config.currenUrl("inventory.html"), this.getCurrentUrl());
        assertEquals(1, errorAlert);
    }
}
