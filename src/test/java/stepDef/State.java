package stepDef;

import config.SetupDriver;
import config.elements.ElementFormLogin;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;

public class State extends SetupDriver {
    private final ElementFormLogin elementFormLogin;

    public State() {
        this.elementFormLogin = new ElementFormLogin(super.webDriver);
    }

    @Given("The user should be logged in")
    public void login() {
        WebElement userNameField = this.elementFormLogin.userName();
        WebElement passwordField = this.elementFormLogin.password();

        userNameField.sendKeys(this.config.auth.getUserNameStandardUser());
        passwordField.sendKeys(this.config.auth.getPasswordStandardUser());

        this.elementFormLogin.loginButton().click();
    }
}
