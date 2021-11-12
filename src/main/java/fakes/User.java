package fakes;

public class User {

    private String username;

    public User(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public boolean usernameContainsAnyNonAlphaNumericChar() {
        char[] chars = this.getUsername().toCharArray();
        for(char c : chars) {
            if(!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean usernameContainsNumberButNotAsFirstChar() {
        // starte mit i=1 damit der index 0 nicht beruecksichtigt wird
        for(int i = 1; i < this.getUsername().length(); i++) {
            char testChar = this.getUsername().charAt(i);
            if(Character.isDigit(testChar)) {
                return true;
            }
        }
        return false;
    }

    public boolean usernameOnlyLetters() {
        char[] chars = this.getUsername().toCharArray();
        for(char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}
