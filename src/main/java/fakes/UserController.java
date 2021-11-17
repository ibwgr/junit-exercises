package fakes;

import java.util.List;

public class UserController {



    private Database db = FileDatabase.getInstance();


    private UserValidator userValidator = new UserValidator();

    public UserController(){}

    //übergabe von erzeugtem FakeUserValidator (Constructor injection)
    public UserController(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    public UserController(Database db, UserValidator userValidator) {
        this.db = db;
        this.userValidator = userValidator;
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
