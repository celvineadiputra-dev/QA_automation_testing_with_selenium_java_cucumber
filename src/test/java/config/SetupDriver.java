package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupDriver {
    private final Config config;
    private WebDriver webDriver;

    public SetupDriver() {
        config = new Config();

        setChromeDriver();
        setMaxScreen();
    }

    private void setChromeDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    private void setMaxScreen() {
        webDriver.manage().window().maximize();
    }

    public void openDefaultApp() {
        webDriver.get(config.getBaseUrl());
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public Config getConfig() {
        return config;
    }

    public String getCurrentUrl() {
        return this.webDriver.getCurrentUrl();
    }

    public SetupDriver getSetUpDriver() {
        return this;
    }
}
