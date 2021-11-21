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

//    public void ausgebenFakeDBLaenge(){
//        System.out.println("Länge der FakeDB.size: "+users.size());
//    }

    @Override
    public void addUser(User user){
        //mockList.add(user);
        users.add(user);
        System.out.println("addUser getUserName: "+user.getUsername());
        System.out.println("Länge der addUser FakeDB.size: "+users.size());
    }

    @Override
    public List<User> getUsers(){
        //return mockList;
//        for (int i = 0; i< users.size();i++){
//
//            System.out.println(users);
//        }
        System.out.println("Länge der getUser FakeDB.size: "+users.size());
        return users;
    }
}
