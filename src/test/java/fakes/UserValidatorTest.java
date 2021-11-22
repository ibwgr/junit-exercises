package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.mockito.Matchers.any;
import static org.mockito.junit.MockitoJUnit.*;
//import static org.mockito.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner.*;
import org.mockito.junit.*;

import java.util.*;

class UserValidatorTest {//methode die zu testen ist von der klasse

    /**
     * Alle Tests in der folgenden Klasse isValidUsername sollen die Methode UserValidator.isValidUsername testen.
     * Damit alle Tests grün werden, musst du die Implementation von UserValidator.isValidUsername anpassen!
     */
    @Nested//block von test cases
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


        @Test//falls user noch nicht in db ist// (expected = IndexOutOfBoundsException.class)
        void returnsFalseIfUsernameNotInDBYet__MOCKITO() {
            // TODO implement test

            //vorteil nicht mehr selber klassen machen, sondern generieren lassen
            Database mokitoDb = Mockito.mock(Database.class);// erstellen mit mokito, also eingeben mockitopunktmock (punktnotation)
                                //static import denn nur mock.(Database.class)   //von der Database-Klasse
            //Database mokitoDb = mock(Database.class);
           // Mockito.doReturn(Collections.emptyList()).when(db).getUsers();
            //Mockito.doReturn()...
            final UserValidator uv = new UserValidator(mokitoDb);//uservalidator soll Mokitodatenbank nutzen  //ev am schluss final machern
            System.out.println("wer schon in MokitoDB drin?: "+mokitoDb.getUsers());

            User u1 = new User("Anton"); //User erstellen
            User u2 = new User("Antonella"); //User erstellen
            User u3 = new User("abcde"); //User erstellen
            User u4 = new User("xyz");
            System.out.println("u1 name: "+u1.getUsername());   //name ausgeben
            System.out.println("u2 name: "+u2.getUsername());
            System.out.println("u3 name: "+u3.getUsername());
            System.out.println("u43 name: "+u4.getUsername());
            mokitoDb.addUser(u1);                     //Mokitodb user hinzufügen
            mokitoDb.addUser(u2);                     //Mokitodb user hinzufügen
            mokitoDb.addUser(u3);
            mokitoDb.addUser(u4);

           // Arrays.asList(u4);
            System.out.println("?Arrays.asList?"+Arrays.asList(u4.getUsername()));
            System.out.println("?Arrays.asList?"+Arrays.asList(mokitoDb));


    //----------------ist void-der addUser von Database------------------------
            Mockito.when(mokitoDb.addUser(new User("Ueli"))).thenReturn(uv.doesUsernameExist("Ueli"));

          //  System.out.println("?Arrays.asList?"+mokitoDb.addUser(Arrays.asList(u4)));
           //System.out.println("dddd "+Mockito.doReturn(Arrays.asList(u1)))
    //        System.out.println("dddd "+mokitoDb.addUser(Mockito.doReturn(Arrays.asList(u1))) );
    //        System.out.println("dddd "+mokitoDb.addUser(Arrays.asList(u1)) );
 //           System.out.println("uu "+ Mockito.doReturn(Collections.emptyList()).when(mokitoDb).getUsers()  );


            //System.out.println("wwww "+Mockito.when(uv.doesUsernameExist("Hansoloo")).thenReturn(false));
         //   System.out.println("wwww "+Mockito.when(uv..doesUsernameExist("Hansoloo")).thenReturn(false));
            //     boolean antonboolean = uv.doesUsernameExist("Anton");
            //        System.out.println("antonboolean "+antonboolean);

//            User user = new User("Martin");
//            //Mockito Returnwert setzen
//            Mockito.doReturn(true).when(uv).doesUsernameExist("Martin");
//            boolean Martinboolean = uv.doesUsernameExist("Martin");
//            System.out.println("Martinboolean "+Martinboolean);

            System.out.println("mokitoDb.getUsers"+mokitoDb.getUsers());//ist leer
            //System.out.println(Mockito.spy(db.getUsers()));spy.get(0)
            //System.out.println("eee"+Mockito.RETURNS_MOCKS);
           // System.out.println(Mockito.when(.size()).thenReturn(10));
       //     Mockito.when(mokitoDb.addUser(new User("Ueli"))).thenReturn(true);
           // Mockito.when(uv.doesUsernameExist("sssssssn")).thenReturn(true);
         //   System.out.println("????????????? "+Mockito.when(uv.doesUsernameExist("sss")).thenReturn(true));
       //     System.out.println("????????????? "+Mockito.when(mokitoDb.addUser(new User(""))).thenReturn(true));
           // System.out.println("????????????? "+Mockito.when(mokitoDb.addUser(new User())).thenReturn());
    //        when(mokitoDb.get(0)).thenReturn("first");
//            System.out.println(Mockito.doReturn(Arrays.asList(new User("peter"))).when(mokitoDb).getUsers());//github
//            System.out.println(Mockito.doReturn(Arrays.asList(u1)).when(mokitoDb).getUsers());
//            System.out.println(Mockito.doReturn(Arrays.asList(u1)).when(mokitoDb).getUsers());// );
            int x = 1;
           // System.out.println(Mockito.doReturn(Arrays.asList(u1)).when(x=1));
            System.out.println("dddd "+Mockito.doReturn(Arrays.asList(u1)));
    //        boolean w =Mockito.doReturn(Arrays.asList(new User("peter"))).when(mokitoDb).getUsers();
            System.out.println();
            //  System.out.println("??? "+Mockito.when(mokitoDb.get(0)).thenReturn("first"));
           // System.out.println("??"+Mockito.when(mokitoDb.getUsers()).thenReturn(true));
            //System.out.println("spy: "+Mockito.spy(0));//geht nicht stürtzt ab
            //System.out.println(mokitoDb.getUsers().);

//            List list = new LinkedList();
//           // List spy = spy(list);
//
//            //optionally, you can stub out some methods:
//            //when(spy.size()).thenReturn(100);
//
//            //using the spy calls *real* methods
//            spy.add("one");
//            spy.add("two");
//
//            //prints "one" - the first element of a list
//            System.out.println(spy.get(0));
//
//            //size() method was stubbed - 100 is printed
//            System.out.println(spy.size());



            //Mockito.doReturn(true).when(uv.doesUsernameExist("ich bin der erste Name in DB"));
//Mockito.mock(uv.doesUsernameExist(),"ddxdcc");

            //System.out.println(FakeDatabase.);

//            User u1 = new User("qqqq1"); //User erstellen
//            User u2 = new User("qqqq2"); //User erstellen
//            System.out.println("u1 name: "+u1.getUsername());   //name ausgeben
//            System.out.println("u2 name: "+u2.getUsername());
//            db.addUser(u1);                     //Mokitodb user hinzufügen
//            db.addUser(u2);
//            System.out.println("db.getUsers"+db.getUsers());

           // for(int i = 0; i<db)
            //System.out.println(db.getUsers(u1.getUsername()));
            //System.out.println(db.);
            //System.out.println(db.length);
            //System.out.println(Mockito.doReturn(uv.doesUsernameExist("d")));
            //System.out.println(Mockito.description(db.getUsers()));
//            System.out.println(db.getUsers());//leer
//            System.out.println(Mockito.doReturn(db.getUsers()));    //retour hash
//            System.out.println(Mockito.doReturn(db));               //retour hash
//
//            System.out.println(Mockito.doReturn(db.toString()));//geht nicht
//            System.out.println(Mockito.spy(db));//Mock for Database, hashCode: 7829163
//            System.out.println(Mockito.spy(db.getUsers()));
            //System.out.println(Mockito.atLeastOnce().toString());
            //System.out.println(Mockito.);
           // boolean MokitoBollean = Mockito.when(uv.doesUsernameExist("ww")).thenReturn(true);
  //doReturn..
           // Mockito.when(uv.doesUsernameExist("sssssssn")).thenReturn(true);
           // Mockito.doReturn("MaxMusterli");

           // boolean usernameExist = uv.doesUsernameExist("sssssssn");
           // System.out.println("usernameExist22: "+usernameExist);
           // Assertions.assertFalse(usernameExist);


            //muss Assertion.assertFalse sein
        }

        @Test
        void returnsTrueIfUsernameInDB__FAKE() {//-------------------------------------------------Fertig-----------------
            // TODO implementiere / ergänze den Test hier, so dass dieser kompiliert und grün ist.

            Database fakedb = new FakeDatabase();
            //fakedb.addUser(new User("Sepp"));

            UserValidator uv2 = new UserValidator(fakedb);

            System.out.println("wer schon in fakedb drin?: "+fakedb.getUsers());

            User u1 = new User("Sep"); //User erstellen
            User u2 = new User("Toni"); //User erstellen
            System.out.println("u1 name: "+u1.getUsername());   //name ausgeben
            System.out.println("u2 name: "+u2.getUsername());
            fakedb.addUser(u1);                     //Mokdb user hinzufügen
            fakedb.addUser(u2);                     //Mokdb user hinzufügen
            System.out.println("db.getUsers"+fakedb.getUsers());

            System.out.println("db.size "+fakedb.getUsers());

            boolean userNameExistToni = uv2.doesUsernameExist("Toni");
            System.out.println("userNameExistToni in FakeDB? "+userNameExistToni);

            Assertions.assertTrue(userNameExistToni);

        }

        @Test
        void returnsTrueIfUsernameInDB__MOCKITO() {//------------------------------muss noch gemacht werden-----
            // TODO implement test
            Database mokitodb = Mockito.mock(Database.class);
            //mokitodb.addUser(new User("Seppli"));
            UserValidator usv31 = new UserValidator(mokitodb);

            User u1 = new User("qq");
            //Mockito.

            System.out.println("Seppli sollte in Mokitodb drin sein: "+mokitodb.getUsers());
            System.out.println("Seppli sollte in Mokitodb drin sein: "+mokitodb.toString());

            UserValidator usv3 = new UserValidator(mokitodb);
            Boolean usv3ExistSeppki = usv3.doesUsernameExist("Seppki");
            System.out.println("usv3ExistSeppki: "+usv3ExistSeppki);


            Boolean usv3ExistSeppli = usv3.doesUsernameExist("Seppli");
            System.out.println("usv3ExistSeppli: "+usv3ExistSeppli);
            //muss Assertion.assertTrue sein
        }

        @Test
        void returnsTrueIfSameNameInDBButWithDifferentLetterCasing() {//-------------dauert noch ---------------
            // TODO implement test

            Database fakedb = new FakeDatabase();
            //fakedb.addUser(new User("Sepp"));
            UserValidator uv2 = new UserValidator(fakedb);
            System.out.println("wer schon in fakedb drin?: "+fakedb.getUsers());

            User u1 = new User("Monika"); //User erstellen
            User u2 = new User("Veronika"); //User erstellen
            User u3 = new User("Mundharmonika"); //User erstellen
            User u4 = new User("Monika");
            System.out.println("u1 name: "+u1.getUsername());   //name ausgeben
            System.out.println("u2 name: "+u2.getUsername());
            System.out.println("u3 name: "+u3.getUsername());
            System.out.println("u43 name: "+u4.getUsername());
            fakedb.addUser(u1);                     //Mokdb user hinzufügen
            fakedb.addUser(u2);                     //Mokdb user hinzufügen
            fakedb.addUser(u3);
            fakedb.addUser(u4);
            System.out.println("db.getUsers"+fakedb.getUsers());

            //System.out.println("db.size "+fakedb.);
            System.out.println("db.size "+fakedb.getUsers());


            boolean userNameExistMonika = uv2.doesUsernameExist("Monika");
            //int userNameExistMonikaInt = uv2.doesUsernameExist("Monika");
            System.out.println("userNameExistMonika in FakeDB? "+userNameExistMonika);

//
//            Assertions.assertTrue(userNameExistToni);
            //muss Assertion.assertTrue sein
        }
    }
}
