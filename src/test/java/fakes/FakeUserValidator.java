package fakes;

import org.mockito.Mockito;

public class FakeUserValidator extends  UserValidator{

    private static Database db = FileDatabase.getInstance();



    public  boolean doesUsernameExist(String username){
        return false;
    }

    public  boolean isValidUsername(String username){
        return true;
    }
}
