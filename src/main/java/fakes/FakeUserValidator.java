package fakes;

public class FakeUserValidator extends UserValidator {
    private boolean userExists;

    @Override
    public boolean doesUsernameExist(String username) {
        return this.userExists;
    }

    public boolean doesUsernameExist(User usr, Database db) {
        for(User user : db.getUsers()){
            if (user.getUsername().equals(usr.getUsername())){
                return true;
            }
        }
        return false;
    }

    public void setUserExists(boolean userExists) {
        this.userExists = userExists;
    }
}