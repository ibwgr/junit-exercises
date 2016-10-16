package fakes;

public class UserController {

    public Message create(User user){
        if(user == null){
            throw new NullPointerException("User required");
        }
        if(UserValidator.isValidUsername(user.getUsername())){
            System.out.println("Erstelle User ...");
            return Message.createOK();
        }else{
            System.out.println("User konnte nicht erstellt werden!");
            return Message.createNotOK();
        }
    }
}
