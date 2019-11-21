package fakes;

public class FakeUserValidator extends UserValidator {


    private boolean isValid;
    private boolean isExisting;

    public FakeUserValidator( boolean isValid, boolean isExisting) {
        super(new FileDatabase());
        this.isValid = isValid;
        this.isExisting = isExisting;
    }


    @Override
    public boolean isValidUsername(String username) {
        return this.isValid;
    }

    @Override
    public boolean doesUsernameExist(String username) {
        return this.isExisting;
    }
}
