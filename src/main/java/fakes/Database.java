package fakes;

import java.util.List;

public abstract class Database {
    public abstract void addUser(User user);
    public abstract List<User> getUsers();

    /**
     * Checks if a username exists in DB
     */
    public boolean doesUsernameExists(String username) {
        for(User u : this.getUsers()) {
            if(u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
