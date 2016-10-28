package fakes;

public class UserController {

    private Database db = FileDatabase.getInstance();
    private UserValidator userValidator = new UserValidator();

    public UserController() {

    }

    public UserController(Database db, UserValidator userValidator) {
        this.db = db;
        this.userValidator = userValidator;
    }

    public UserController(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    public Message create(User user){
        if(user == null){
            throw new IllegalArgumentException("user required");
        }
        Boolean canCreate = userValidator.isValidUsername(user.getUsername())
                            && !userValidator.doesUsernameExist(user.getUsername());
        if(canCreate){
            db.addUser(user);
            return Message.createOK();
        }else{
            return Message.createNotOK();
        }
    }
}
