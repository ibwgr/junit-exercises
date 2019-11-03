package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserControllerTest {

    // Pro getestete Methode gibt es eine inner class (Hier für UserController.create)
    @Nested
    class create{

        // --- Testing with Fakes ---

        @Test
        void NO_FAKE_withValidInexistingUsername_returnsOK(){
            UserController ctrl = new UserController();
            User user = new User("kalua");

            Message result = ctrl.create(user);

            Assertions.assertEquals(result.status, Message.Status.OK);
        }

        @Test
        void MOCKITO_FAKE_withValidInexistingUsername_returnsOK(){
            // TODO
            // 1. Test schneller machen
            // 2. UserController.create so beinflussen,
            //    dass einmal der "if"- und einmal der "else"-Fall durchlaufen wird
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
