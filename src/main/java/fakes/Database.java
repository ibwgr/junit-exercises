package fakes;

import java.util.List;

/**
 * Created by ideadapt on 19.10.16.
 */
public abstract class Database {
    public abstract void addUser(User user);
    public abstract List<User> getUsers();
}
