package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

class UserValidatorTest {

    /**
     * Alle Tests in der folgenden Klasse isValidUsername sollen die Methode UserValidator.isValidUsername testen.
     * Damit alle Tests grün werden, musst du die Implementation von UserValidator.isValidUsername anpassen!
     */
    @Nested
    class isValidUsername {

        @Test
        void returnsTrueIfOnlyLetters(){
            UserValidator userValidator = new UserValidator();

            boolean isValid = userValidator.isValidUsername("abc");

            Assertions.assertTrue(isValid);
        }

        @Test
        void returnsFalseIfStartsWithNumber(){
          UserValidator userValidator = new UserValidator();

          boolean isValid = userValidator.isValidUsername("1abc");

          Assertions.assertFalse(isValid);
        }

        @Test
        void returnsTrueIfContainsNumberButNotAsFirstChar(){
            UserValidator userValidator = new UserValidator();

            boolean isValid = userValidator.isValidUsername("a1bc");

            Assertions.assertTrue(isValid);
        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar(){
            UserValidator userValidator = new UserValidator();

            boolean isValid = userValidator.isValidUsername("abc!");

            Assertions.assertFalse(isValid);
        }
    }

    /**
     * Alle Tests in der folgenden Klasse doesUsernameExist sollen die Methode UserValidator.doesUsernameExist testen.
     * Damit alle Tests grün werden, musst du die Implementation von UserValidator.doesUsernameExist anpassen!
     */
    static class doesUsernameExist {
        @Test
        void returnsFalseIfUsernameNotInDBYet__FAKE() {
            // TODO implementiere / ergänze den Test hier, so dass dieser kompiliert und grün ist.

            // boolean usernameExist = uv.doesUsernameExist("peter");

            // Assertions.assertFalse(usernameExist);
        }

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
