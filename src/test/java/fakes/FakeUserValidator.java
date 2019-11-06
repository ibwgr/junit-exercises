package fakes;

public class FakeUserValidator extends UserValidator {

    private final boolean usernameExists;
    private final boolean validUsername;

    public FakeUserValidator(boolean usernameExists, boolean validUsername) {
        this.usernameExists = usernameExists;
        this.validUsername = validUsername;
    }

    public boolean doesUsernameExist(String username){
        return usernameExists;
    }

    public boolean isValidUsername(String username){
        return validUsername;
    }
}
