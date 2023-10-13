package config;

public class Config {
    private String baseUrl = "https://www.saucedemo.com/";
    private String[] users = {"standard_user", "locked_out_user", "problem_user", "error_user"};
    private String password = "secret_sauce";

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getUser(int index) {
        return this.users[index];
    }

    public String getPassword() {
        return this.password;
    }

    public String currenUrl(String path) {
        return this.baseUrl + path;
    }
}
