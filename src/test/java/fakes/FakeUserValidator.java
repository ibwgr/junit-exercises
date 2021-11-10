package fakes;
// Stupp
public class FakeUserValidator extends UserValidator{


    private  boolean doesUsernameExist;
    private boolean isValidUsername;

    public FakeUserValidator(){

    }

    public FakeUserValidator(boolean doesUserNameExist, boolean isValidUsername ) {
        this.doesUsernameExist = doesUserNameExist;
        this.isValidUsername = isValidUsername;
    }

    /*@Override
   public boolean doesUsernameExist(String username) {
        if(username.equals("kalua")){
            return true;
        }
        return false;
    }*/
    public boolean DoesUsernameExist(String username){
        return doesUsernameExist;
    }

    public boolean isValidUsername(String username){
        return isValidUsername;
    }


}
