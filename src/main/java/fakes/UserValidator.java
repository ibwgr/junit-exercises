package fakes;

public class UserValidator {

    private static Database db = FileDatabase.getInstance();

    public boolean doesUsernameExist(String username){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(User user : db.getUsers()){
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public boolean isValidUsername(String username){

        // Check if only Letters
        char[] chars = username.toCharArray();

        int pos = 0;
        for (char c : chars) {
            if(!Character.isLetter(c)) {
                if(Character.isDigit(c) && pos > 0){
                    continue;
                }
                return false;
            }
            pos += 1;
        }

        return true;
    }
}
