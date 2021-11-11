package fakes;

public class UserController {

    private Database database;
    private UserValidator userValidator;

    public UserController(UserValidator userValidator) {

        this.userValidator = userValidator;
    }
    public UserController(UserValidator userValidator, Database database) {

        this.userValidator = userValidator;
        this.database = database;
    }


    public Message create(User user){
        if(user == null){
            throw new IllegalArgumentException("user required");
        }
        Boolean canCreate = this.userValidator.isValidUsername(user.getUsername())
                            && !this.userValidator.doesUsernameExist(user.getUsername());
        if(canCreate){
            database.addUser(user);
            return Message.createOK();
        }else{
            return Message.createNotOK();
        }
    }
}
