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
        void returnsFalseIfUsernameNotInDBYet(){
           Database mockDatabase = mock(Database.class);

            final UserValidator uv = new UserValidator();
            final boolean usernameExist = uv.doesUsernameExist("peter");
            Assertions.assertFalse(usernameExist);
        }

        @Test
        void returnsTrueIfUsernameInDB(){
            throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsTrueIfSameNameInDBButWithDifferentLetterCasing(){
            throw new IllegalArgumentException("you should implement code here");
        }
    }
}
