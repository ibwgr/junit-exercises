package fakes;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
        void returnsTrueIfUsernameNotInDBYet(){
            throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsFalseIfUsernameInDB(){
            throw new IllegalArgumentException("you should implement code here");
        }
    }
}
