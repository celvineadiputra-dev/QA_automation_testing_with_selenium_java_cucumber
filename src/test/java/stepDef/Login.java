package stepDef;

import config.SetupDriver;
import config.elements.ElementFormLogin;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Login extends SetupDriver {
    private final ElementFormLogin elementFormLogin;

    public Login() {
        this.elementFormLogin = new ElementFormLogin(super.webDriver);
    }

    @Given("The user opens the web page or app")
    public void userAlreadyOpenApp() {
        String currentTitle = this.getCurrentTitle();
        assertEquals("Swag Labs", currentTitle);
    }

    @When("The user enters (.*) as username$")
    public void userInputUserName(String username) {
        WebElement userNameField = this.elementFormLogin.userName();
        userNameField.sendKeys(username);
    }

    @And("The user enters (.*) as password$")
    public void userInputPassword(String password) {
        WebElement passwordElement = this.elementFormLogin.password();
        passwordElement.sendKeys(password);
    }

    @And("The user clicks the login button")
    public void userClickButtonLogin() {
        WebElement buttonLogin = this.elementFormLogin.loginButton();
        buttonLogin.click();
    }

    @Then("The user should be logged in successfully")
    public void userSuccessfullyLogin() {
        String currentUrl = this.getCurrentUrl();
        Assertions.assertEquals(this.config.currentUrl("inventory.html"), currentUrl);
    }

    @Then("The user should see an authentication error message")
    public void userShouldSeeAnAuthenticationErrorMessage() {
        int errorAlert = this.elementFormLogin.sizeErrorAlert();

        assertEquals(1, errorAlert);
    }

    @After(order = 0)
    public void closeBrowser() {
        webDriver.close();
    }
}
