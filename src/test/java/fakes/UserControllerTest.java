package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserControllerTest {

  // Pro getestete Methode gibt es eine inner class (Hier für UserController.create)
  @Nested
  class create {

    // --- Testing with Fakes ---

        @Test
        void withValidInexistingUsername_returnsOK_NO_FAKE(){
            UserController ctrl = new UserController();
            User user = new User("kalua");

      Message result = ctrl.create(user);

      Assertions.assertEquals(result.status, Message.Status.OK);
    }

        @Test
        void withValidInexistingUsername_returnsOK_FAKE(){
            UserController userController = new UserController();

        }

   /*     @Test
   // I DON'T UNDERSTAND THIS ONE :@
        void MOCKITO_FAKE_withValidInexistingUsername_returnsOK() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            // TODO
            User user1= new User("Kalua");
            User user2= new User("Hannes");

            UserController test1 = new UserController();
            UserController test2 = new UserController();

            Message message1 = new Message();
            Method privateMessage = Message.class.getDeclaredMethod("Message", String.class);
            privateMessage.setAccessible(true);
            String returnValue = (String) privateMessage.invoke(message1, null);


            db.addUser(user1); // user1 bereits in die db rein

            //durchläuft else
            test1.create(user1);
            //durchläuft if
            test2.create(user2);

            //Assertions.assertTrue(!(!UserValidator.doesUsernameExist(user1.getUsername()) Message.createOK()));
            Assertions.assertEquals(message1, "OK");
            // 1. Test schneller machen
            // 2. UserController.create so beinflussen,
            //      dass einmal der "if"- und einmal der "else"-Fall durchlaufen wird
        }
*/

    @Test
    void withValidInexitingUserName_addUserToDB__FAKE() {
      // TODO
    }

    @Test
    void withValidInexitingUserName_addUserToDB__MOCKITO() {
      // TODO
    }

    // --- Testing Exceptions ---

    @Test
    void TRY_CATCH_withNullUser_throwsIllegalArgumentExc() {
      try {
        UserController ctrl = new UserController();
        ctrl.create(null);
        Assertions.fail("No IllegalArgumentException was thrown");
      } catch (IllegalArgumentException ex) {
        // Optional: Test message
        Assertions.assertEquals("user required", ex.getMessage());
      }
    }

    @Test
    void THROWN_withNullUser_throwsIllegalArgumentException() {
      Assertions.assertThrows(IllegalArgumentException.class, () -> {
        UserController ctrl = new UserController();
        ctrl.create(null);
      });
    }

    @Test
    void THROWN_MESSAGE_withNullUser_throwsIllegalArgumentExceptionWithMessage() {
      Exception thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        UserController ctrl = new UserController();
        ctrl.create(null);
      });
      Assertions.assertTrue(thrown.getMessage().contains("required"));
    }
  }
}
