package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class UserControllerTest {

  // Pro getestete Methode gibt es eine inner class (Hier für UserController.create)
  @Nested
  class create {

    // --- Testing with Fakes ---

    @Test
    @org.junit.jupiter.api.Disabled
    void withValidInexistingUsername_returnsOK__NO_FAKE_DEMO() {
      // Arrange
      UserController ctrl = new UserController(new UserValidator(), FileDatabase.getInstance());
      User user = new User("kalua");

      // Act
      Message result = ctrl.create(user);

      // Assert
      Assertions.assertEquals(result.status, Message.Status.OK);
    }

    @Test
    void withValidInexistentUsername_returnsOK__FAKE() {
      // 1. Test schneller machen
      // 2. UserController.create so beeinflussen,
      //    dass einmal der "if"- und einmal der "else"-Fall durchlaufen wird

      // Tipp: Welche Methode sorgt dafür, dass canCreate im UserController true bzw. false ist?
      //  Kannst du deren Rückgabetyp beeinflussen?

      // Die Schritte die du ausprogrammieren musst:
      // 1. Arrange: UserController mit allen Abhängigkeiten initialisieren
      // 2. Act: UserController.create Methode aufrufen
      // 3. Assert: Rückgabewert von UserController.create prüfen

      // -> implement test
      /* Arrange */
      FakeUserValidator uv = new FakeUserValidator();
      UserController uc = new UserController(uv, new mockDatabase());
      User user = new User("kalua");
      /* Act */
      Message result = uc.create(user);
      /* Assert */
      Assertions.assertEquals(result.status, Message.Status.OK);
    }

    @Test
    void withValidInexistentUsername_returnsOK__MOCKITO() {
      // -> implement test
      /* ARRANGE */
      UserValidator uv = mock(UserValidator.class);
      FileDatabase db = mock(FileDatabase.class);
      UserController uc = new UserController(uv, db);
      User user = new User("kalua");
      /* ACT */
      Message result = uc.create(user);
      /* ASSERT */
      Assertions.assertEquals(result.status, Message.Status.OK);
    }

    @Test
    void withValidInexistentUsername_shouldAddUserToDB__FAKE() {
      // Der Test soll prüfen, ob der Benutzer tatsächlich der DB hinzugefügt wurde.
      // Dazu soll ein Mock-Objekt für die Database Klasse verwendet werden.

      // -> implement test
      // Tipp: Wie kann dein Test feststellen, ob der UserController der Datenbank einen Benutzer hinzugefügt hat?
      //   Welche Art von Fake (Stub oder Mock) kann dir weiterhelfen?
      /* ARRANGE */
      FakeUserValidator uv = new FakeUserValidator();
      uv.setUserExists(false);
      mockDatabase db = new mockDatabase();
      UserController uc = new UserController(uv, db);
      User user = new User("kalua");
      /* ACT */
      Message result = uc.create(user);
      boolean result2 = uv.doesUsernameExist(user, db);
      /* ASSERT */
      Assertions.assertEquals(result.status, Message.Status.OK);
      Assertions.assertTrue(result2);
    }

    @Test
    void withValidInexistentUsername_shouldAddUserToDB__MOCKITO() {
      // Der Test soll prüfen, ob der Benutzer tatsächlich der DB hinzugefügt wurde.
      // Dazu soll ein Mock-Objekt für die Database Klasse verwendet werden.

      // Tipp: Du kannst prüfen, ob der User hinzugefügt wurde,
      //  indem du prüfst wie of die Methode Database.addUser aufgerufen wurde.
      // -> implement test
      /* ARRANGE */
      UserValidator uv = mock(UserValidator.class);
      FileDatabase db = mock(FileDatabase.class);
      UserController uc = new UserController(uv, db);
      User user = new User("kalua");

      doReturn(true).when(uv).isValidUsername(anyString());
      // eigentlich müsste untenstehende anweisung rein, ergibt jedoch einen error... keine ahnung wieso.
      //doReturn(true).when(uv).doesUsernameExist(anyString());

      /* ACT */
      Message result = uc.create(user);
      verify(db, times(1)).addUser(any());

      /* ASSERT */
      Assertions.assertEquals(result.status, Message.Status.OK);
    }

    // --- Testing Exceptions ---

    @Test
    void withNullUser_throwsIllegalArgumentExc__TRY_CATCH() {
      try {
        UserController ctrl = new UserController(new UserValidator(), FileDatabase.getInstance());
        ctrl.create(null);
        Assertions.fail("No IllegalArgumentException was thrown");
      } catch (IllegalArgumentException ex) {
        // Optional: Test message
        Assertions.assertEquals("user required", ex.getMessage());
      }
    }

    @Test
    void withNullUser_throwsIllegalArgumentException__THROWN() {
      Assertions.assertThrows(IllegalArgumentException.class, () -> {
        UserController ctrl = new UserController(new UserValidator(), FileDatabase.getInstance());
        ctrl.create(null);
      });
    }

    @Test
    void withNullUser_throwsIllegalArgumentExceptionWithMessage__THROWN_MESSAGE() {
      Exception thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        UserController ctrl = new UserController(new UserValidator(), FileDatabase.getInstance());
        ctrl.create(null);
      });
      Assertions.assertTrue(thrown.getMessage().contains("required"));
    }
  }
}