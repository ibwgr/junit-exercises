package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserControllerTest {

    // Pro getestete Methode gibt es eine inner class (Hier für UserController.create)
    @Nested
    class create{

        // --- Testing with Fakes ---

        @Test
        void withValidInexistingUsername_returnsOK__NO_FAKE(){
            // - Dieser Test ist nicht wiederholbar.
            //   Beim zweiten Durchlauf schlägt er fehl, weil dann der Benutzer bereits in der Datenbank existiert
            // - Dieser Test ist langsam, weil er von der langsamen Datenbank abhängig ist.
            UserController ctrl = new UserController();
            User user = new User("kalua");

            Message result = ctrl.create(user);

            Assertions.assertEquals(Message.Status.OK, result.status);
        }

        @Test
        void withValidInexistingUsername_returnsOK__FAKE(){
            UserValidator userValidator = new FakeUserValidator(false, true);

            UserController ctrl = new UserController(userValidator);
            User user = new User("kalua");

            Message result = ctrl.create(user);

            Assertions.assertEquals(Message.Status.OK, result.status);
        }

        @Test
        void withValidInexistingUsername_returnsOK__MOCKITO(){
            UserValidator userValidator = mock(UserValidator.class);

            when(userValidator.isValidUsername(anyString())).thenReturn(true);
            when(userValidator.doesUsernameExist(anyString())).thenReturn(false);

            UserController ctrl = new UserController(userValidator);
            User user = new User("kalua");

            Message result = ctrl.create(user);

            Assertions.assertEquals(Message.Status.OK, result.status);
        }

        @Test
        void withValidInexistingUsername_addsUserToDB__FAKE(){
            UserValidator userValidator = new FakeUserValidator(false, true);
            Database db = new FakeDatabase();

            UserController ctrl = new UserController(userValidator, db);
            ctrl.create(new User("h"));

            Assertions.assertEquals("h", db.getUsers().get(0).getUsername());
        }

        @Test
        void withValidInexistingUsername_addsUserToDB__MOCKITO(){
            UserValidator userValidator = mock(UserValidator.class);

            // doReturn... ist ähnlich wie when().thenReturn.
            // Bei doReturn... wird die Methode isValidUsername allerdings nicht gleich aufgerufen.
            // doReturn(true).when(userValidator).isValidUsername(anyString());
            when(userValidator.isValidUsername(anyString())).thenReturn(true);
            when(userValidator.doesUsernameExist(anyString())).thenReturn(false);

            Database db = mock(Database.class);

            UserController ctrl = new UserController(userValidator, db);
            ctrl.create(new User("h"));

            verify(db, times(1)).addUser(any(User.class));
        }

        // --- Testing Exceptions ---

        @Test
        void TRY_CATCH_withNullUser_throwsIllegalArgumentExc(){
            try{
                UserController ctrl = new UserController();
                ctrl.create(null);
                Assertions.fail("No IllegalArgumentException was thrown");
            }catch(IllegalArgumentException ex){
                // Optional: Test message
                Assertions.assertEquals("user required", ex.getMessage());
            }
        }

        @Test
        void THROWN_withNullUser_throwsIllegalArgumentException(){
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                UserController ctrl = new UserController();
                ctrl.create(null);
            });
        }

        @Test
        void THROWN_MESSAGE_withNullUser_throwsIllegalArgumentExceptionWithMessage(){
            Exception thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                UserController ctrl = new UserController();
                ctrl.create(null);
            });
            Assertions.assertTrue(thrown.getMessage().contains("required"));
        }
    }
}
