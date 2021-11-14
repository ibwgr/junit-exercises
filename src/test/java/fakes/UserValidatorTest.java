package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class UserValidatorTest {

    /**
     * Alle Tests in der folgenden Klasse isValidUsername sollen die Methode UserValidator.isValidUsername testen.
     * Damit alle Tests grün werden, musst du die Implementation von UserValidator.isValidUsername anpassen!
     */
    @Nested
    class isValidUsername {

        @Test
        void returnsTrueIfOnlyLetters() {
            /* ARRANGE */
            UserValidator uv = new UserValidator();
            User user = new User("kalua");

            /* ACT */
            // -> Testcode anpassen, damit er das testet was der Testname sagt.
            boolean result = uv.isValidUsername(user.getUsername());

            /* ASSERT */
            Assertions.assertTrue(result);
        }

        @Test
        void returnsFalseIfStartsWithNumber(){
            // -> implement test
            /* ARRANGE */
            UserValidator uv = new UserValidator();
            User user = new User("1kalua");

            /* ACT */
            boolean result = uv.isValidUsername(user.getUsername());

            /* ASSERT */
            Assertions.assertFalse(result);
        }

        @Test
        void returnsTrueIfContainsNumberButNotAsFirstChar() {
            // -> implement test
            /* ARRANGE */
            UserValidator uv = new UserValidator();
            User user = new User("kalua1");

            /* ACT */
            boolean result = uv.isValidUsername(user.getUsername());

            /* ASSERT */
            Assertions.assertTrue(result);
        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar() {
            // -> implement test
            /* ARRANGE */
            UserValidator uv = new UserValidator();
            User user = new User("kal_ua");

            /* ACT */
            boolean result = uv.isValidUsername(user.getUsername());

            /* ASSERT */
            Assertions.assertFalse(result);
        }
    }

    /**
     * Alle Tests in der folgenden Klasse doesUsernameExist sollen die Methode UserValidator.doesUsernameExist testen.
     * Damit alle Tests grün werden, musst du die Implementation von UserValidator.doesUsernameExist anpassen!
     */
    static class doesUsernameExist {
        @Test
        void returnsFalseIfUsernameNotInDBYet__FAKE() {
            // -> implementiere / ergänze den Test hier, so dass dieser kompiliert und grün ist.
            /* ARRANGE */
            FakeUserValidator uv = new FakeUserValidator();
            uv.setUserExists(false);

            /* ACT */
            boolean usernameExist = uv.doesUsernameExist("peter");

            /* ASSERT */
            Assertions.assertFalse(usernameExist);
        }

        @Test
        void returnsFalseIfUsernameNotInDBYet__MOCKITO() {
            // -> implement test
            /* ARRANGE */
            UserValidator uv = mock(UserValidator.class);
            doReturn(false).when(uv).doesUsernameExist(anyString());

            /* ACT */
            boolean usernameNotInDb = uv.doesUsernameExist("peter");
            verify(uv, times(1)).doesUsernameExist(anyString());

            /* ASSERT */
            Assertions.assertFalse(usernameNotInDb);
        }

        @Test
        void returnsTrueIfUsernameInDB__FAKE() {
            // -> implementiere / ergänze den Test hier, so dass dieser kompiliert und grün ist.
            /* ARRANGE */
            FakeUserValidator uv = new FakeUserValidator();
            uv.setUserExists(true);

            /* ACT */
            boolean usernameExist = uv.doesUsernameExist("peter");

            /* ASSERT */
            Assertions.assertTrue(usernameExist);
        }

        @Test
        void returnsTrueIfUsernameInDB__MOCKITO() {
            // -> implement test
            /* ARRANGE */
            UserValidator uv = mock(UserValidator.class);
            doReturn(true).when(uv).doesUsernameExist(anyString());

            /* ACT */
            boolean usernameInDb = uv.doesUsernameExist("peter");
            verify(uv, times(1)).doesUsernameExist(anyString());

            /* ASSERT */
            Assertions.assertTrue(usernameInDb);
        }

        @Test
        void returnsTrueIfSameNameInDBButWithDifferentLetterCasing() {
            // -> implement test
            /* ARRANGE */
            UserValidator uv = new UserValidator();
            User userVorhanden = new User("kalua");
            UserController uc = new UserController(uv, FileDatabase.getInstance());
            uc.create(userVorhanden);
            User user = new User("kAlUa");

            /* ACT */
            boolean result = uv.doesUsernameExist(user.getUsername());

            /* ASSERT */
            Assertions.assertTrue(result);
        }
    }
}
