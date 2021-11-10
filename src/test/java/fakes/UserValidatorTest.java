package fakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.mockito.Mockito.mock;

class UserValidatorTest {

    @Nested
    class isValidUsername{

        @Test
        void returnsTrueIfOnlyLetters(){
            //kein mokito
            User u2 = new User("Bob");      //Lösung internet
            String str = u2.getUsername();
            for (int i = 1; i <= str.length() - 1; i++) {
                if ((Pattern.matches("[a-zA-Z]+", str))) {//str.substring(i,i+1).equals
                    // Do something
                    //System.out.println("Nope, Other characters detected");
                    Assertions.assertTrue(true, "Yes, string contains letters only");

                } else {
                    Assertions.assertTrue(false, "Nope, Other characters detected");
                    //System.out.println("Yes, string contains letters only");

                }

            }

            //throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsFalseIfStartsWithNumber(){
            //kein Mokito
            User u1 = new User("Maxi");
            String str = u1.getUsername();
            System.out.println("Str: " + str);
            // for(int i = 0;i<=9;i++) {
            //if (str.substring(0,1)==str.charAt(i)){//str.startsWith(i)) {
            //str.startsWith(str.charAt(i))
            if (str.startsWith("0") || str.startsWith("1") || str.startsWith("2") || str.startsWith("3")
                    || str.startsWith("4") || str.startsWith("5") || str.startsWith("6") || str.startsWith("7")
                    || str.startsWith("8") || str.startsWith("9")) {
                //System.out.println("hat 0");
                Assertions.assertTrue(false, "hat eine Nummer am Anfang");
            } else {
                //System.out.println("hat keine 0");
                Assertions.assertTrue(true, "hat keine Nummer am Anfang");
            }
            // throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsTrueIfContainsNumberButNotAsFirstChar(){
            //Kein Mokito
            User u1 = new User("Maxli");
            String str = u1.getUsername();
            for (int i = 1; i <= str.length() - 1; i++) {

                if (str.substring(i, i + 1).equals("0") || str.substring(i, i + 1).equals("1") || str.substring(i, i + 1).equals("2")
                        || str.substring(i, i + 1).equals("3") || str.substring(i, i + 1).equals("4") || str.substring(i, i + 1).equals("5") ||
                        str.substring(i, i + 1).equals("6") || str.substring(i, i + 1).equals("7") || str.substring(i, i + 1).equals("8")
                        || str.substring(i, i + 1).equals("9")) {
                    Assertions.assertTrue(false, "Hat Nummer");
                } else {
                    Assertions.assertTrue(true, "hat keine Nummer");
                }
            }
            //throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsFalseIfContainsAnyNonAlphanumericChar(){
            //Kein Mokito
            User u1 = new User("Ursula");//""U@RS@@@@@rs@/");//Urs123//Urs*//Urs$
            String str = u1.getUsername();

            //! @ # & ( ) – [ { } ] : ; ', ? / *
            //` ~ $ ^ + = < > “
            String falsch = "! @ # & ( ) – [ { } ] : ; ', ? / *` ~ $ ^ + = < > “";//"Ur!@#$%";//"Ursula";//"! @ # & ( ) – [ { } ] : ; ', ? / *` ~ $ ^ + = < > “";
            System.out.println(falsch);

            //str.substring(i).equals()

            for(int i = 0; i<str.length();i++){
                for(int j = 0; j<falsch.length();j++)
                    if (str.charAt(i)==falsch.charAt(j)){
                        System.out.print("ist gleich");
                        System.out.print("i: "+str.charAt(i));
                        System.out.print("j: "+falsch.charAt(j));
                        Assertions.assertTrue(false, "ist nicht gut");
                        break;
                    }else{
                        //System.out.print("n");
                        //System.out.print("ist nicht gleich");
                        Assertions.assertTrue(true, "ist gut");
                    }
            }

//            String str1 = "!@#$%";
//
//            if (str1.matches("^[^a-zA-Z0-9]+$")) {
//                System.out.println("Yes, true.");
//            } else {
//                System.out.println("failed!");
//            }



//            for(int i = 0; i<str.length();i++){
//                // System.out.println(str.charAt(i));
//                //System.out.println(str.substring(str.charAt(i)));
//                for (int j = 0; j < falsch.length(); j++){
//                    //System.out.println(str.charAt(i));
//                    if(str.charAt(i)==falsch.charAt(j)){
//                        System.out.println("Ist gleich: " +str.charAt(i)+" "+falsch.charAt(j) );
//                        Assertions.assertTrue(false, "ist nicht gut");
//                        break;
//                    }else{
//                        System.out.println("ist nicht soo");
//                        Assertions.assertTrue(true, "ist gut");
//
//                        break;
//                    }
//                }
//            }

//            str = str.replaceAll(
//                    "[^a-zA-Z0-9]", "");
//            if (str.matches("^[^a-zA-Z0-9]+$")) {
//                System.out.println("Yes, true.");
//            } else {
//                System.out.println("failed!");
////            }
//            for (int i = 0; i < str.length(); i++) {
//                for (int j = 0; j <= falsch.length(); j++) {
//                    //if (str.substring(i, i - 1) == falsch.substring(j, j - 1)) {
//                    if(str.charAt(i)==falsch.charAt(j))
//                        System.out.println(str.charAt(i) + falsch.charAt(j));
//                    }
//                    else {
//                        System.out.println("ist nicht gleich");
//                    }
//                }
//            }
//                    //if(str.substring(i,i-1)==falsch.substring(j,j-1)){
//                    //if (str.equals(falsch.charAt(i))){
//                    if (str.charAt(i) == falsch.charAt(j)) {
////
////    if (str.substring(str.charAt(i)) == falsch.substring(falsch.charAt(j))) {
//                        System.out.println("falsch");
//                        System.out.println(str.charAt(i)+" "+falsch.charAt(j));
//                        break;
//                    } else {
//                        System.out.println("richtig");
//                       // System.out.println(str.charAt(i));
//                    }
//                }
//
//            }
            //if(str.substring(str.charAt(i)) = falsch.substring(falsch.charAt(i)))
            //if()
            //if (str.matches("[^a-zA-Z0-9]")){       //!            waas?
            //if (!str.matches("^[^a-zA-Z0-9]+$")) {             //!
//                System.out.println("ist gut");
//                Assertions.assertTrue(true, "nur Zahlen und Buchstraben");
//            }
//            else{
//
//                System.out.println("ist nicht gut FU+*ç%&/k");
//                Assertions.assertTrue(false, "ist nicht gut FU+*ç%&/k");
//
//            }
//            if((str >= 'a' && str <= 'z') || (str >= 'A' && str <= 'Z') || (str >= '0' && str <= '9')){
//
//            }
//            public static boolean isAlphaNumeric(char char1) {
//                return (char1 >= 'a' && char1 <= 'z') || (char1 >= 'A' && char1 <= 'Z') || (char1 >= '0' && char1 <= '9');
//            }

            // throw new IllegalArgumentException("you should implement code here");
        }

    }


    static class doesUsernameExist{

        @Test
        void returnsFalseIfUsernameNotInDBYet(){            //mokito testen validaor, nicht controller
            Database mockDatabase = mock(Database.class);   //gibt keine klasse rechts, zum teseten
            mockDatabase.addUser(new User("Hand")); //zum testen
            System.out.println(mockDatabase.getUsers());

            final UserValidator uv = new UserValidator();

            final boolean usernameExist = uv.doesUsernameExist("Peter");

            Assertions.assertFalse(usernameExist);

            //throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsTrueIfUsernameInDB(){   //Test ist immer grün, auch wenn irgend welcher Code gelöscht wird...??????????????????????????

            Database mockDatabase = mock(Database.class);   //gibt keine $klasse rechts, zum teseten
            mockDatabase.addUser(new User("Hand")); //zum testen
            System.out.println(mockDatabase.getUsers());

            final User peter = new User("Peter");
            final User peter1 = new User("Peter");
//
            List users = new ArrayList<>();
            users.add(peter);
            users.add(peter1);
//
//            //doReturn
            System.out.println("Helloooo");
            System.out.println(mockDatabase.getUsers());
            //weil adduser ist void, kann man nicht adden
            //aber mit doReturn

            final UserValidator uv = new UserValidator();

            final boolean usernameExist = uv.doesUsernameExist("Peter");

            Assertions.assertFalse(usernameExist);
//            Assertions.assertTrue(usernameExist);                             //probieren, dann rot endlich
//            throw new IllegalArgumentException("you should implement code here");
        }

        @Test
        void returnsTrueIfSameNameInDBButWithDifferentLetterCasing(){
            Database mockDatabase = mock(Database.class);   //gibt keine $klasse rechts, zum teseten
            mockDatabase.addUser(new User("Neu")); //zum testen
            System.out.println(mockDatabase.getUsers());

            User us1 = new User("SEPP");

//            List arrlist = new ArrayList<>();
//            arrlist.add(us1);


            System.out.println("ausgeben Liste:");
//            for ( User : arrlist.size()) {
//                System.out.println(us1.getUsername()); // Name der Personen ausgeben
//            }
//            for(int i = 0; i<arrlist.size();i++){
//                System.out.println(arrlist.);
//            }
            List<User> liste = new ArrayList<User>();
            liste.add(new User("Max"));
            liste.add(new User("Dieter"));
            liste.add(new User("MAx"));
            liste.add(new User("DiEter"));
            liste.add(us1);

            for (User us : liste) {
                System.out.println(us.getUsername()); // Name der Personen ausgeben
            }
            System.out.println(mockDatabase.getUsers());
//*****************************************************************************************************************************
            //wenn in liste gleicher name, aber anderst geschrieben...also darf nicht genau doppelt sein

            for(int i = 0; i<liste.size();i++){
                for (int j  = 0; j< us1.getUsername();j++){
                    if(liste.get(i)==liste.get(j)){
                        System.out.println("ist gleich");
                    }else{
                        System.out.println("ist nicht gleich");
                    }
                }
            }
//Objekte vergleicht man mit equals... String auch.....

            String str = "Ursula";
            String str2 = "UDDDrsulaUrs";

            for(int i = 0; i<str.length();i++){
                // System.out.println(str.charAt(i));
                //System.out.println(str.substring(str.charAt(i)));
                for (int j = 0; j < str2.length(); j++){
                    //System.out.println(str.charAt(i));
                    if(str.charAt(i)==str2.charAt(j)){
                        System.out.println("Ist gleich: " +str.charAt(i)+" "+str2.charAt(j) );

                    }else{
                        System.out.println("ist nicht soo");
                        break;
                    }
                }
            }






            //Assertions.assertFalse(false, "falsch");
            //Assertions.assertTrue(true,"gut");
            //mit Mokito
            //throw new IllegalArgumentException("you should implement code here");
        }
    }
}

