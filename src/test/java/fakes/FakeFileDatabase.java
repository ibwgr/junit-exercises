package fakes;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FakeFileDatabase extends FileDatabase {

    private List<User> users = new ArrayList<>();

    public static FakeFileDatabase instance;


    public static Database getInstance(){
        instance = new FakeFileDatabase();
        return instance;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }


}
