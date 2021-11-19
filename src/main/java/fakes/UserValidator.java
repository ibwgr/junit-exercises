package fakes;

import java.util.regex.Pattern;

public class UserValidator {

    private  static Database db = FileDatabase.getInstance();//static löschen

    //konstruktor für fake
    public UserValidator(Database da){
        this.db = db;
    }
    //default konstruktor
    public UserValidator(){}

    // MockDatabase database;              //mockdatabase versuch eigener test..., schule bei usercontroller
    //fakeUservalidator hat gleiche methode, mit override
    public  boolean doesUsernameExist(String username) {          //static wird im Untericht gelöscht, dann hier auch static löschen
//        try {
//            Thread.sleep(2000);//5000
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        int zaehler = 0;
        for (User user : db.getUsers()) {       //Mock aus db wird database
  //          zaehler++;
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
    //    System.out.println("Zaehler von doesUserNameExist: "+zaehler);
        return false;
    }


    public static boolean isValidUsername(String username) {        //static im Unterricht gelöscht, wegen FakeUserValidator
        //wenn nur buchstabe true                                   // methode für Tests verändert
        //falsch wenn startet mit nummer
        //wenn zahl aber nicht erste
        //falsch wenn Sonderzeichen
        boolean booleanIVU = false;
        String str = username;
        //System.out.println("str Methode: " + str);

        if (str.length() == 0) {
            booleanIVU = false;
            //System.out.println("leer");
        } else if (str.length() == 1 && Pattern.matches("[a-zA-Z]+", str)) {//ifOnlyLetters
            booleanIVU = true;
            //System.out.println("1 ");
        } else if (str.length() == 2 && (Pattern.matches("[a-zA-Z]+", str.substring(0, 1))) && Pattern.matches("[a-zA-Z0-9 ]+", str.substring(1, 2))) {//&&str.substring(1, 2).equals("a")) {//Pattern.matches("[a-zA-Z0-9 ]+", str)
            booleanIVU = true;
            //System.out.println("2 ");
        } else if (str.length() > 2 && (Pattern.matches("[a-zA-Z]+", str.substring(0, 1))) && Pattern.matches("[a-zA-Z0-9 ]+", str.substring(1, str.length()))) {
            booleanIVU = true;
            //System.out.println("3 ");
        }

        return booleanIVU;
    }

}
