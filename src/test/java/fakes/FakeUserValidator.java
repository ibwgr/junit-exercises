package fakes;
// Stupp
public class FakeUserValidator extends UserValidator{


    private  boolean doesUsernameExist;

    public FakeUserValidator(){

    }

    public FakeUserValidator(boolean doesUserNameExist ) {
        this.doesUsernameExist = doesUserNameExist;
    }

    @Override
    public boolean doesUsernameExist(String username) {
        if(username.equals("kalua")){
            return true;
        }
        return false;
    }
}
