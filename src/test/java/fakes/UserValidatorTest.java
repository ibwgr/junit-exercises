package fakes;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.internal.util.collections.ListUtil;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Enclosed.class)
public class UserValidatorTest {

    public static class isValidUserName{

        @Test
        public void returnsTrueIfOnlyLetters(){
            UserValidator userValidator = new UserValidator();

            boolean result = userValidator.isValidUsername("John Mayer");
            Assert.assertTrue(result);
        }

        @Test
        public void returnsFalseIfStartsWithNumber(){
            UserValidator userValidator = new UserValidator();

            boolean result = userValidator.isValidUsername("123 John Mayer");
            Assert.assertFalse(result);
        }

        @Test
        public void returnsTrueIfContainsNumberButNotAsFirstChar(){
            UserValidator userValidator = new UserValidator();

            boolean result = userValidator.isValidUsername("John Mayer 123");
            Assert.assertTrue(result);
        }

        @Test
        public void returnsFalseIfContainsAnyNonAlphanumericChar(){
            UserValidator userValidator = new UserValidator();

            boolean result = userValidator.isValidUsername("John * Mayer");
            Assert.assertFalse(result);
        }
    }

    public static class doesUsernameExist{

        @Test
        public void returnsTrueIfUsernameExists(){
            Database db = mock(Database.class);
            List<User> users = new ArrayList<>();
            users.add(new User("Harry Chapin"));
            users.add(new User("John Mayer"));
            users.add(new User("Bud Powell"));
            users.add(new User("Ed Sheeran"));

            when(db.getUsers()).thenReturn(users);

            UserValidator userValidator = new UserValidator(db);

            boolean result = userValidator.doesUsernameExist("John Mayer");

            Assert.assertTrue(result);
        }

        @Test
        public void returnsFalseIfUsernameNotExists(){
            Database db = mock(Database.class);
            List<User> users = new ArrayList<>();
            users.add(new User("Harry Chapin"));
            users.add(new User("Bud Powell"));
            users.add(new User("Ed Sheeran"));

            when(db.getUsers()).thenReturn(users);

            UserValidator userValidator = new UserValidator(db);

            boolean result = userValidator.doesUsernameExist("John Mayer");

            Assert.assertFalse(result);
        }

        @Test
        public void returnsFalseNotInDBYet(){
            Database db = mock(Database.class);
            List<User> users = new ArrayList<>();
            users.add(new User("Harry Chapin"));
            users.add(new User("Ed Sheeran"));

            when(db.getUsers()).thenReturn(users);

            UserValidator userValidator = new UserValidator(db);

            boolean result = userValidator.doesUsernameExist("John Mayer");

            Assert.assertFalse(result);
        }

        // Zu Deutsch:
        // returnsFalse_Falls_gleicherBenutzernameBereitsInDatenbank_AberMitUnterschiedlicherGrossKleinSchreibung
        @Test
        public void returnsTrueIfSameNameInDBButWithDifferentLetterCasing(){
            Database db = mock(Database.class);
            List<User> users = new ArrayList<>();
            users.add(new User("Harry Chapin"));
            users.add(new User("Ed Sheeran"));

            when(db.getUsers()).thenReturn(users);

            UserValidator userValidator = new UserValidator(db);

            boolean result = userValidator.doesUsernameExist("harry chapin");

            Assert.assertTrue(result);
        }

        @Test
        public void returnsTrueIfAlreadyInDB(){
            Database db = mock(Database.class);
            List<User> users = new ArrayList<>();
            users.add(new User("Harry Chapin"));
            users.add(new User("Ed Sheeran"));

            when(db.getUsers()).thenReturn(users);

            UserValidator userValidator = new UserValidator(db);

            boolean result = userValidator.doesUsernameExist("Harry Chapin");

            Assert.assertTrue(result);
        }
    }
}
