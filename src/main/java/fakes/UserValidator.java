package fakes;

import java.util.Locale;

public class UserValidator {
    private static Database db;

    public UserValidator() {
        this.db = FileDatabase.getInstance();
    }
    public UserValidator(Database db) {
        this.db = db;
    }
    public boolean doesUsernameExist(String username){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        for(User user : db.getUsers()){
            if (user.getUsername().toLowerCase(Locale.ROOT).equals(username.toLowerCase(Locale.ROOT))){
                return true;
            }
        }
        return false;
    }

    public static boolean isValidUsername(String username){
        boolean result = true;

        // usernameContainsNumberButNotAsFirstChar
        // starte mit i=1 damit der index 0 nicht beruecksichtigt wird
        for(int i = 1; i < username.length(); i++) {
            char testChar = username.charAt(i);
            if(Character.isDigit(testChar)) {
                return true;
            }
        }

        char[] chars = username.toCharArray();
        for(char c : chars) {
            // usernameOnlyLetters
            if(!Character.isLetter(c)) {
                result = false;
            }
            // usernameContainsAnyNonAlphaNumericChar
            if(!Character.isLetterOrDigit(c)) {
                result = false;
            }
        }
        return result;
    }

}
