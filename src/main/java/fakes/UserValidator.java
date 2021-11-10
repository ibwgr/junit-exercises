package fakes;

public class UserValidator {

    private static Database db = FileDatabase.getInstance();

    public boolean doesUsernameExist(String username) {
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        for (User user : db.getUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidUsername(String username) {

        char[] letters = username.toCharArray();
        int position = 0;

        for (char letter: letters){
            if (!Character.isLetter(letter)|| !Character.isAlphabetic(letter)){
                if (Character.isDigit(letter) && position > 0){
                    continue;
                }
                return false;
            }
              position+=1;

        }
        return true;
    }
}
