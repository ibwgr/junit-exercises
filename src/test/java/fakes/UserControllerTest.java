package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class UserControllerTest {

  // Pro getestete Methode gibt es eine inner class (Hier für UserController.create)
  @Nested
  class create {

    // --- Testing with Fakes ---
    @Test
    @org.junit.jupiter.api.Disabled
    void withValidInexistingUsername_returnsOK__NO_FAKE_DEMO() {
      UserController ctrl = new UserController(new UserValidator());
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

      UserController ctrl = new UserController(new FakeUserValidator(false));
      User user = new User("peter");

      Message result = ctrl.create(user);

      Assertions.assertEquals(result.status, Message.Status.OK);
    }

    @Test
    void withValidExistingUsername_returnsNOK__FAKE() {
      // TODO
      // 1. Test schneller machen
      // 2. UserController.create so beinflussen,
      //    dass einmal der "if"- und einmal der "else"-Fall durchlaufen wird

      UserController ctrl = new UserController(new FakeUserValidator(true));
      User user = new User("kalua");

      Message result = ctrl.create(user);

      Assertions.assertEquals(result.status, Message.Status.NOT_OK);
    }


    @Test
    void withValidInexistingUsername_returnsOK__MOCKITO() {
      // TODO

      UserValidator uv = mock(UserValidator.class);
      doReturn(true).when(uv).doesUsernameExist(anyString());

      Assertions.assertTrue(uv.doesUsernameExist("Foo"));

    }

    @Test
    void withValidInexitingUsername_addUserToDB__FAKE() {
      // TODO
      // Der Test soll prüfen, ob der Benutzer tatsächlich der DB hinzugefügt wurde.
      // Dazu soll ein Database Mock Objekt verwendet werden.

      MockDatabase database = new MockDatabase();
      UserController ctrl = new UserController(new FakeUserValidator(false), database);
      User user = new User("peter");

      Message result = ctrl.create(user);

      Assertions.assertEquals(result.status, Message.Status.OK);
      boolean doesUserExist = false;
      for(User u : database.getUsers()){
        if (u.getUsername().equals("peter")){
          doesUserExist = true;
        }
      }
      Assertions.assertTrue(doesUserExist);
    }

    @Test
    void withValidInexitingUsername_addUserToDB__MOCKITO() {
      // TODO
      // Add User ist eine void method! -> kein return wert - ich fake einen Aufruf mit assertion true aber macht für mich keinen sinn...
      Database database = new MockDatabase();

      // Zur übung auch via mock könnte man aber einfach als FALSE definieren in der if unten
      String uname = "peterli";
      UserValidator uv = mock(UserValidator.class);
      doReturn(false).when(uv).doesUsernameExist(anyString());

      if(!uv.doesUsernameExist(uname)){
        User user = new User(uname);
        database.addUser(user);
        // add user ist eine Void method daher prüfen wir nach dem adden...
      }else{
        // Hier abfangen mit Exception?
        Assertions.fail("ein kleines whoopsie poopsi ist passiert - das dürfte nicht sein ;-)");
      }

      boolean doesUserExist = false;
      List<User> dbUsers = database.getUsers();
      for(User u : dbUsers){
        if (u.getUsername().equals(uname)){
          doesUserExist = true;
        }
      }
      Assertions.assertTrue(doesUserExist);

      // Die Add User kann nicht als Mock genutzt werden da dies eine void methode ist... So habe ich den UserValidator ge-"mockt"


    }

    // --- Testing Exceptions ---

//    @Test
//    void TRY_CATCH_withNullUser_throwsIllegalArgumentExc() {
//      try {
//        UserController ctrl = new UserController();
//        ctrl.create(null);
//        Assertions.fail("No IllegalArgumentException was thrown");
//      } catch (IllegalArgumentException ex) {
//        // Optional: Test message
//        Assertions.assertEquals("user required", ex.getMessage());
//      }
//    }

//    @Test
//    void THROWN_withNullUser_throwsIllegalArgumentException() {
//      Assertions.assertThrows(IllegalArgumentException.class, () -> {
//        UserController ctrl = new UserController();
//        ctrl.create(null);
//      });
//    }
//
//    @Test
//    void THROWN_MESSAGE_withNullUser_throwsIllegalArgumentExceptionWithMessage() {
//      Exception thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
//        UserController ctrl = new UserController();
//        ctrl.create(null);
//      });
//      Assertions.assertTrue(thrown.getMessage().contains("required"));
//    }
  }
}
