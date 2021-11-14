package fakes;

public class UserController {

    private final Database db;
    private final UserValidator uv;

    public UserController(UserValidator uv, Database db) {
        this.uv = uv;
        this.db = db;
    }

    public Message create(User user){
        if(user == null){
            throw new IllegalArgumentException("user required");
        }
        Boolean canCreate = this.uv.isValidUsername(user.getUsername())
                            && !this.uv.doesUsernameExist(user.getUsername());
        if(canCreate){
            this.db.addUser(user);
            return Message.createOK();
        }else{
            return Message.createNotOK();
        }
    }
}
