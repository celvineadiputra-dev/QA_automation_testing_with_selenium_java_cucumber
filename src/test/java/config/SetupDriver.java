package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupDriver {
    protected final Config config;

    public WebDriver webDriver;

    public SetupDriver() {
        this.config = new Config();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @BeforeAll
    static void setUpTest() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void openUrl() {
        webDriver.get(this.config.getBaseUrl());
    }

    @AfterEach
    void closeBrowser() {
        webDriver.close();
    }

    public String getCurrentUrl() {
        return this.webDriver.getCurrentUrl();
    }

    public String getCurrentTitle() {
        return this.webDriver.getTitle();
    }
}
