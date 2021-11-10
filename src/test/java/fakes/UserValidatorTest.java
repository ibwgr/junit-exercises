package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class UserValidatorTest {

    @Nested
    class isValidUsername{

        @Test
        void returnsTrueIfOnlyLetters(){
            UserValidator validator = new UserValidator();
            boolean validName = validator.isValidUsername("Claudia");
            Assertions.assertTrue(validName);
        }

        @Test
        void returnsFalseIfStartsWithNumber(){
            UserValidator validator = new UserValidator();
            boolean validName = validator.isValidUsername("1Claudia");
            Assertions.assertFalse(validName);
        }

        @Test
        void returnsTrueIfContainsNumberButNotAsFirstChar(){
            UserValidator validator = new UserValidator();
            boolean validName = validator.isValidUsername("c2a3dia");
            Assertions.assertTrue(validName);
        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar(){
            UserValidator validator = new UserValidator();
            boolean validName = validator.isValidUsername("%inprozent");
            Assertions.assertFalse(validName);
        }
    }

    static class doesUsernameExist{

        @Test
        void returnsFalseIfUsernameNotInDBYet(){
           Database mockDatabase = mock(Database.class);

            final UserValidator uv = new UserValidator();
            final boolean usernameExist = uv.doesUsernameExist("peter");
            Assertions.assertFalse(usernameExist);
        }



        @Test
        void returnsTrueIfUsernameInDB(){
            Database db = new MockDatabase();
            User user = new User("peter");
            db.addUser(user);

            UserValidator userValidator = new FakeUserValidator(true, true);
            userValidator.doesUsernameExist("peter");
            boolean exists = userValidator.doesUsernameExist("peter");

            Assertions.assertTrue(exists);







        }

        @Test
        void returnsTrueIfSameNameInDBButWithDifferentLetterCasing(){
            throw new IllegalArgumentException("you should implement code here");
        }
    }
}
