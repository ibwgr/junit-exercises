package fakes;

import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.matchers.JUnitMatchers;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

// @RunWith wird gebraucht, damit mit inner classes gearbeitet werden kann
@RunWith(Enclosed.class)
public class UserControllerTest {

    // Pro getestete Methode gibt es eine inner class (Hier für UserController.create)
    public static class create {

        // --- Testing with Fakes ---

        @Test
        public void NO_FAKE_withValidInexistingUsername_returnsOK() {
            UserValidator userValidator = new FakeUserValidator();
            UserController ctrl = new UserController(userValidator);
            User user = new User("kalua");

            Message result = ctrl.create(user);

            Assert.assertEquals(result.status, Message.Status.OK);
        }

        @Test
        public void MOCKITO_FAKE_withValidInexistingUsername_returnsOK() {
            // TODO
            // 1. Test schneller machen
            // 2. UserController.create so beinflussen,
            //      dass einmal der "if"- und einmal der "else"-Fall durchlaufen wird
            UserValidator userValidator = Mockito.mock(UserValidator.class);

            Mockito.when(userValidator.isValidUsername(Mockito.anyString())).thenReturn(true);
            Mockito.when(userValidator.doesUsernameExist(Mockito.anyString())).thenReturn(false);

            UserController ctrl = new UserController(userValidator);
            User user = new User("kalua");

            Message result = ctrl.create(user);

            Assert.assertEquals(Message.Status.OK, result.status);
        }

        @Test
        public void FAKE_DB_withValidInexitingUserName_addUserToDB() {

            UserValidator userValidator = Mockito.mock(UserValidator.class);

            Mockito.when(userValidator.isValidUsername(Mockito.anyString())).thenReturn(true);
            Mockito.when(userValidator.doesUsernameExist(Mockito.anyString())).thenReturn(false);

            Database db = Mockito.mock(Database.class);

            UserController ctrl = new UserController(db, userValidator);
            User user = new User("kalua");
            ctrl.create(user);

            Mockito.verify(db, Mockito.times(1)).addUser(Mockito.any(User.class));

        }


    // --- Testing Exceptions ---

    @Test
    public void TRY_CATCH_withNullUser_throwsIllegalArgumentExc() {
        try {
            UserController ctrl = new UserController();
            ctrl.create(null);
            Assert.fail("No IllegalArgumentExc was thrown");
        } catch (IllegalArgumentException ex) {
            // Optional: Test message
            Assert.assertEquals("user required", ex.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void EXPECTED_withNullUser_throwsIllegalArgumentExc() {
        UserController ctrl = new UserController();
        ctrl.create(null);
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void RULE_withNullUser_throwsIllegalArgumentExc() {
        expected.expect(IllegalArgumentException.class);
        // Optional: Test message
        expected.expectMessage(JUnitMatchers.containsString("required"));

        UserController ctrl = new UserController();
        ctrl.create(null);
    }

}
}
