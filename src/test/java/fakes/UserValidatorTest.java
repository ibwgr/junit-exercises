package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

class UserValidatorTest {

    @Nested
    class isValidUsername{

        @Test
        void returnsTrueIfOnlyLetters(){
            throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsFalseIfStartsWithNumber(){
            throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsTrueIfContainsNumberButNotAsFirstChar(){
            throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar(){
            throw new IllegalArgumentException("you should implement code here");
        }
    }

    static class doesUsernameExist{

        @Test
        void MOCKITO_returnsFalseIfUsernameNotInDBYet(){
            Database db = Mockito.mock(Database.class);
            Mockito.doReturn(Collections.emptyList()).when(db).getUsers();

            UserValidator userValidator = new UserValidator(db);
            boolean exists = userValidator.doesUsernameExist("hiddenfigure");

            Assertions.assertFalse(exists);
        }

        @Test
        void FAKE_returnsFalseIfUsernameNotInDBYet(){
            Database db = new FakeDatabase();

            UserValidator userValidator = new UserValidator(db);
            boolean exists = userValidator.doesUsernameExist("hiddenfigure");

            Assertions.assertFalse(exists);
        }

        @Test
        void MOCKITO_returnsTrueIfUsernameInDB(){
            Database db = Mockito.mock(Database.class);
            Mockito.doReturn(Arrays.asList(new User("claud"))).when(db).getUsers();

            UserValidator userValidator = new UserValidator(db);
            boolean exists = userValidator.doesUsernameExist("claud");

            Assertions.assertTrue(exists);
        }

        @Test
        void FAKE_returnsTrueIfUsernameInDB(){
            FakeDatabase db = new FakeDatabase();
            db.addUser(new User("claud"));

            UserValidator userValidator = new UserValidator(db);
            boolean exists = userValidator.doesUsernameExist("claud");

            Assertions.assertTrue(exists);
        }

        @Test
        void FAKE_returnsTrueIfSameNameInDBButWithDifferentLetterCasing(){
            FakeDatabase db = new FakeDatabase();
            db.addUser(new User("CLAUD"));

            UserValidator userValidator = new UserValidator(db);
            boolean exists = userValidator.doesUsernameExist("claud");

            Assertions.assertTrue(exists);
        }
    }
}
