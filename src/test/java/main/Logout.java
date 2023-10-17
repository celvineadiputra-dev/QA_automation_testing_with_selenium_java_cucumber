package main;

import config.Config;
import config.SetupDriver;
import config.elements.ElementInventory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Logout {
    private final SetupDriver setupDriver;
    private final Config config;
    private final ElementInventory elementInventory;

    public Logout(SetupDriver setupDriver) {
        this.setupDriver = setupDriver;
        this.config = this.setupDriver.getConfig();
        this.elementInventory = new ElementInventory(this.setupDriver.getWebDriver());
    }

    public void userClicksBurgerButton() {
        WebElement burgerButton = this.elementInventory.burgerButton();
        burgerButton.click();
    }

    public void userShouldSeeSlideMenu() {
        WebElement slideMenu = this.elementInventory.slideMenu();
        Assertions.assertTrue(slideMenu.isDisplayed());
    }

    public void userClicksLogout() {
        this.setupDriver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement logout = this.elementInventory.logout();
        logout.click();
    }

    public void userShouldBeRedirectedToLoginPage() {
        String currentUrl = this.setupDriver.getCurrentUrl();
        Assertions.assertEquals(this.config.getBaseUrl(), currentUrl);
    }
}
