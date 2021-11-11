package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class UserControllerTest {

  // Pro getestete Methode gibt es eine inner class (Hier für UserController.create)
  @Nested
  class create {

    // --- Testing with Fakes ---
    @Test
    @org.junit.jupiter.api.Disabled
    void withValidInexistingUsername_returnsOK__NO_FAKE_DEMO() {
      UserController ctrl = new UserController(new FakeUserValidator(true, true));
      User user = new User("kalua");

      Message result = ctrl.create(user);

      Assertions.assertEquals(result.status, Message.Status.NOT_OK);
    }


    @Test
    void withValidInexistingUsername_returnsOK__FAKE() {
      // TODO
      // 1. Test schneller machen
      // 2. UserController.create so beinflussen,
      //    dass einmal der "if"- und einmal der "else"-Fall durchlaufen wird
      //Warum NullPointerException? Musste Mockdatabase erzeugen..

      MockDatabase db = new MockDatabase();
      UserController ctrl = new UserController(new FakeUserValidator(false, true), db );
      User user = new User("peter");

      Message result = ctrl.create(user);

      Assertions.assertEquals(result.status, Message.Status.OK);

    }

    @Test
    void withValidInexistingUsername_returnsNOT_OK__FAKE() {
      // TODO
      // 1. Test schneller machen
      // 2. UserController.create so beinflussen,
      //    dass einmal der "if"- und einmal der "else"-Fall durchlaufen wird
      UserController ctrl = new UserController(new FakeUserValidator(true, true));
      User user = new User("kalua");

      Message result = ctrl.create(user);

      Assertions.assertEquals(result.status, Message.Status.NOT_OK);

    }

    @Test
    void withValidInexistingUsername_returnsOK__MOCKITO() {
      // TODO
      //uv = Meine FakeUservalidation
      //db = Meine FakeDataBase
      //UserController Konstruktor mit parameter UserValidation, Database aufrufen
      UserValidator uv = mock(UserValidator.class);
      Database db = mock(Database.class);
      UserController ctrl = new UserController(uv, db);

      doReturn(true).when(uv).isValidUsername(anyString());
      doReturn(false).when(uv).doesUsernameExist(anyString());

      User user = new User("kalua");
      Message result = ctrl.create(user);
      Assertions.assertEquals(result.status, Message.Status.OK);
    }

    @Test
    void withValidInexitingUsername_addUserToDB__FAKE() {
      // TODO
      // Der Test soll prüfen, ob der Benutzer tatsächlich der DB hinzugefügt wurde.
      // Dazu soll ein Database Mock Objekt verwendet werden.
      MockDatabase database =new MockDatabase();
      UserController ctrl = new UserController(new FakeUserValidator(false, true), database);
      User user = new User("peter");

      Message result = ctrl.create(user);

      Assertions.assertEquals(result.status, Message.Status.OK);


      boolean doesUserExists = false;
      for (User u : database.getUsers()){
        if (u.getUsername().equals("peter")){
          doesUserExists = true;
        }
      }
      Assertions.assertTrue(doesUserExists);

    }

    @Test
    void withValidInexitingUsername_addUserToDB__MOCKITO() {
      // TODO
      UserValidator uv = mock(UserValidator.class);
      Database db = mock(Database.class);
      UserController ctrl = new UserController(uv, db);
      User user = new User("kalua");
      User user2 = new User("peter");

      doReturn(true).when(uv).isValidUsername(anyString());
      doReturn(false).when(uv).doesUsernameExist(anyString());
      db.addUser(user);


//überpüft wieviel mal der User auf der Datenbank registriert wurde
      verify(db, times(1)).addUser(any(User.class));

      }

      @Test
      void withValidInexistingUsername_addUser2xToDB__MOCKITO(){
        UserValidator uv = mock(UserValidator.class);
        Database db = mock(Database.class);
        UserController ctrl = new UserController(uv, db);
        User user = new User("kalua");
        User user2 = new User("peter");

        doReturn(true).when(uv).isValidUsername(anyString());
        doReturn(false).when(uv).doesUsernameExist(anyString());
        db.addUser(user);
        db.addUser(user2);


        verify(db, times(2)).addUser(any(User.class));


      }
      @Test
       void withValidInexistingUsername_addUser2xToDBSameUser__MOCKITO() {
      UserValidator uv = mock(UserValidator.class);
      UserValidator uv2 = mock(UserValidator.class);
      Database db = mock(Database.class);
      UserController ctrl = new UserController(uv, db);
      UserController ctrl2 = new UserController(uv2, db);
      User user = new User("kalua");

        doReturn(true).when(uv).isValidUsername(anyString());
        doReturn(false).when(uv).doesUsernameExist(anyString());

        Message result = ctrl.create(user);

       Assertions.assertEquals(result.status, Message.Status.OK);


      doReturn(true).when(uv2).isValidUsername(anyString());
      doReturn(true).when(uv2).doesUsernameExist(anyString());

      Message result2 = ctrl2.create(user);
      Assertions.assertEquals(result2.status, Message.Status.NOT_OK);


      verify(db, times(1)).addUser(any(User.class));

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
