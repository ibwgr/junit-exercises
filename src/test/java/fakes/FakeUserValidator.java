package fakes;

public class FakeUserValidator extends UserValidator {

    private boolean isValid;    //injection sagt man dem, von aussen bestimmen was passieren soll

    public  FakeUserValidator(boolean isValid, boolean isExisting){
        this.isValid=isValid;
        this.isExisting=isExisting;
    }

    @Override
    public boolean isValidUsername(String username){
        return isValid;
    }
}
