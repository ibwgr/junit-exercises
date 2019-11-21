package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UserControllerTest {

  // Pro getestete Methode gibt es eine inner class (Hier für UserController.create)
  @Nested
  class create {


    /***********************************************************************************************************/
    // --- Testing with Fakes ---
    /***********************************************************************************************************/

    /* This test runs only ant the first time correct, at the second time the user already exists and the result.status is NOT_OK! --> bad test    */
//    @Test
//    void withValidInexistingUsername_returnsOK__NO_FAKE() {
//      UserController ctrl = new UserController(new UserValidator());
//      User user = new User("kalua");
//
//      Message result = ctrl.create(user);
//
//      Assertions.assertEquals(Message.Status.OK, result.status);
//    }

    @Test
    void withValidInexistingUsername_returnsOK__FAKE() {
      UserController ctrl = new UserController(new FakeUserValidator(true, false));
      User user = new User("Goldener Umbertus");

      Message result = ctrl.create(user);

      Assertions.assertEquals(Message.Status.OK, result.status);
    }

    @Test
    void withInvalidInexistingUsername_returnsNOT_OK__FAKE() {
      UserController ctrl = new UserController(new FakeUserValidator(false, false));
      User user = new User("Goldener Umbertus");

      Message result = ctrl.create(user);

      Assertions.assertEquals(Message.Status.NOT_OK, result.status);
    }

    @Test
    void withValidExistingUsername_returnsNOT_OK__FAKE() {
      UserController ctrl = new UserController(new FakeUserValidator(true, true));
      User user = new User("Goldener Umbertus");

      Message result = ctrl.create(user);

      Assertions.assertEquals(Message.Status.NOT_OK, result.status);
    }

    @Test
    void withInvalidExistingUsername_returnsNOT_OK__FAKE() {
      UserController ctrl = new UserController(new FakeUserValidator(false, true));
      User user = new User("Goldener Umbertus");

      Message result = ctrl.create(user);

      Assertions.assertEquals(Message.Status.NOT_OK, result.status);
    }

      @Test
      void withValidInexitingUserName_addsUserToDB__FAKE() {
          User user = new User("Julian");
          FakeFileDatabase fakefileDatabase = new FakeFileDatabase();
          UserController ctrl = new UserController(new FakeUserValidator(true, false), fakefileDatabase);

          ctrl.create(user);
          String usernameDB = fakefileDatabase.getUsers().get(0).getUsername();

          Assertions.assertEquals("Julian", usernameDB);
      }

      /***********************************************************************************************************/
      // --- Testing with mokito framework ---
      /***********************************************************************************************************/
      @Test
    void withValidInexistingUsername_returnsOK__MOCKITO() {
     UserValidator userValidator = Mockito.mock(UserValidator.class);
     doReturn(true).when(userValidator).isValidUsername(anyString());
     doReturn(false).when(userValidator).doesUsernameExist(anyString());
     UserController ctrl = new UserController(userValidator);
     User user = new User("Goldener Umbertus");

     Message result = ctrl.create(user);

     Assertions.assertEquals(Message.Status.OK, result.status);
    }

    @Test
    void withInvalidInexistingUsername_returnsNOT_OK__MOCKITO() {
      UserValidator userValidator = Mockito.mock(UserValidator.class);
      doReturn(false).when(userValidator).isValidUsername(anyString());
      doReturn(false).when(userValidator).doesUsernameExist(anyString());

      UserController ctrl = new UserController(userValidator);
      User user = new User("Goldener Umbertus");

      Message result = ctrl.create(user);

      Assertions.assertEquals(Message.Status.NOT_OK, result.status);
    }


    @Test
    void withValidExistingUsername_returnsNOT_OK__MOCKITO() {
      UserValidator userValidator = Mockito.mock(UserValidator.class);
      doReturn(true).when(userValidator).isValidUsername(anyString());
      doReturn(true).when(userValidator).doesUsernameExist(anyString());

      UserController ctrl = new UserController(userValidator);
      User user = new User("Goldener Umbertus");

      Message result = ctrl.create(user);

      Assertions.assertEquals(Message.Status.NOT_OK, result.status);
    }

    @Test
    void withInvalidExistingUsername_returnsNOT_OK__MOCKITO() {
      UserValidator userValidator = Mockito.mock(UserValidator.class);
      doReturn(false).when(userValidator).isValidUsername(anyString());
      doReturn(true).when(userValidator).doesUsernameExist(anyString());

      UserController ctrl = new UserController(userValidator);
      User user = new User("");

      Message result = ctrl.create(user);

      Assertions.assertEquals(Message.Status.NOT_OK, result.status);
    }



    @Test
    void withValidInexitingUserName_addUserToDB__MOCKITO() {
      UserValidator userValidator = Mockito.mock(UserValidator.class);
      doReturn(true).when(userValidator).isValidUsername(anyString());
      doReturn(false).when(userValidator).doesUsernameExist(anyString());

      FileDatabase fileDatabase =Mockito.mock(FileDatabase.class);

      UserController ctrl = new UserController(userValidator, fileDatabase);
      User user = new User("Du");
      ctrl.create(user);

      Mockito.verify(fileDatabase, times(1)).addUser(any(User.class));

    }

    // --- Testing Exceptions ---

    @Test
    void TRY_CATCH_withNullUser_throwsIllegalArgumentExc() {
      try {
        UserController ctrl = new UserController(new FakeUserValidator(true, false));
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
        UserController ctrl = new UserController(new FakeUserValidator(true, false));
        ctrl.create(null);
      });
    }

    @Test
    void THROWN_MESSAGE_withNullUser_throwsIllegalArgumentExceptionWithMessage() {
      Exception thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        UserController ctrl = new UserController(new FakeUserValidator(true, false));
        ctrl.create(null);
      });
      Assertions.assertTrue(thrown.getMessage().contains("required"));
    }
  }
}
