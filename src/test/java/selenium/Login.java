package selenium;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Login {
    private final Config config;
    static WebDriver webDriver;

    public Login() {
        this.config = new Config();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @BeforeAll
    static void setupTest() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void openUrl() {
        System.out.println(this.config.getBaseUrl());
        webDriver.get(this.config.getBaseUrl());
    }

    @AfterEach
    void closeBrowser() {
        webDriver.quit();
    }

    @Test
    public void validateFieldUserName() {
        WebElement userName = webDriver.findElement(By.id("user-name"));
        assertTrue(userName.isDisplayed());
    }

    @Test
    public void validateFieldPassword() {
        WebElement password = webDriver.findElement(By.id("password"));
        assertTrue(password.isDisplayed());
    }

    @Test
    public void validateButtonLogin() {
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        assertTrue(loginButton.isDisplayed());
    }

    @Test
    @DisplayName("Login using : standard_user and correct password")
    public void successLogin() {
        WebElement userName = webDriver.findElement(By.id("user-name"));
        WebElement password = webDriver.findElement(By.id("password"));
        WebElement buttonLogin = webDriver.findElement(By.id("login-button"));

        userName.sendKeys(this.config.getUser(0));
        password.sendKeys(this.config.getPassword());
        buttonLogin.click();

        String currentUrl = webDriver.getCurrentUrl();

        assertEquals(this.config.currenUrl("inventory.html"), currentUrl);
    }

    @Test
    @DisplayName("Login using : standard_user and not valid password")
    public void failedLogin() {
        WebElement userName = webDriver.findElement(By.id("user-name"));
        WebElement password = webDriver.findElement(By.id("password"));
        WebElement buttonLogin = webDriver.findElement(By.id("login-button"));

        userName.sendKeys(this.config.getUser(0));
        password.sendKeys(this.config.getPassword() + "WrongPassword");
        buttonLogin.click();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String currentUrl = webDriver.getCurrentUrl();
        int errorAlert = webDriver.findElements(By.cssSelector(".error-message-container.error")).size();

        assertNotEquals(this.config.currenUrl("inventory.html"), currentUrl);
        assertEquals(1, errorAlert);
    }
}
