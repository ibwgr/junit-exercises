package fakes;

/**
 * @author - John Schmidt
 * 12.11.2021, 21:42
 */
public class FakeUserValidator extends UserValidator{               //Stand von Schule
    private boolean userExist;
    //private String userExist;

    public FakeUserValidator(boolean b) {
        this.userExist=userExist;
    }

    public FakeUserValidator() {}


    @Override
    public  boolean doesUsernameExist(String username){
//FalseIfUsernameNotInDBYet, dann wo db?


        return username.equals("kalua");
    }


}
