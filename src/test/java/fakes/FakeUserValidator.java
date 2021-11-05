package fakes;

public class FakeUserValidator extends UserValidator {
    private boolean doesUsernameExists;

    public FakeUserValidator(boolean doesUsernameExists){
        this.doesUsernameExists = doesUsernameExists;
    }
    public FakeUserValidator(){
        // doesUsernameExists == false so
    }

    @Override
    public boolean doesUsernameExist(String username) {
        return doesUsernameExists;
    }
}
