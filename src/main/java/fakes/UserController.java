package fakes;

public class UserController {

    private UserValidator userValidator;
    private FileDatabase db;

    public UserController(UserValidator userValidator){
        this.userValidator = userValidator;
        this.db = new FileDatabase();
    }

    public UserController (UserValidator userValidator, FileDatabase fileDatabase){
        this.userValidator = userValidator;
        this.db = fileDatabase;
    }



    public Message create(User user){
        if(user == null){
            throw new IllegalArgumentException("user required");
        }
        Boolean canCreate = this.userValidator.isValidUsername(user.getUsername())
                            && !this.userValidator.doesUsernameExist(user.getUsername());
        if(canCreate){
            db.addUser(user);
            return Message.createOK();
        }else{
            return Message.createNotOK();
        }
    }
}
