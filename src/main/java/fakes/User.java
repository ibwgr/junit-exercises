package fakes;

import java.util.Locale;

public class User {

    private String username;

    public User(String username){
        this.username = username.toLowerCase(Locale.ROOT);
    }

    public String getUsername() {
        return username;
    }
}
