package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserValidatorTest {

    /**
     * Alle Tests in der folgenden Klasse isValidUsername sollen die Methode UserValidator.isValidUsername testen.
     */
    @Nested
    class isValidUsername {

        @Test
        void returnsTrueIfOnlyLetters() {
            // TODO Testcode anpassen, damit er das testet was der Testname sagt.
            Assertions.assertTrue(new UserValidator().isValidUsername(null));
        }

        @Test
        void returnsFalseIfStartsWithNumber(){
            // TODO implement test
        }

        @Test
        void returnsTrueIfContainsNumberButNotAsFirstChar() {
            // TODO implement test
        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar() {
            // TODO implement test
        }
    }

    /**
     * Alle Tests in der folgenden Klasse doesUsernameExist sollen die Methode UserValidator.doesUsernameExist testen.
     */
    static class doesUsernameExist {
        @Test
        void returnsFalseIfUsernameNotInDBYet__FAKE() {
            // TODO implementiere / ergänze den Test hier, so dass dieser kompiliert und grün ist.

            // boolean usernameExist = uv.doesUsernameExist("peter");

            // Assertions.assertFalse(usernameExist);
        }

        @Test
        void returnsFalseIfUsernameNotInDBYet__MOCKITO() {
            // TODO implement test
        }

        @Test
        void returnsTrueIfUsernameInDB__FAKE() {
            // TODO implementiere / ergänze den Test hier, so dass dieser kompiliert und grün ist.

            // boolean usernameExist = uv.doesUsernameExist("peter");

            // Assertions.assertTrue(usernameExist);
        }

        @Test
        void returnsTrueIfUsernameInDB__MOCKITO() {
            // TODO implement test
        }

        @Test
        void returnsTrueIfSameNameInDBButWithDifferentLetterCasing() {
            // TODO implement test
        }
    }
}
