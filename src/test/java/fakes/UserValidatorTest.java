package fakes;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class UserValidatorTest {

    @Nested
    class isValidUsername{

        @Test
        void returnsTrueIfOnlyLetters(){

        }

        @Test
        void returnsFalseIfStartsWithNumber(){

        }

        @Test
        void returnsTrueIfContainsNumberButNotAsFirstChar(){

        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar(){

        }
    }

    static class doesUsernameExist{

        @Test
        void returnsTrueIfUsernameNotInDBYet(){

        }

        @Test
        void returnsFalseIfUsernameInDB(){

        }
    }
}
