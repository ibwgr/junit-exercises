package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.mockito.Matchers.any;
import static org.mockito.junit.MockitoJUnit.*;
//import static org.mockito.*;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner.*;
import org.mockito.junit.*;

class UserValidatorTest {//methode die zu testen ist von der klasse

    /**
     * Alle Tests in der folgenden Klasse isValidUsername sollen die Methode UserValidator.isValidUsername testen.
     * Damit alle Tests grün werden, musst du die Implementation von UserValidator.isValidUsername anpassen!
     */
    @Nested//zum testen von der klasse uservalidator, also diese klasse ist sut//bsp ohne fake
    class isValidUsername {

        @Test
        void returnsTrueIfOnlyLetters() {
            // TODO Testcode anpassen, damit er das testet was der Testname sagt.
            //Assertions.assertTrue(new UserValidator().isValidUsername(null));
            //Assertions.assertTrue(new UserValidator().isValidUsername("null"));//dann gut, obwohl das b methode noch leer ist
            UserValidator validator = new UserValidator();                  //Stub
            Assertions.assertTrue(validator.isValidUsername("Heidi"),"returnsTrueIfOnlyLetters");
            //throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsFalseIfStartsWithNumber(){
            // TODO implement test
            UserValidator validator = new UserValidator();                  //Stub
            //Assertions.assertFalse(new UserValidator().isValidUsername("5haxxorr"));
            Assertions.assertFalse(validator.isValidUsername("3Heidi"),"returnsFalseIfStartsWithNumber");
            //throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsTrueIfContainsNumberButNotAsFirstChar() {
            // TODO implement test
            UserValidator validator = new UserValidator();                  //Stub
            Assertions.assertTrue(validator.isValidUsername("H8eidi"),"returnsTrueIfContainsNumberButNotAsFirstChar");
            //throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar() {
            // TODO implement test
            UserValidator validator = new UserValidator();                  //Stub
            Assertions.assertFalse(false,"Hei!@#&()–[{}]:;'`,?/*~$^+=<>“di");
            //throw new IllegalArgumentException("you should implement code here");
        }
    }
//zb noch test, wenn null ist
    /**
     * Alle Tests in der folgenden Klasse doesUsernameExist sollen die Methode UserValidator.doesUsernameExist testen.
     * Damit alle Tests grün werden, musst du die Implementation von UserValidator.doesUsernameExist anpassen!
     */
    static class doesUsernameExist {
        @Test
        void returnsFalseIfUsernameNotInDBYet__FAKE() {//testen mit fake klasse
            // TODO implementiere / ergänze den Test hier, so dass dieser kompiliert und grün ist.
            //falls user noch nicht in db ist
            //abhänigkeit in methode: ist der db
            //sowas muss mann faken oder mock oder stub
            //abhängigkeit faken, nicht uservalidatorfake
            //2. db, konstruktor und default konstruktor
            Database db = new FakeDatabase();//fakedatabase erstellen
             final UserValidator uv = new UserValidator(db); //1.3. fakedb übergeben
            //2. neuer konstruktor machen, um die db zu übergeben
            boolean usernameExist = uv.doesUsernameExist("peter"); //weil noch kein peter, darum gut
            Assertions.assertFalse(usernameExist);



//            //return falsch, wenn name noch nicht in db ist
//            //retur falsch, wenn name schon in db ist -->
//            //UserValidator uv = new UserValidator();
//
//            boolean usernameExist = uv.doesUsernameExist("eter");//eter statt peter geht auch//für lesbarkeit schreibt mann boolean result, assert result
//            System.out.println("Boolean usernameExist: "+usernameExist);
//            Assertions.assertFalse(usernameExist);
            //muss Assertion.assertFalse sein
        }


        @Test
        void returnsFalseIfUsernameNotInDBYet__MOCKITO() {
            // TODO implement test
            //wird hier den die "Mock- Datenbank" gemeint? welche erst erstellt werden muss und dann ev. gefüllt werden muss?
            // weil sonst müsste doch import mokito irgendwas sein nicht?

            //vorteil nicht mehr selber klassen machen, sondern generieren lassen
            Database db = Mockito.mock(Database.class);// erstellen mit mokito, also eingeben mockitopunktmock
            //Mockito.doReturn()...
            final UserValidator uv = new UserValidator(db);
  //doReturn..
            boolean usernameExist = uv.doesUsernameExist("peter");
            Assertions.assertFalse(usernameExist);


            //muss Assertion.assertFalse sein
        }

        @Test
        void returnsTrueIfUsernameInDB__FAKE() {
            // TODO implementiere / ergänze den Test hier, so dass dieser kompiliert und grün ist.

//            UserValidator uv = new UserValidator();
//
//             boolean usernameExist = uv.doesUsernameExist("peter");//peter//kalua//Peter kleingeschrieben im original!
//            System.out.println("Boolean usernameExist: "+usernameExist);//ist falsch
//
//           // usernameExist = true;  ......................dann wäre grün................
//             Assertions.assertTrue(usernameExist);
//
//            //muss Assertion.assertTrue sein
            FakeUserValidator fuv1 = new FakeUserValidator();
            System.out.println("fuv1.doesUsernameExist von override: "+fuv1.doesUsernameExist("peter"));//wenn kalua, dann true
            boolean usernameExist = fuv1.doesUsernameExist("kalua");//true
            Assertions.assertTrue(usernameExist, "in FakeUserValidator bei OverrideMethode, also dann auch in der richtigen Methode? testen nur true oder DB?");
        }

        @Test
        void returnsTrueIfUsernameInDB__MOCKITO() {
            // TODO implement test

            //muss Assertion.assertTrue sein
        }

        @Test
        void returnsTrueIfSameNameInDBButWithDifferentLetterCasing() {
            // TODO implement test


            //muss Assertion.assertTrue sein
        }
    }
}
