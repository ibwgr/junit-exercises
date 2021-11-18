package fakes;

/**
 * @author - John Schmidt
 * 08.11.2021, 00:41
 */
public class UMain {
    public static void main (String[] args){

        User u1 = new User("Hansi");


        UserValidator uv1 = new UserValidator();
        uv1.doesUsernameExist("peter");
        //System.out.println("abcd "+UserValidator.isValidUsername("m9mk"));


    }

}
