package stepDef;

import config.elements.ElementFormLogin;
import config.elements.ElementInventory;
import config.models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class State {
    private final ElementFormLogin elementFormLogin;
    private final ElementInventory elementInventory;

    private final User user;

    public State(WebDriver webDriver, User user) {
        this.elementFormLogin = new ElementFormLogin(webDriver);
        this.elementInventory = new ElementInventory(webDriver);
        this.user = user;
    }

    public void login() {
        WebElement userNameField = this.elementFormLogin.userName();
        WebElement passwordField = this.elementFormLogin.password();

        userNameField.sendKeys(this.user.getUserName());
        passwordField.sendKeys(this.user.getPassword());

        this.elementFormLogin.loginButton().click();
    }

    public void userAddTwoProduct() {
        WebElement pSauceLabsBackpack = this.elementInventory.buttonAddToCart("sauce-labs-backpack");
        WebElement pSauceLabsBikeLight = this.elementInventory.buttonAddToCart("sauce-labs-bike-light");
        pSauceLabsBackpack.click();
        pSauceLabsBikeLight.click();
    }

    public void userInCartPage() {
        WebElement shoppingCartContainer = this.elementInventory.shoppingCartContainer();
        shoppingCartContainer.click();
    }
}
