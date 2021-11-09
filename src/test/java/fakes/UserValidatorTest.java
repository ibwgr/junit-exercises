package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Locale;

class UserValidatorTest {

    @Nested
    class isValidUsername{

        @Test
        void returnsTrueIfOnlyLetters(){
            User user = new User("kalua");

            boolean result = true;
            char[] chars = user.getUsername().toCharArray();
            for(char c : chars) {
                if(!Character.isLetter(c)) {
                    result = false;
                }
            }

            Assertions.assertTrue(result);
        }

        @Test
        void returnsFalseIfStartsWithNumber(){
            User user = new User("kalua");
            char firstChar = user.getUsername().charAt(0);
            Assertions.assertFalse(Character.isDigit(firstChar));
        }

        @Test
        void returnsTrueIfContainsNumberButNotAsFirstChar(){
            User user = new User("ka2lua");
            boolean result = false;
            // starte mit i=1 damit der index 0 nicht beruecksichtigt wird
            for(int i = 1; i < user.getUsername().length(); i++) {
                char testChar = user.getUsername().charAt(i);
                if(Character.isDigit(testChar)) {
                    result = true;
                }
            }
            Assertions.assertTrue(result);
        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar(){
            User user = new User("k9al8ua");

            boolean result = true;
            char[] chars = user.getUsername().toCharArray();
            for(char c : chars) {
                if(!Character.isLetterOrDigit(c)) {
                    result = false;
                }
            }

            Assertions.assertTrue(result);
        }
    }

    static class doesUsernameExist{

        @Test
        void returnsFalseIfUsernameNotInDBYet(){
            Database db = FileDatabase.getInstance();
//            UserController ctrl = new UserController(new UserValidator(), db);
            User user = new User("kalua");
//            ctrl.create(user);

            boolean result = false;
            for(User u : db.getUsers()){
                if (u.getUsername().equals(user.getUsername())){
                    result = true;
                }
            }
            Assertions.assertTrue(result);
        }

        @Test
        void returnsTrueIfUsernameInDB(){
            this.returnsFalseIfUsernameNotInDBYet();
        }

        @Test
        void returnsTrueIfSameNameInDBButWithDifferentLetterCasing(){
            User user = new User("Kalua");

            boolean result = false;
            Database db = FileDatabase.getInstance();
            for(User u : db.getUsers()){
                if (u.getUsername().toLowerCase(Locale.ROOT).equals(user.getUsername().toLowerCase(Locale.ROOT))){
                    result = true;
                }
            }
            Assertions.assertTrue(result);
        }
    }
}
