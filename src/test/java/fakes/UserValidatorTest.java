package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

class UserValidatorTest {

    /**
     * Alle Tests in der folgenden Klasse isValidUsername sollen die Methode UserValidator.isValidUsername testen.
     * Damit alle Tests grün werden, musst du die Implementation von UserValidator.isValidUsername anpassen!
     */
    @Nested
    class isValidUsername {

        @Test
        void returnsTrueIfOnlyLetters() {
            // TODO Testcode anpassen, damit er das testet was der Testname sagt.
            UserValidator userValidator = new UserValidator();
            Assertions.assertTrue(userValidator.isValidUsername("Claudia"));
        }

        @Test
        void returnsFalseIfStartsWithNumber(){
            // TODO implement test
            UserValidator userValidator = new UserValidator();
            Assertions.assertFalse(userValidator.isValidUsername("1laudia"));
        }

        @Test
        void returnsTrueIfContainsNumberButNotAsFirstChar() {
            // TODO implement test
            UserValidator userValidator = new UserValidator();
            Assertions.assertTrue(userValidator.isValidUsername("Clau4dia"));
        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar() {
            // TODO implement test
            UserValidator userValidator = new UserValidator();
            Assertions.assertFalse(userValidator.isValidUsername("&udia"));
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
            // Arrange
            Database mockDb = new MockDatabase();
            UserValidator uv = new UserValidator(mockDb);
            //act
             boolean usernameExist = uv.doesUsernameExist("peter");
            //assert
             Assertions.assertFalse(usernameExist);
        }

        @Test
        void returnsFalseIfUsernameNotInDBYet__MOCKITO() {
            // TODO implement test
            //Arrange
            Database mockitoDb = mock(Database.class);
            UserValidator uv = new UserValidator(mockitoDb);
            //act
            boolean usernameExist = uv.doesUsernameExist("peter");
            //assert
            Assertions.assertFalse(usernameExist);

        }

        @Test
        void returnsTrueIfUsernameInDB__FAKE() {
            // TODO implementiere / ergänze den Test hier, so dass dieser kompiliert und grün ist.
            //Arrange
            Database mockDb = new MockDatabase();
            mockDb.addUser(new User("Uwe"));
            UserValidator uv = new UserValidator(mockDb);
            //act
             boolean usernameExist = uv.doesUsernameExist("Uwe");
            //Assert
             Assertions.assertTrue(usernameExist);
        }

        @Test
        void returnsTrueIfUsernameInDB__MOCKITO() {
            // TODO implement test
            //arrange
            Database mockitoDb = mock(Database.class);

            doReturn(Arrays.asList(new User("Hanelore"))).when(mockitoDb).getUsers();
            UserValidator uv = new UserValidator(mockitoDb);


            //act
            boolean usernameExist = uv.doesUsernameExist("Hanelore");
            //assert
            Assertions.assertTrue(usernameExist);

        }

        @Test
        void returnsTrueIfSameNameInDBButWithDifferentLetterCasing() {
            // TODO implement test
            //Arrange
            Database mockDb = new MockDatabase();
            User user1 = new User("UWE");
            UserValidator uv = new UserValidator(mockDb);
            mockDb.addUser(user1);

            //act
            boolean usernameExist = uv.doesUsernameExist("uwE");
            //Assert
            Assertions.assertTrue(usernameExist);

        }
    }
}
