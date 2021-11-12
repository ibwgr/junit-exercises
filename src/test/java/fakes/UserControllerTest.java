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
    @org.junit.jupiter.api.Disabled
    void withValidInexistingUsername_returnsOK__NO_FAKE_DEMO() {
      UserController ctrl = new UserController(new FakeUserValidator());
      User user = new User("kalua");//kalua

      Message result = ctrl.create(user);

      Assertions.assertEquals(result.status, Message.Status.OK);
    }

    @Test
    void withValidInexistingUsername_returnsOK__FAKE() {
      // TODO
      // 1. Test schneller machen
      // 2. UserController.create so beinflussen,
      //    dass einmal der "if"- und einmal der "else"-Fall durchlaufen wird

      UserController ctrl = new UserController(new FakeUserValidator(false));//false
//kopie von Methode oben
      User user = new User("peter");//peter

      Message result = ctrl.create(user);

      Assertions.assertEquals(result.status, Message.Status.OK);

    }

    @Test
    void withValidExistingUsername_returnsOK__FAKE() {
      // TODO
      // 1. Test schneller machen
      // 2. UserController.create so beinflussen,
      //    dass einmal der "if"- und einmal der "else"-Fall durchlaufen wird

      UserController ctrl = new UserController(new FakeUserValidator(true));
//kopie von oben
      User user = new User("kalua");

      Message result = ctrl.create(user);

      Assertions.assertEquals(result.status, Message.Status.NOT_OK);

    }

    @Test
    void withValidInexistingUsername_returnsOK__MOCKITO() {//mokito testen validaor, nicht controller
      // TODO
//      Database mockDatabase = mock(Database.class);
//      mockDatabase.addUser(new User("Hand"));
//      System.out.println(mockDatabase.getUsers());
    }

    @Test
    void withValidInexitingUsername_addUserToDB__FAKE() {     //Mok
      // TODO
      // Der Test soll prüfen, ob der Benutzer tatsächlich der DB hinzugefügt wurde.
      // Dazu soll ein Database Mock Objekt verwendet werden.
      final MockDatabase database = new MockDatabase();
      UserController ctrl = new UserController(new FakeUserValidator(false), database);
      User user = new User("peter");//kalua
      Message result = ctrl.create(user);

      Assertions.assertEquals(result.status, Message.Status.OK);
      boolean doesUserExist = false;
      for(User u : database.getUsers()){
        if(u.getUsername().equals(("Peter"))) {
          doesUserExist = true;
        }
      }
      Assertions.assertTrue(doesUserExist);
      //mit getuser


    }

    @Test
    void withValidInexitingUsername_addUserToDB__MOCKITO() {
      // TODO
    }

    // --- Testing Exceptions ---

    @Test
    void TRY_CATCH_withNullUser_throwsIllegalArgumentExc() {
      try {
        UserController ctrl = new UserController(new FakeUserValidator());
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
        UserController ctrl = new UserController(new FakeUserValidator());
        ctrl.create(null);
      });
    }

    @Test
    void THROWN_MESSAGE_withNullUser_throwsIllegalArgumentExceptionWithMessage() {
      Exception thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        UserController ctrl = new UserController(new FakeUserValidator());
        ctrl.create(null);
      });
      Assertions.assertTrue(thrown.getMessage().contains("required"));
    }
  }
}
