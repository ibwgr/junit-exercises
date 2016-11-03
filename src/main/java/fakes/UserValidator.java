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

        if(containsNonAlphanumericChar(username)){
            return false;
        }
        if(Character.isDigit(username.charAt(0))){
            return false;
        }
        if(checkForLettersOnly(username)){
            return true;
        }
        if(containsNumberButNotAsFirstChar(username)){
            return true;
        }
        return false;
    }


    private boolean checkForLettersOnly(String name){
        Matcher m = p.matcher(name);
        return m.matches();
    }

    private boolean containsNonAlphanumericChar(String name) {

        boolean noAlphanumeric = false;

        if (name != null && !name.isEmpty()) {
            for (char c : name.toCharArray()) {
                if (!Character.isLetterOrDigit(c)) {
                    noAlphanumeric = true;
                    break;
                }
            }
        }
        return noAlphanumeric;
    }

    private boolean containsNumberButNotAsFirstChar(String name){

        if (name != null && !name.isEmpty()) {
            if(Character.isDigit(name.charAt(0))){
                return false;
            }

            String shortName = name.substring(1, name.length());
            for (char c : shortName.toCharArray()){
               if(Character.isDigit(c)){
                   return  true;
               }
            }
        }
        return false;
    }
}
