package fakes;

//import jdk.internal.icu.text.UnicodeSet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author - John Schmidt
 * 19.11.2021, 13:39
 */
public class FakeDatabase extends Database{
    //private UnicodeSet users;//extends

    private List<User> users = new ArrayList<>();


    @Override
    public void addUser(User user){
        //mockList.add(user);
        users.add(user);
    }

    @Override
    public List<User> getUsers(){
        //return mockList;
        return users;
    }
}
