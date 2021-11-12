package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.mockito.Mockito.mock;

class UserValidatorTest {

    @Nested
    class isValidUsername{

        @Test
        void returnsTrueIfOnlyLetters(){
            UserValidator validator = new UserValidator();                  //Stub
            Assertions.assertTrue(validator.isValidUsername("Heidi"),"returnsTrueIfOnlyLetters");
            //throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsFalseIfStartsWithNumber(){
            UserValidator validator = new UserValidator();                  //Stub
            Assertions.assertFalse(validator.isValidUsername("3Heidi"),"returnsFalseIfStartsWithNumber");
            //throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsTrueIfContainsNumberButNotAsFirstChar(){
            UserValidator validator = new UserValidator();                  //Stub
            Assertions.assertTrue(validator.isValidUsername("H8eidi"),"returnsTrueIfContainsNumberButNotAsFirstChar");
            //throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar(){
            UserValidator validator = new UserValidator();                  //Stub
            Assertions.assertFalse(false,"Hei!@#&()–[{}]:;'`,?/*~$^+=<>“di");
            //throw new IllegalArgumentException("you should implement code here");
        }

    }


    static class doesUsernameExist{

        @Test
        void returnsFalseIfUsernameNotInDBYet(){            //mokito testen validaor, nicht controller
//            Database mockDatabase = mock(Database.class);
//            mockDatabase.addUser(new User("Hand")); //zum testen
//            System.out.println(mockDatabase.getUsers());
//
//            final UserValidator uv = new UserValidator();
//
//            final boolean usernameExist = uv.doesUsernameExist("Peter");
//
//            Assertions.assertFalse(usernameExist);

            //throw new IllegalArgumentException("you should implement code here");

           //github
            Database mockDB = new MockDatabase();
            User newUser = new User("Peterli");
            mockDB.addUser(newUser);
            System.out.println(mockDB.getUsers());

            List<User> users = mockDB.getUsers();
            boolean isInDb = false;
            //int sinnlos = 0;
            for (User u: users) {
                if(u.getUsername().equals( "Peterli" )){//searchedUserName
                    System.out.println("gibt ein Perterli");
                    isInDb = true;
                }
            }

            Assertions.assertFalse(isInDb,"FalseIfUsernameNotInDBYet");//"Der Username "+ searchedUserName + " sollte nicht in der (Mock)Datenbank sein!"
            //throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsTrueIfUsernameInDB(){
            Database mockDB = new MockDatabase();
            User newUser = new User("Peterli");
            mockDB.addUser(newUser);
            System.out.println(mockDB.getUsers());

            List<User> users = mockDB.getUsers();
            boolean isInDb = false;
            //int sinnlos = 0;
            for (User u: users) {
                if(u.getUsername().equals( "Peterli" )){//searchedUserName
                    System.out.println("gibt ein Perterli");
                    isInDb = true;
                }
            }

            Assertions.assertTrue(isInDb,"TrueIfUsernameInDB");
            //throw new IllegalArgumentException("you should implement code here");
        }
    }
}

