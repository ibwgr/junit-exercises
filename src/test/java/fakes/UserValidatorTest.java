package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class UserValidatorTest {

    @Nested
    class isValidUsername{

        @Test
        void returnsTrueIfOnlyLetters(){

            String username = "OnlyLetters";

            UserValidator uv = new FakeUserValidator();

            Assertions.assertTrue(uv.isValidUsername(username));
        }

        @Test
        void returnsFalseIfStartsWithNumber(){

            String username = "2OnlyLetters";

            UserValidator uv = new FakeUserValidator();

            Assertions.assertFalse(uv.isValidUsername(username), "Namen dürfen nicht mit einer Zahl beginnen");

        }

        @Test
        void returnsTrueIfContainsNumberButNotAsFirstChar(){
            String username = "Only2Words";

            UserValidator uv = new FakeUserValidator();

            Assertions.assertTrue(uv.isValidUsername(username), "Namen dürfen nicht mit einer Zahl beginnen, dürfen diese aber enthalten");
        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar(){
            String username = "Only2_Words";

            UserValidator uv = new FakeUserValidator();

            Assertions.assertFalse(uv.isValidUsername(username), "Namen dürfen nur alphanumerische Zeichen enthalten [a-z][A-Z][0-9]");
        }
    }

    static class doesUsernameExist{

        @Test
        void returnsFalseIfUsernameNotInDBYet(){
            String searchedUserName = "NotInDb";

            Database db = new MockDatabase();
            User newUser = new User("Peter");
            db.addUser(newUser);

            List<User> users = db.getUsers();
            boolean isInDb = false;
            for (User u: users) {
                if(u.getUsername().equals( searchedUserName )){
                    isInDb = true;
                }
            }
            Assertions.assertFalse(isInDb,"Der Username "+ searchedUserName + " sollte nicht in der (Mock)Datenbank sein!");
        }

        @Test
        void returnsTrueIfUsernameInDB(){

            String searchedUserName = "IsInDb";

            Database db = new MockDatabase();
            User newUser = new User(searchedUserName);
            db.addUser(newUser);

            List<User> users = db.getUsers();
            boolean isInDb = false;
            for (User u: users) {
                if(u.getUsername().equals( searchedUserName )){
                    isInDb = true;
                }
            }
            Assertions.assertTrue(isInDb,"Der Username "+ searchedUserName + " sollte in der (Mock)Datenbank sein!");

        }

        @Test
        void returnsTrueIfSameNameInDBButWithDifferentLetterCasing(){

            String searchedUserName = "ProXimate";

            Database db = new MockDatabase();
            User newUser = new User("Proximate");
            db.addUser(newUser);

            List<User> users = db.getUsers();
            boolean isInDbDiffCase = false;
            for (User u: users) {
                if(u.getUsername().equalsIgnoreCase(searchedUserName)){
                    isInDbDiffCase = true;
                }
            }
            Assertions.assertTrue(isInDbDiffCase);

        }
    }
}
