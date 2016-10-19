package fakes;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RunWith(Enclosed.class)
public class UserValidatorTest {

    public static class isValidUserName{

        @Test
        public void returnsTrueIfOnlyLetters(){
            throw new NotImplementedException();
        }

        @Test
        public void returnsFalseIfStartsWithNumber(){
            throw new NotImplementedException();
        }

        @Test
        public void returnsTrueIfContainsNumberButNotAsFirstChar(){
            throw new NotImplementedException();
        }

        @Test
        public void returnsFalseIfContainsAnyNonAlphanumericChar(){
            throw new NotImplementedException();
        }
    }
}
