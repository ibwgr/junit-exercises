package fakes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    private static Database db = FileDatabase.getInstance();
    private Pattern p = Pattern.compile("[A-Za-z]+");

    public UserValidator() {
    }

    public UserValidator(Database db) {
        this.db = db;
    }

    public boolean doesUsernameExist(String username){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return db.getUsers().stream()
                .filter(u ->
                        u.getUsername().toLowerCase().equals(username.toLowerCase())
                )
                .count() > 0;
    }

    public boolean isValidUsername(String username){
        if(checkForLettersOnly(username)){
            return true;
        }
        return false;
    }

    private boolean checkForLettersOnly(String name){
        Matcher m = p.matcher(name);
        return m.matches();
    }
}
