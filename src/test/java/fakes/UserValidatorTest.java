package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserValidatorTest {

    @Nested
    class isValidUsername{

        @Test
        void returnsTrueIfOnlyLetters(){
            UserValidator userValidator = new UserValidator();

            boolean result = userValidator.isValidUsername("Alpha");

            Assertions.assertTrue(result);
        }

        @Test
        void returnsFalseIfStartsWithNumber(){
            UserValidator userValidator = new UserValidator();

            boolean result = userValidator.isValidUsername("7Number");

            Assertions.assertFalse(result);
        }

        @Test
        void returnsTrueIfContainsNumberButNotAsFirstChar(){
            UserValidator userValidator = new UserValidator();

            boolean result = userValidator.isValidUsername("LuckyNumber7");

            Assertions.assertTrue(result);
        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar(){
            UserValidator userValidator = new UserValidator();

            boolean result = userValidator.isValidUsername("A;'987");

            Assertions.assertFalse(result);
        }
    }




    static class doesUsernameExist{

        @Test
        void returnsFalseIfUsernameNotInDBYet(){
            FakeFileDatabase db = new FakeFileDatabase();
            UserValidator userValidator = new UserValidator(db);

            boolean isUserExisting = userValidator.doesUsernameExist("First user");

            Assertions.assertFalse(isUserExisting);
        }

        @Test
        void returnsTrueIfUsernameInDB(){
            FakeFileDatabase db = new FakeFileDatabase();
            User user = new User("First user");
            db.addUser(user);
            UserValidator userValidator = new UserValidator(db);

            boolean isUserExisting = userValidator.doesUsernameExist("First user");

            Assertions.assertTrue(isUserExisting);
        }

        @Test
        void returnsTrueIfSameNameInDBButWithDifferentLetterCasing(){
            FakeFileDatabase db = new FakeFileDatabase();
            User user = new User("Thomas1");
            db.addUser(user);
            UserValidator userValidator = new UserValidator(db);

            boolean isUserExisting = userValidator.doesUsernameExist("tHomas1");

            Assertions.assertTrue(isUserExisting);
        }
    }
}
