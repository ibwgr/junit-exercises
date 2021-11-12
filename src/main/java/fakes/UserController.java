package fakes;

public class UserController {
    private UserValidator userValidator;
    private Database db;
   // private static Database db = FileDatabase.getInstance();

    public UserController(UserValidator userValidator, Database database) {
        this.userValidator = userValidator;
        this.db = database;
    }

    public Message create(User user){
        if(user == null){
            throw new IllegalArgumentException("user required");
        }
        Boolean canCreate = this.userValidator.isValidUsername(user.getUsername())
                            && !this.userValidator.doesUsernameExist(user.getUsername());
        if(canCreate){
            this.db.addUser(user);
            return Message.createOK();
        }else{
            return Message.createNotOK();
        }
    }
}
