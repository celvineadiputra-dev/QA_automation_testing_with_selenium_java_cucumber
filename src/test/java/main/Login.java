package main;

import config.Config;
import config.SetupDriver;
import config.elements.ElementFormLogin;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class Login {
    private final SetupDriver setupDriver;
    private final Config config;
    private final ElementFormLogin elementFormLogin;

    public Login(SetupDriver setupDriver) {
        this.setupDriver = setupDriver;
        this.config = this.setupDriver.getConfig();
        this.elementFormLogin = new ElementFormLogin(this.setupDriver.getWebDriver());
    }

    public void enterValidUserName() {
        WebElement userNameField = elementFormLogin.userName();
        userNameField.sendKeys(this.config.auth.getUserNameStandardUser());
    }

    public void enterInValidUserName() {
        WebElement userNameField = elementFormLogin.userName();
        userNameField.sendKeys(this.config.auth.getUserNameFakeUser());
    }

    public void enterValidPassword() {
        WebElement passwordField = elementFormLogin.password();
        passwordField.sendKeys(this.config.auth.getPasswordStandardUser());
    }

    public void enterInValidPassword() {
        WebElement passwordField = elementFormLogin.password();
        passwordField.sendKeys(this.config.auth.getPasswordFakeUser());
    }

    public void clickLoginButton() {
        WebElement loginButton = elementFormLogin.loginButton();
        loginButton.click();
    }

    public void verifyUserLoggedIn() {
        String currentUrl = this.setupDriver.getCurrentUrl();
        String expectedUrl = this.config.currentUrl("inventory.html");
        Assertions.assertEquals(expectedUrl, currentUrl);
    }

    public void verifyAlert() {
        int errorAlert = elementFormLogin.sizeErrorAlert();
        Assertions.assertEquals(1, errorAlert);
    }
}
