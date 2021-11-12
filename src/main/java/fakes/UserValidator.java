package fakes;

import java.util.regex.Pattern;

public class UserValidator {

    private static Database db = FileDatabase.getInstance();

    public boolean doesUsernameExist(String username) {      //static wird im Untericht gelöscht
        try {
            Thread.sleep(5000);//2000
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (User user : db.getUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidUsername(String username) {        //static im Unterricht gelöscht, wegen FakeUserValidator
        //wenn nur buchstabe true                           // methode für Tests verändert
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
        }
        else if (str.length() ==2 && (Pattern.matches("[a-zA-Z]+",str.substring(0,1))) && Pattern.matches("[a-zA-Z0-9 ]+", str.substring(1,2) )){//&&str.substring(1, 2).equals("a")) {//Pattern.matches("[a-zA-Z0-9 ]+", str)
            booleanIVU = true;
            //System.out.println("2 ");
        }
        else if (str.length() >2 && (Pattern.matches("[a-zA-Z]+",str.substring(0,1))) && Pattern.matches("[a-zA-Z0-9 ]+", str.substring(1,str.length()) )) {
            booleanIVU = true;
            //System.out.println("3 ");
        }

        return booleanIVU;
    }

}
