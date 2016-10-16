package fakes;

public class UserValidator {

    public static boolean isValidUsername(String username){
        return checkUserNameExistsViaNetwork(username)
                && checkUserNameIsValid(username);
    }

    private static boolean checkUserNameExistsViaNetwork(String username){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }


    private static boolean checkUserNameIsValid(String username){
        return false;
    }
}
