package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UserControllerTest {

  // Pro getestete Methode gibt es eine inner class (Hier für UserController.create)
  @Nested
  class create {

    // --- Testing with Fakes ---
    @Test
    @org.junit.jupiter.api.Disabled
    void withValidInexistingUsername_returnsOK__NO_FAKE_DEMO() {
      // check
      try {
        // datenbankfile wird geleert...
        FileOutputStream writer = new FileOutputStream(FileDatabase.getPath());
        writer.write(("").getBytes());
        writer.close();
      } catch (IOException e) {
        System.out.println("IO Problem Filedatenbank");
        System.out.println(e.getMessage());
      }

      UserValidator uv = new UserValidator();
      UserController ctrl = new UserController(uv, FileDatabase.getInstance());

      // da die datenbank geleert wurde, gibts nun den testnamen nicht da drin
      User user = new User("kalua");

      Message result = ctrl.create(user);

      Assertions.assertEquals(result.status, Message.Status.OK);
    }

    @Test
    void withValidInexistingUsername_returnsOK__FAKE() {
      // check
      // 1. Test schneller machen
      // 2. UserController.create so beinflussen,
      //    dass einmal der "if"- und einmal der "else"-Fall durchlaufen wird
      // => der else-Fall findet sich in der Methode withValidExistingUsername_returnsNOTOK__FAKE

      FakeUserValidator fakeUserValidator = new FakeUserValidator();
      // User wurde nicht erkannt
      fakeUserValidator.setUserExists(false);
      UserController ctrl = new UserController(fakeUserValidator, new MockDatabase());
      User user = new User("kalua");

      Message result = ctrl.create(user);
      Assertions.assertEquals(result.status, Message.Status.OK);

    }

    @Test
    void withValidExistingUsername_returnsNOTOK__FAKE() {
      // check
      FakeUserValidator fakeUserValidator = new FakeUserValidator();
      // User wurde erkannt
      fakeUserValidator.setUserExists(true);
      UserController ctrl = new UserController(fakeUserValidator, new MockDatabase());
      User user = new User("kalua");

      Message result = ctrl.create(user);
      Assertions.assertEquals(result.status, Message.Status.NOT_OK);
    }


    @Test
    void withValidInexistingUsername_returnsOK__MOCKITO() {
      Database mockDatabase = mock(Database.class);
      UserValidator uv = mock(UserValidator.class);
      UserController ctrl = new UserController(uv, mockDatabase);
      User user = new User("kalua");

      // konfiguriere die rueckgabewerte der mockten-methoden
      doReturn(true).when(uv).isValidUsername(anyString());
      doReturn(false).when(uv).doesUsernameExist(anyString());

      Message result = ctrl.create(user);

      // pruefe, dass isValidUsername einmal aufgerufen wurde
      verify(uv, times(1)).isValidUsername(anyString());
      verify(uv, times(1)).doesUsernameExist(anyString());

      Assertions.assertEquals(result.status, Message.Status.OK);
    }

    @Test
    void returnsFalseIfUsernameNotInDBYet() {
      // check
      Database mockDatabase = mock(Database.class);
      final UserValidator uv = new UserValidator();

      List users = new ArrayList();
      users.add("Peter");
      doReturn(users).when(mockDatabase).getUsers();

      final boolean usernameExists = uv.doesUsernameExist("Peter");

      Assertions.assertFalse(usernameExists);
    }
    @Test
    void withValidInexistingUsername_addUserToDB__FAKE() {
      // Der Test soll prüfen, ob der Benutzer tatsächlich der DB hinzugefügt wurde.
      // Dazu soll ein Database Mock Objekt verwendet werden.
      FakeUserValidator fakeUserValidator = new FakeUserValidator();
      // User in der DB vorhanden simulieren
      fakeUserValidator.setUserExists(false);
      MockDatabase database = new MockDatabase();
      UserController ctrl = new UserController(fakeUserValidator, database);
      User user = new User("kurt");

      Message result = ctrl.create(user);
      Assertions.assertEquals(result.status, Message.Status.OK);

      // pruefen ob der username wirklich in der mockDB eingetragen wurde
      Assertions.assertTrue(database.doesUsernameExists(user.getUsername()));
    }

    @Test
    void withValidInexistingUsername_addUserToDB__MOCKITO() {
      UserValidator uv = mock(UserValidator.class);
      Database db = mock(Database.class);
      UserController ctrl = new UserController(uv, db);
      User user = new User("kalua");

      doReturn(true).when(uv).isValidUsername(anyString());
      doReturn(false).when(uv).doesUsernameExist(anyString());

      Message result = ctrl.create(user);
      verify(uv, times(1)).isValidUsername(anyString());
      verify(uv, times(1)).doesUsernameExist(anyString());

      Assertions.assertEquals(result.status, Message.Status.OK);
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
