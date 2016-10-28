package fakes;

public class UserValidator {

    private static Database db = FileDatabase.getInstance();

    public boolean doesUsernameExist(String username){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return db.getUsers().stream()
                .filter(u ->
                        u.getUsername().equals(username)
                )
                .count() > 0;
    }

    public boolean isValidUsername(String username){
        return true;
    }
}
