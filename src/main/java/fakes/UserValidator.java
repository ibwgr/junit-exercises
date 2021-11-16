package fakes;

public class UserValidator {

    private Database db = FileDatabase.getInstance();

    public UserValidator() {
    }

    public UserValidator(Database db) {
        this.db = db;
    }

    public boolean doesUsernameExist(String username){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(User user : db.getUsers()){
            if (user.getUsername().equalsIgnoreCase(username)){
                return true;
            }
        }
        return false;
    }

//    // Regular Expression based solution
//    public boolean isValidUsername(String username){
//        if(username.matches("^\\d.*")){
//            return false;
//        }
//        if(!username.matches("^[\\w\\d]*$")){
//            return false;
//        }
//        return true;
//    }

    // ASCII Code based solution
    public boolean isValidUsername(String username){
        if(startsWithDigit(username)){
            return false;
        }
        if(containsSpecialChar(username)){
            return false;
        }
        return true;
    }

    private boolean containsSpecialChar(String value) {
        for(char c : value.toCharArray()){
            if (!isDigit(c) && !isAlpha(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean startsWithDigit(String value) {
        if(!value.isEmpty()){
            char firstChar = value.charAt(0);
            return isDigit(firstChar);
        }
        return false;
    }

    private boolean isAlpha(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    private boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }
}
