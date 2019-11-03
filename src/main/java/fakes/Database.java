package fakes;

import java.util.List;

public abstract class Database {
    public abstract void addUser(User user);
    public abstract List<User> getUsers();
}
