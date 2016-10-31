package fakes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nett on 31.10.16
 */
public class FakeFileDatabase extends Database {

    public static FakeFileDatabase instance;
    private List<User> users = null;

    public static Database getInstance(){
        if(instance == null){
            instance = new FakeFileDatabase();
        }
        return instance;
    }

    public FakeFileDatabase(){
        users = new ArrayList<User>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
