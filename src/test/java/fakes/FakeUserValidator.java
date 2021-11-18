package fakes;

public class FakeUserValidator extends UserValidator {

    private boolean usernameExist;
    private boolean validUsername;

    public FakeUserValidator(boolean usernameExist, boolean validUsername) {
        this.usernameExist = usernameExist;
        this.validUsername = validUsername;
    }


    @Override
    public boolean doesUsernameExist(String username) {
        return this.usernameExist;
    }

    @Override
    public boolean isValidUsername(String username) {
        return this.validUsername;
    }
}
