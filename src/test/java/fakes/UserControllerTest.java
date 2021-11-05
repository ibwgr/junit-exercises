package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class UserControllerTest {

  // Pro getestete Methode gibt es eine inner class (Hier für UserController.create)
  @Nested
  class create {

    // --- Testing with Fakes ---
    @Test
    @org.junit.jupiter.api.Disabled
    void withValidInexistingUsername_returnsOK__NO_FAKE_DEMO() {
      UserController ctrl = new UserController(new FakeUserValidator(), new MockDatabase());
      User user = new User("kalua");

      Message result = ctrl.create(user);

      Assertions.assertEquals(result.status, Message.Status.OK);
    }

    @Test
    void withValidInexistingUsername_returnsOK__FAKE() {
      // TODO
      // 1. Test schneller machen
      // 2. UserController.create so beinflussen,
      //    dass einmal der "if"- und einmal der "else"-Fall durchlaufen wird
      FakeUserValidator fakeUserValidator = new FakeUserValidator();
      // User wurde nicht erkannt
      fakeUserValidator.setUserOk(false);
      UserController ctrl = new UserController(fakeUserValidator, new MockDatabase());
      User user = new User("kalua");

      Message result = ctrl.create(user);
      Assertions.assertEquals(result.status, Message.Status.OK);

    }

    @Test
    void withValidExistingUsername_returnsNOTOK__FAKE() {
      FakeUserValidator fakeUserValidator = new FakeUserValidator();
      // User wurde erkannt
      fakeUserValidator.setUserOk(true);
      UserController ctrl = new UserController(fakeUserValidator, new MockDatabase());
      User user = new User("kalua");

      Message result = ctrl.create(user);
      Assertions.assertEquals(result.status, Message.Status.NOT_OK);
    }


    @Test
    void withValidInexistingUsername_returnsOK__MOCKITO() {
      // TODO
    }

    @Test
    void returnsFalseIfUsernameNotInDBYet() {
      Database mockDatabase = mock(Database.class);
      final UserValidator uv = new UserValidator();

    List users = new ArrayList();
    users.add("peter");
      doReturn(users).when(mockDatabase).getUsers();
      final boolean usernameExists = uv.doesUsernameExist("peter");

      Assertions.assertFalse(usernameExists);
    }
    @Test
    void withValidInexistingUsername_addUserToDB__FAKE() {
      // TODO
      // Der Test soll prüfen, ob der Benutzer tatsächlich der DB hinzugefügt wurde.
      // Dazu soll ein Database Mock Objekt verwendet werden.
      FakeUserValidator fakeUserValidator = new FakeUserValidator();
      // User wurde erkannt
      fakeUserValidator.setUserOk(true);
      MockDatabase database = new MockDatabase();
      UserController ctrl = new UserController(fakeUserValidator, database);
      User user = new User("peter");

      Message result = ctrl.create(user);
      Assertions.assertEquals(result.status, Message.Status.NOT_OK);

      boolean doesUserExists = false;
      for(User u : database.getUsers()){
        if (u.getUsername().equals("peter")){
          doesUserExists = true;
        }
      }
      Assertions.assertTrue(doesUserExists);
    }

    @Test
    void withValidInexistingUsername_addUserToDB__MOCKITO() {
      // TODO
    }

    // --- Testing Exceptions ---

    @Test
    void TRY_CATCH_withNullUser_throwsIllegalArgumentExc() {
      try {
        UserController ctrl = new UserController(new FakeUserValidator(), new MockDatabase());
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
        UserController ctrl = new UserController(new FakeUserValidator(), new MockDatabase());
        ctrl.create(null);
      });
    }

    @Test
    void THROWN_MESSAGE_withNullUser_throwsIllegalArgumentExceptionWithMessage() {
      Exception thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        UserController ctrl = new UserController(new FakeUserValidator(), new MockDatabase());
        ctrl.create(null);
      });
      Assertions.assertTrue(thrown.getMessage().contains("required"));
    }
  }
}
