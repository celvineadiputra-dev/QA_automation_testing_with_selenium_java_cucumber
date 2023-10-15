package stepDef;

import config.SetupDriver;
import config.elements.ElementFormLogin;
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

    @When("The user enters valid as username")
    public void userInputUserName() {
        WebElement userNameField = this.elementFormLogin.userName();
        userNameField.sendKeys(this.config.auth.getUserNameStandardUser());
    }

    @And("The user enters valid as password")
    public void userInputPassword() {
        WebElement passwordElement = this.elementFormLogin.password();
        passwordElement.sendKeys(this.config.auth.getPasswordStandardUser());
    }

    @When("The user enters invalid as username")
    public void userInputInValidUserName() {
        WebElement userNameField = this.elementFormLogin.userName();
        userNameField.sendKeys(this.config.auth.getUserNameFakeUser());
    }

    @And("The user enters invalid as password")
    public void userInputInValidPassword() {
        WebElement passwordElement = this.elementFormLogin.password();
        passwordElement.sendKeys(this.config.auth.getPasswordFakeUser());
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

    @Then("The user should be see error message")
    public void userFailedLogin() {
        int errorAlert = this.elementFormLogin.sizeErrorAlert();

        assertEquals(1, errorAlert);
    }

//    @After(order = 0)
//    public void closeBrowser() {
//        webDriver.close();
//    }
}
