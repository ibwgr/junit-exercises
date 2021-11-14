package fakes;

public class FakeUserValidator extends UserValidator {
    private boolean userExists;

    @Override
    public boolean doesUsernameExist(String username) {
        return this.userExists;
    }

    public void setUserExists(boolean userExists) {
        this.userExists = userExists;
    }
}
