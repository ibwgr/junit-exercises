package fakes;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class UserValidatorTest {

    @Nested
    class isValidUsername{

        @Test
        void returnsTrueIfOnlyLetters(){
            throw new NotImplementedException();
        }

        @Test
        void returnsFalseIfStartsWithNumber(){
            throw new NotImplementedException();
        }

        @Test
        void returnsTrueIfContainsNumberButNotAsFirstChar(){
            throw new NotImplementedException();
        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar(){
            throw new NotImplementedException();
        }
    }

    static class doesUsernameExist{

        @Test
        void returnsTrueIfUsernameNotInDBYet(){
            throw new NotImplementedException();
        }

        @Test
        void returnsFalseIfUsernameInDB(){
            throw new NotImplementedException();
        }
    }
}
