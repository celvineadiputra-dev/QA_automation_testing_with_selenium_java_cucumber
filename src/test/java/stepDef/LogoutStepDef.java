package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.Logout;

public class LogoutStepDef {
    private final Hook hook;
    private final Logout logout;

    public LogoutStepDef(Hook hook) {
        this.hook = hook;
        this.logout = new Logout(this.hook.getSetUpDriver());
    }

    @When("The user clicks the burger button")
    public void userClicksBurgerButton() {
        this.logout.userClicksBurgerButton();
    }

    @Then("The user should see the slide menu")
    public void userShouldSeeSlideMenu() {
        this.logout.userShouldSeeSlideMenu();
    }

    @Then("The user clicks logout")
    public void userClicksLogout() {
        this.logout.userClicksLogout();
    }

    @Then("The user should be redirected to the login page")
    public void userShouldBeRedirectedToLoginPage() {
        this.logout.userShouldBeRedirectedToLoginPage();
    }
}
