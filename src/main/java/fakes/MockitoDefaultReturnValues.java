package fakes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ideadapt on 29.10.16.
 */
public class MockitoDefaultReturnValues {

    public void returnVoid(){
    }

    public boolean returnBoolean(){
        return true;
    }

    public Integer returnInteger(){
        return 10;
    }

    public int returnInt(){
        return 10;
    }

    public User returnUser(){
        return new User("");
    }

    public List<User> returnUserList(){
        ArrayList userList = new ArrayList();
        userList.add(new User(""));
        return userList;
    }
}
