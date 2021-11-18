package fakes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserValidator {

    private  Database db = FileDatabase.getInstance();

    public UserValidator() {
    }

    public UserValidator(Database db) {
        this.db = db;
    }

    public boolean doesUsernameExist(String username) {
        for (User user : this.db.getUsers()) {
            if (user.getUsername().equals(username.toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidUsername(String username) {
        List<Character> chars = new ArrayList<>();
        int position = 0;

        for (char ch : username.toCharArray()) {
            chars.add(ch);
            if (!Character.isAlphabetic(ch) ||!Character.isLetter(ch) ) {
                if (Character.isDigit(ch) && position > 0 ) {
                    continue;

                }
                return false;
            }
            position+=1;



        }
        return true;
    }

}
