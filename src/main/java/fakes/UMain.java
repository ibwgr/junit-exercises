package fakes;

/**
 * @author - John Schmidt
 * 08.11.2021, 00:41
 */
public class UMain {
    public static void main (String[] args){

        User u1 = new User("Hansi");
        User u2 = new User("Hansü");

        //System.out.println(List);

        // Database

        System.out.println(u1.getUsername());
        System.out.println(u2.getUsername());

        UserValidator uv = new UserValidator();
        System.out.println("Hansi?? "+uv.doesUsernameExist("Hansi"));
        System.out.println("Peter?? "+uv.doesUsernameExist("Peter"));
        System.out.println("Hand?? "+uv.doesUsernameExist("Hand"));
        System.out.println("kalua in Datenbank Übersee?? "+uv.doesUsernameExist("kalua"));

        System.out.println(FileDatabase.getInstance());

//        UserValidator.doesUsernameExist(u2.getUsername());
//        UserValidator.doesUsernameExist("Peter");
//
//        UserValidator.doesUsernameExist(u2.getUsername());



        FileDatabase.getInstance();
        //FileDatabase.getUsers();


    }

}
