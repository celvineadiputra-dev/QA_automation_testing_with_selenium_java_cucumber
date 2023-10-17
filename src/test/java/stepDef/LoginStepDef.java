package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.Login;

public class LoginStepDef {
    private final Hook hook;
    private Login login;

    public LoginStepDef(Hook hook) {
        this.hook = hook;
        this.login = new Login(this.hook.getSetUpDriver());
    }

    @Given("The user opens the web page or app")
    public void openApp() {
        this.hook.openDefaultApp();
    }

    @When("The user enters a valid username")
    public void enterValidUserName() {
        this.login.enterValidUserName();
    }

    @When("The user enters a invalid username")
    public void enterInValidUserName() {
        this.login.enterInValidUserName();
    }

    @And("The user enters a valid password")
    public void enterValidPassword() {
        this.login.enterValidPassword();
    }

    @And("The user enters a invalid password")
    public void enterInValidPassword() {
        this.login.enterInValidPassword();
    }

    @And("The user clicks the login button")
    public void clickLoginButton() {
        this.login.clickLoginButton();
    }

    @Then("The user should be logged in successfully")
    public void verifyUserLoggedIn() {
        this.login.verifyUserLoggedIn();
    }

    @Then("The user should be see error message")
    public void verifyAlert() {
        this.login.verifyAlert();
    }
}
