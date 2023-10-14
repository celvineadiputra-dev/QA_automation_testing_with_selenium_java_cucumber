package stepDef;

import config.ElementFormLogin;
import config.SetupDriver;
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

    @Given("User already in app login page")
    public void user_already_in_app_login_page() {
        String currentTitle = this.getCurrentTitle();
        assertEquals("Swag Labs", currentTitle);
    }

    @When("User input username (.*)$")
    public void user_input_user_name_email(String email) {
        WebElement userNameField = this.elementFormLogin.userName();
        userNameField.sendKeys(email);
    }

    @And("User input password (.*)$")
    public void user_input_password_password(String password) {
        WebElement passwordElement = this.elementFormLogin.password();
        passwordElement.sendKeys(password);
    }

    @And("User click button login")
    public void user_click_button_login() {
        WebElement buttonLogin = this.elementFormLogin.loginButton();
        buttonLogin.click();
    }

    @Then("User will be redirect to dashboard screen")
    public void user_will_be_redirect_to_dashboard_screen() {
        String currentUrl = this.getCurrentUrl();
        Assertions.assertEquals(this.addPathToCurrentUrl("inventory.html"), currentUrl);
    }

    @Then("User should see an authentication error message")
    public void userShouldSeeAnAuthenticationErrorMessage() {
        int errorAlert = this.elementFormLogin.sizeErrorAlert();

        assertEquals(1, errorAlert);
    }
}
