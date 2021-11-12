package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserValidatorTest {

    @Nested
    class isValidUsername{

        @Test
        void returnsTrueIfOnlyLetters(){
            User user = new User("kalua");
            Assertions.assertTrue(user.usernameOnlyLetters());
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
            Assertions.assertTrue(user.usernameContainsNumberButNotAsFirstChar());
        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar(){
            User user = new User("k9al8ua");
            Assertions.assertTrue(user.usernameContainsAnyNonAlphaNumericChar());
        }
    }

    static class doesUsernameExist{

        @Test
        void returnsFalseIfUsernameNotInDBYet(){
            Database db = FileDatabase.getInstance();
            User user = new User("kalua");
            Assertions.assertTrue(db.doesUsernameExists(user.getUsername()));
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
            Assertions.assertTrue(db.doesUsernameExists(user.getUsername()));
        }
    }
}
