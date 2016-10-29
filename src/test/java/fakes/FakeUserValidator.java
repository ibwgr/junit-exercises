package fakes;

import org.mockito.Mockito;

public class FakeUserValidator extends UserValidator{
    public boolean doesUsernameExist(String username){
        return false;
    }

    public boolean isValidUsername(String username){
        return true;
    }
}
