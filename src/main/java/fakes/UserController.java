package fakes;

public class UserController {

    //private static Database db = FileDatabase.getInstance();
    private UserValidator userValidator;    //fakeuservalidator         //aus Unterricht
    private Database database;              //mockdatabase              //aus Unterricht

    public UserController(UserValidator UserValidator){//inject db.adduser
        userValidator = UserValidator;
    }   //aus Unterricht
    public UserController(UserValidator UserValidator, Database database){//inject db.adduser
        userValidator = UserValidator;
        this.database = database;                               //Mok-database
    }

    public Message create(User user){
        if(user == null){
            throw new IllegalArgumentException("user required");
        }
        Boolean canCreate = this.userValidator.isValidUsername(user.getUsername())      //aus Unterricht
                            && !userValidator.doesUsernameExist(user.getUsername());    //aus Unterricht
        if(canCreate){
            database.addUser(user);//Datenbank wird geschrieben
            return Message.createOK();
        }else{
            return Message.createNotOK();
        }
    }
}
