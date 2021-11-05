package fakes;

public class FakeUserValidator extends UserValidator{
    private boolean userOk = true;


    @Override
    public boolean doesUsernameExist(String username) {
        return this.userOk;
    }

    public void setUserOk(boolean userOk) {
        this.userOk = userOk;
    }
}
