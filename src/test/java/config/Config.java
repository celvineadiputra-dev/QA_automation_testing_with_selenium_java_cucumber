package config;

import config.models.User;

public class Config {
    private final String baseUrl = "https://www.saucedemo.com/";

    public User standardUser, lockedOutUser, problemUser, errorUser;

    public Config() {
        this.standardUser = new User("standard_user", "secret_sauce");
        this.lockedOutUser = new User("locked_out_user", "secret_sauce");
        this.problemUser = new User("problem_user", "secret_sauce");
        this.errorUser = new User("error_user", "secret_sauce");
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String currentUrl(String path) {
        return this.baseUrl + path;
    }

    public User getStandardUser() {
        return this.standardUser;
    }

    public User getLockedOutUser() {
        return this.lockedOutUser;
    }

    public User getProblemUser() {
        return this.problemUser;
    }

    public User getErrorUser() {
        return this.errorUser;
    }
}
