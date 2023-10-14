package selenium;

import config.ElementFormLogin;
import config.SetupDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void validateInputForm() {
        WebElement userName = this.elementFormLogin.userName();
        WebElement password = this.elementFormLogin.password();

        userName.sendKeys(this.config.getStandardUser().getUserName());
        password.sendKeys(this.config.getStandardUser().getPassword());

        assertEquals(this.config.getStandardUser().getUserName(), userName.getAttribute("value"));
        assertEquals(this.config.getStandardUser().getPassword(), password.getAttribute("value"));
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

        assertEquals(this.config.currentUrl("inventory.html"), currentUrl);
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

        int errorAlert = this.elementFormLogin.sizeErrorAlert();

        assertEquals(1, errorAlert);
    }

    @Test
    @DisplayName("Login without user name")
    public void loginWithOutUserName() {
        WebElement password = this.elementFormLogin.password();
        WebElement buttonLogin = this.elementFormLogin.loginButton();

        password.sendKeys(this.config.getStandardUser().getWrongPassword());
        buttonLogin.click();

        int errorAlert = this.elementFormLogin.sizeErrorAlert();

        assertEquals(1, errorAlert);
    }

    @Test
    @DisplayName("Login without password")
    public void loginWithOutPassword() {
        WebElement userName = this.elementFormLogin.userName();
        WebElement buttonLogin = this.elementFormLogin.loginButton();

        userName.sendKeys(this.config.getStandardUser().getUserName());
        buttonLogin.click();

        int errorAlert = this.elementFormLogin.sizeErrorAlert();

        assertEquals(1, errorAlert);
    }
}
