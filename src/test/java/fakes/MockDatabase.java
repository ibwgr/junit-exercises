package fakes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author - John Schmidt
 * 12.11.2021, 19:20
 */
public class MockDatabase extends Database{       //Name Mock okay; weil extends, hat addUser + getUser, weil original database ist abstract

    //List<User> mockList = new ArrayList<>();    //irgendwie mit Zeit kann man sich vorstellen, warum man diese Liste mit Objekten braucht
    List<User> users = new ArrayList<>();         //damit stand von Schule...
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
