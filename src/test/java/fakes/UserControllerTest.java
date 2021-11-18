package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
            // Arrange
            UserController ctrl = new UserController();
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

            // TODO implement test
            // Arrange
            UserController ctrl = new UserController(new FakeUserValidator(false, true));
            User user = new User("Maxi");

            //act
            Message result = ctrl.create(user);

            //Assert
            Assertions.assertEquals(result.status, Message.Status.OK);

        }

        @Test
        void withValidInexistentUsername_returnsNOT_OK__FAKE() {


            // TODO implement test
            // Arrange
            UserController ctrl = new UserController(new FakeUserValidator(true, true));
            User user = new User("Maxi");

            //act
            Message result = ctrl.create(user);

            //Assert
            Assertions.assertEquals(result.status, Message.Status.NOT_OK);

        }

        @Test
        void withValidInexistentUsername_returnsOK__MOCKITO() {
            // TODO implement test
            //Arrange Mockito erstellen
            UserValidator mockitoUv = mock(UserValidator.class);
            UserController ctrl = new UserController(mockitoUv);
            User user = new User("Martin");
            doReturn(false).when(mockitoUv).doesUsernameExist("Martin");
            doReturn(true).when(mockitoUv).isValidUsername("Martin");

            //Act
            Message result = ctrl.create(user);
            //Assert
            Assertions.assertEquals(result.status, Message.Status.OK);

        }

        @Test
        void withValidExistingUsername_returnsNOT_OK__MOCKITO() {
            // TODO implement test
            //Arrange Mockito erstellen (Fake UserValidator mit Mockito)
            UserValidator mockitoUv = mock(UserValidator.class);
            UserController ctrl = new UserController(mockitoUv);
            User user = new User("Martin");
            //Mockito Returnwert setzen
            doReturn(true).when(mockitoUv).doesUsernameExist("Martin");
            doReturn(true).when(mockitoUv).isValidUsername("Martin");

            //Act
            Message result = ctrl.create(user);

            //Assert
            Assertions.assertEquals(result.status, Message.Status.NOT_OK);

        }

        @Test
        void withValidInexistentUsername_shouldAddUserToDB__FAKE() {
            // Der Test soll prüfen, ob der Benutzer tatsächlich der DB hinzugefügt wurde.
            // Dazu soll ein Mock-Objekt für die Database Klasse verwendet werden.

            // TODO implement test
            // Tipp: Wie kann dein Test feststellen, ob der UserController der Datenbank einen Benutzer hinzugefügt hat?
            //   Welche Art von Fake (Stub oder Mock) kann dir weiterhelfen?
            // Arrange MockDatabase erstellt extends Database
            MockDatabase mockDb = new MockDatabase();
            UserValidator fakeUv = new FakeUserValidator(false, true);
            UserController ctrl = new UserController(mockDb, fakeUv);
            User user = new User("Peter");

            //Act
            ctrl.create(user);
            boolean userInDB;
            userInDB = mockDb.getUsers().contains(user);

            //Assert
            Assertions.assertTrue(userInDB);



        }
        @Test
        void withInValidInexistentUsername_shouldNOT_AddUserToDB__FAKE() {
            // Der Test soll prüfen, ob der Benutzer tatsächlich der DB hinzugefügt wurde.
            // Dazu soll ein Mock-Objekt für die Database Klasse verwendet werden.

            // TODO implement test
            // Tipp: Wie kann dein Test feststellen, ob der UserController der Datenbank einen Benutzer hinzugefügt hat?
            //   Welche Art von Fake (Stub oder Mock) kann dir weiterhelfen?
            // Arrange MockDatabase erstellt extends Database
            MockDatabase mockDb = new MockDatabase();
            UserValidator fakeUv = new FakeUserValidator(false, false);
            UserController ctrl = new UserController(mockDb, fakeUv);
            User user = new User("Urs");
            //Act
            ctrl.create(user);

            //Assert
            // Prüft ob List<User> leer ist

            Assertions.assertTrue(mockDb.getUsers().isEmpty());

        }

        @Test
        void withValidInexistentUsername_shouldAddUserToDB__MOCKITO() {
            // Der Test soll prüfen, ob der Benutzer tatsächlich der DB hinzugefügt wurde.
            // Dazu soll ein Mock-Objekt für die Database Klasse verwendet werden.

            // Tipp: Du kannst prüfen, ob der User hinzugefügt wurde,
            //  indem du prüfst wie of die Methode Database.addUser aufgerufen wurde.
            // TODO implement test
            //Arrange
            Database mockitoDb = mock(FileDatabase.class);
            UserValidator mockitoUv = mock(UserValidator.class);
            UserController ctrl = new UserController(mockitoDb, mockitoUv);
            //Wenn methoden isValidUsername && doesUsernameExist.thenReturn (Boolean wert)
            when(mockitoUv.isValidUsername(anyString())).thenReturn(true);
            when(mockitoUv.doesUsernameExist(anyString())).thenReturn(false);
            User user = new User("Hampi");

            //act
            ctrl.create(user);

            //assert
            verify(mockitoDb, times(1)).addUser(user);

        }
        @Test
        void withInValidInexistentUsername_shouldNOT_AddUserToDB__MOCKITO() {
            // Der Test soll prüfen, ob der Benutzer tatsächlich der DB hinzugefügt wurde.
            // Dazu soll ein Mock-Objekt für die Database Klasse verwendet werden.

            // Tipp: Du kannst prüfen, ob der User hinzugefügt wurde,
            //  indem du prüfst wie of die Methode Database.addUser aufgerufen wurde.
            // TODO implement test
            //Arrange
            Database mockitoDb = mock(Database.class);
            UserValidator mockitoUv = mock(UserValidator.class);
            UserController ctrl = new UserController(mockitoDb, mockitoUv);
            //Wenn methoden isValidUsername && doesUsernameExist.thenReturn (Boolean wert)
            when(mockitoUv.isValidUsername(anyString())).thenReturn(true);
            when(mockitoUv.doesUsernameExist(anyString())).thenReturn(true);
            User user = new User("Hampi");

            //act
            ctrl.create(user);

            //assert
            verify(mockitoDb, times(0)).addUser(user);


        }


        // --- Testing Exceptions ---

        @Test
        void withNullUser_throwsIllegalArgumentExc__TRY_CATCH() {
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
        void withNullUser_throwsIllegalArgumentException__THROWN() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                UserController ctrl = new UserController();
                ctrl.create(null);
            });
        }

        @Test
        void withNullUser_throwsIllegalArgumentExceptionWithMessage__THROWN_MESSAGE() {
            Exception thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                UserController ctrl = new UserController();
                ctrl.create(null);
            });
            Assertions.assertTrue(thrown.getMessage().contains("required"));
        }
    }
}
