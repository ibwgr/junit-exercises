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
//      UserController ctrl = new UserController(new FakeUserValidator());    Letzter Stand Schule vor update
//      User user = new User("kalua");//kalua
//
//      Message result = ctrl.create(user);
//
//      Assertions.assertEquals(result.status, Message.Status.OK);


      // Arrange
      UserController ctrl = new UserController(new FakeUserValidator());
      User user = new User("peter");//kalua

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

      // TODO implement test
      UserController uc1 = new UserController(new FakeUserValidator());//false
      User u11 = new User("hanso");//peter

      Message result = uc1.create(u11);

      Assertions.assertEquals(result.status, Message.Status.OK);
    }

    @Test
    void withValidInexistentUsername_returnsOK__MOCKITO() {//mokito testen validaor, nicht controller
      // TODO implement test
//      Database mockDatabase = mock(Database.class);
//      mockDatabase.addUser(new User("Hand"));
//      System.out.println(mockDatabase.getUsers());

      //MockDatabase md1= new MockDatabase();//findet mockdatabase nicht, muss er finden, oder override

      Database mockDatabase = new MockDatabase();
      mockDatabase.addUser(new User("Hand"));
      System.out.println("irgendwas: "+mockDatabase.getUsers());

      //UserController ctrl = new UserController(new FakeUserValidator(false), md1);

      UserController uc1 = new UserController(new FakeUserValidator());

      User user1 = new User("peter");//kalua
      uc1.create(user1);
      System.out.println();


      Message result = uc1.create(user1);
      System.out.println("result: "+result);
      Assertions.assertEquals(result.status, Message.Status.OK);

    }

    @Test
    void withValidInexistentUsername_shouldAddUserToDB__FAKE() {
      // Der Test soll prüfen, ob der Benutzer tatsächlich der DB hinzugefügt wurde.
      // Dazu soll ein Mock-Objekt für die Database Klasse verwendet werden.

      // TODO implement test
      // Tipp: Wie kann dein Test feststellen, ob der UserController der Datenbank einen Benutzer hinzugefügt hat?
      //   Welche Art von Fake (Stub oder Mock) kann dir weiterhelfen?
//
//      final MockDatabase database = new MockDatabase();
//      UserController ctrl = new UserController(new FakeUserValidator(false), database);
//      User user = new User("peter");//kalua
//      Message result = ctrl.create(user);
//
//      Assertions.assertEquals(result.status, Message.Status.OK);
//      boolean doesUserExist = false;
//      for(User u : database.getUsers()){
//        if(u.getUsername().equals(("Peter"))) {
//          doesUserExist = true;
//        }
//      }
//      Assertions.assertTrue(doesUserExist);
      //mit getuser


    }

    @Test
    void withValidInexistentUsername_shouldAddUserToDB__MOCKITO() {
      // Der Test soll prüfen, ob der Benutzer tatsächlich der DB hinzugefügt wurde.
      // Dazu soll ein Mock-Objekt für die Database Klasse verwendet werden.

      // Tipp: Du kannst prüfen, ob der User hinzugefügt wurde,
      //  indem du prüfst wie of die Methode Database.addUser aufgerufen wurde.
      // TODO implement test
    }

    // --- Testing Exceptions ---

    @Test
    void withNullUser_throwsIllegalArgumentExc__TRY_CATCH() {
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
    void withNullUser_throwsIllegalArgumentException__THROWN() {
      Assertions.assertThrows(IllegalArgumentException.class, () -> {
        UserController ctrl = new UserController(new FakeUserValidator());
        ctrl.create(null);
      });
    }

    @Test
    void withNullUser_throwsIllegalArgumentExceptionWithMessage__THROWN_MESSAGE() {
      Exception thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        UserController ctrl = new UserController(new FakeUserValidator());
        ctrl.create(null);
      });
      Assertions.assertTrue(thrown.getMessage().contains("required"));
    }
  }
}
