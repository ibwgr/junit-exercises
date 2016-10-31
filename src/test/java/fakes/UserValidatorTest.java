package fakes;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

@RunWith(Enclosed.class)
public class UserValidatorTest {

    public static class isValidUsername{

        @Test
        public void returnsTrueIfOnlyLetters(){
            UserValidator userValidator = new UserValidator();

            boolean valid = userValidator.isValidUsername("Hans");

            Assert.assertTrue(valid);
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

    public static class doesUsernameExist{

        @Test
        public void MockDb_ReturnsFalseNotInDBYet(){

            Database database = Mockito.mock(Database.class);
            List<User> userList = new ArrayList<>();
            userList.add(new User("Peter"));

            Mockito.when(database.getUsers()).thenReturn(userList);

            UserValidator userValidator = new UserValidator(database);

            boolean exist = userValidator.doesUsernameExist("Hans");

            Assert.assertFalse(exist);


        }

        @Test
        public void FakeDb_ReturnsFalseNotInDBYet(){

            Database db = FakeFileDatabase.getInstance();
            UserValidator userValidator = new UserValidator(db);
            db.addUser(new User("Peter"));

            boolean exist = userValidator.doesUsernameExist("Hans");

            Assert.assertFalse(exist);
        }

        // Auf Deutsch:
        // returnsFalse_Falls_gleicherBenutzernameBereitsInDatenbank_AberMitUnterschiedlicherGrossKleinSchreibung
        @Test
        public void returnsTrueIfSameNameInDBButWithDifferentLetterCasing(){

            Database db = FakeFileDatabase.getInstance();
            UserValidator userValidator = new UserValidator(db);
            db.addUser(new User("hans"));

            boolean exist = userValidator.doesUsernameExist("Hans");

            Assert.assertTrue(exist);
        }


        @Test
        public void returnsTrueIfAlreadyInDB(){

            Database db = FakeFileDatabase.getInstance();
            UserValidator userValidator = new UserValidator(db);
            db.addUser(new User("Hans"));

            boolean exist = userValidator.doesUsernameExist("Hans");

            Assert.assertTrue(exist);
        }
    }
}
