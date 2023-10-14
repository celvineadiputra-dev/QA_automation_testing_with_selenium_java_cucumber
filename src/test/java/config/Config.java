package config;

public class Config {
    private final String baseUrl = "https://www.saucedemo.com/";

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String currentUrl(String path) {
        return this.baseUrl + path;
    }
}
