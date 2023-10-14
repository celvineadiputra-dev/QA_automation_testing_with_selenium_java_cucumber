package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupDriver {
    protected final Config config;

    public WebDriver webDriver;

    public SetupDriver() {
        this.config = new Config();

        setUpTest();

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        openUrl();
    }

    static void setUpTest() {
        WebDriverManager.chromedriver().setup();
    }

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

    public String addPathToCurrentUrl(String path) {
        return this.config.getBaseUrl() + path;
    }

    public String getCurrentTitle() {
        return this.webDriver.getTitle();
    }
}
