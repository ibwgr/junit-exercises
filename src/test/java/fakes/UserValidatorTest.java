package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class UserValidatorTest {

    /**
     * Alle Tests in der folgenden Klasse isValidUsername sollen die Methode UserValidator.isValidUsername testen.
     * Damit alle Tests grün werden, musst du die Implementation von UserValidator.isValidUsername anpassen!
     */
    @Nested
    class isValidUsername {

        @Test
        public void returnsTrueIfOnlyLetters() {
            UserValidator userValidator = new UserValidator();

            boolean valid = userValidator.isValidUsername("Hans");

            Assertions.assertTrue(valid);
        }

        @Test
        public void returnsFalseIfStartsWithNumber() {
            UserValidator userValidator = new UserValidator();

            boolean valid = userValidator.isValidUsername("1Hans");

            Assertions.assertFalse(valid);
        }

        @Test
        public void returnsTrueIfContainsNumberButNotAsFirstChar() {
            UserValidator userValidator = new UserValidator();

            boolean valid = userValidator.isValidUsername("Hans1");

            Assertions.assertTrue(valid);
        }

        @Test
        public void returnsFalseIfContainsAnyNonAlphanumericChar() {
            UserValidator userValidator = new UserValidator();

            boolean valid = userValidator.isValidUsername("Hans-Peter");

            Assertions.assertFalse(valid);
        }
    }

    /**
     * Alle Tests in der folgenden Klasse doesUsernameExist sollen die Methode UserValidator.doesUsernameExist testen.
     * Damit alle Tests grün werden, musst du die Implementation von UserValidator.doesUsernameExist anpassen!
     */
    static class doesUsernameExist {
        @Test
        void returnsFalseIfUsernameNotInDBYet__FAKE() {
            Database db = new FakeDatabase();
            final UserValidator userValidator = new UserValidator(db);

            boolean usernameExist = userValidator.doesUsernameExist("peter");

            Assertions.assertFalse(usernameExist);
        }

        @Test
        void returnsFalseIfUsernameNotInDBYet__MOCKITO() {
            Database db = mock(Database.class);
            final UserValidator userValidator = new UserValidator(db);

            boolean usernameExist = userValidator.doesUsernameExist("peter");

            Assertions.assertFalse(usernameExist);
        }

        @Test
        void returnsTrueIfUsernameInDB__FAKE() {
            Database db = new FakeDatabase();
            final UserValidator userValidator = new UserValidator(db);
            db.addUser(new User("peter"));

            boolean usernameExist = userValidator.doesUsernameExist("peter");

            Assertions.assertTrue(usernameExist);
        }

        @Test
        void returnsTrueIfUsernameInDB__MOCKITO() {
            Database db = mock(Database.class);
            final UserValidator userValidator = new UserValidator(db);
            doReturn(Arrays.asList(new User("peter"))).when(db).getUsers();

            boolean usernameExist = userValidator.doesUsernameExist("peter");

            Assertions.assertTrue(usernameExist);
        }

        @Test
        void returnsTrueIfSameNameInDBButWithDifferentLetterCasing() {
            Database db = mock(Database.class);
            final UserValidator userValidator = new UserValidator(db);
            doReturn(Arrays.asList(new User("PETER"))).when(db).getUsers();

            boolean usernameExist = userValidator.doesUsernameExist("peter");

            Assertions.assertTrue(usernameExist);
        }
    }
}
