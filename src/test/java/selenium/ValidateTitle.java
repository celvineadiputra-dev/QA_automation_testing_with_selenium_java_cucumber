package selenium;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateTitle {
    private final Config config;
    static WebDriver webDriver;

    public ValidateTitle() {
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
        webDriver.close();
    }

    @Test
    public void validateTitle() {
        String title = webDriver.getTitle();
        assertEquals("Swag Labs", title);
    }
}
