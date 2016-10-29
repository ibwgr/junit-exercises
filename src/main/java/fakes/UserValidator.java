package fakes;

public class UserValidator {

    private Database db = FileDatabase.getInstance();

    public UserValidator() {}

    public UserValidator(Database db) {
        this.db = db;
    }

    public boolean doesUsernameExist(String username){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return db.getUsers().stream()
                .filter(u ->
                        u.getUsername().equalsIgnoreCase(username)
                )
                .count() > 0;
    }

    public boolean isValidUsername(String username){
        if (username.matches("^\\d.*")) {
            return false;
        }

        if (username.matches(".*[^\\w|\\s].*")) {
            return false;
        }

        return true;
    }
}
