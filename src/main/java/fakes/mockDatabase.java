package fakes;

import java.util.ArrayList;
import java.util.List;

public class mockDatabase extends Database {
    List<User> users = new ArrayList<>();
    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
