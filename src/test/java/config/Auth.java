package config;

import config.models.User;

public class Auth {
    private final User standardUser;
    private final User fakeUser;

    public Auth() {
        this.standardUser = new User("standard_user", "secret_sauce");
        this.fakeUser = new User("", "secret_sauce");
    }

    public String getUserNameStandardUser() {
        return this.standardUser.getUserName();
    }

    public String getPasswordStandardUser() {
        return this.standardUser.getPassword();
    }

    public String getUserNameFakeUser() {
        return this.fakeUser.getUserName();
    }

    public String getPasswordFakeUser() {
        return this.fakeUser.getPassword();
    }
}
