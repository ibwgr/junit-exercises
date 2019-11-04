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
            Thread.sleep(50);
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

    public boolean isValidUsername(String username){
        if(username.matches("^\\d.*")){
            return false;
        }
        if(!username.matches("^[\\w\\d]*$")){
            return false;
        }
        return true;
    }
}
