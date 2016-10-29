package fakes;

import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.matchers.JUnitMatchers;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.mockito.Mockito.*;

// @RunWith wird gebraucht, damit mit inner classes gearbeitet werden kann
@RunWith(Enclosed.class)
public class UserControllerTest {

    // Pro getestete Methode gibt es eine inner class (Hier für UserController.create)
    public static class create{

        // --- Testing with Fakes ---

        @Test
        public void NO_FAKE_withValidInexistingUsername_returnsOK(){
            // Dieser Test ist nicht wiederholbar.
            // Beim zweiten Durchlauf schlägt er fehl, weil dann der Benutzer bereits in der Datenbank existiert
            // Dieser Test ist langsam, weil er von der langsamen Datenbank abhängig ist.
            UserController ctrl = new UserController();
            User user = new User("kalua");

            Message result = ctrl.create(user);

            Assert.assertEquals(Message.Status.OK, result.status);
        }

        @Test
        public void MOCKITO_FAKE_withValidInexistingUsername_returnsOK(){
            // 1. Test schneller & wiederholbar machen
            // 2. UserController.create so beinflussen,
            //      dass einmal der "if"- und einmal der "else"-Fall durchlaufen wird

            UserValidator userValidator = mock(UserValidator.class);

            when(userValidator.isValidUsername(anyString())).thenReturn(true);
            when(userValidator.doesUsernameExist(anyString())).thenReturn(false);


            UserController ctrl = new UserController(userValidator);
            User user = new User("kalua");

            Message result = ctrl.create(user);

            Assert.assertEquals(Message.Status.OK, result.status);
        }

        @Test
        public void FAKE_DB_withValidInexistingUsername_addsUserToDB(){
            UserValidator userValidator = mock(UserValidator.class);

            when(userValidator.isValidUsername(anyString())).thenReturn(true);
            when(userValidator.doesUsernameExist(anyString())).thenReturn(false);

            Database db = mock(Database.class);

            UserController ctrl = new UserController(userValidator, db);
            ctrl.create(new User("h"));

            verify(db, times(1)).addUser(any(User.class));
        }


        // --- Testing Exceptions ---

        @Test
        public void TRY_CATCH_withNullUser_throwsNPE(){
            try{
                UserController ctrl = new UserController();
                ctrl.create(null);
                Assert.fail("No NPE was thrown");
            }catch(NullPointerException ex){
                // Optional: Test message
                Assert.assertEquals("User required", ex.getMessage());
            }
        }

        @Test(expected = NullPointerException.class)
        public void EXPECTED_withNullUser_throwsNPE(){
            UserController ctrl = new UserController();
            ctrl.create(null);
        }

        @Rule
        public ExpectedException expected = ExpectedException.none();

        @Test
        public void RULE_withNullUser_throwsNPE(){
            expected.expect(NullPointerException.class);
            // Optional: Test message
            expected.expectMessage(JUnitMatchers.containsString("required"));

            UserController ctrl = new UserController();
            ctrl.create(null);
        }
    }
}
