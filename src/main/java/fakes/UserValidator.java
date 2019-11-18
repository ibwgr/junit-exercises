package fakes;

public class UserValidator {

    private Database db;

    UserValidator(){

    }

    UserValidator(FileDatabase fileDatabase){
        this.db = fileDatabase;
    }

    public boolean doesUsernameExist(String username){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(User user : db.getUsers()){
            String name = user.getUsername().toUpperCase();

            if (name.equals(username.toUpperCase())){
                return true;
            }
        }
        return false;
    }

    public boolean isValidUsername(String username){
        char ch;
        for (int i= 0; i< username.length(); i++){
            ch = username.charAt(i);

            if (( i == 0 ) && ( Character.isDigit(ch))){
                return false;
            }

            if ( !Character.isAlphabetic(ch) && !Character.isDigit(ch) ){
                return false;
            }
        }
        return true;
    }
}
