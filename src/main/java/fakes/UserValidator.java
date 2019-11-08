package fakes;

public class UserValidator {

    private static Database db = FileDatabase.getInstance();

    public static boolean doesUsernameExist(String username){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(User user : db.getUsers()){
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public static boolean isValidUsername(String username){
        return true;
    }
}
