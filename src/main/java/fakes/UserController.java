package fakes;

public class UserController {

    private static Database db = FileDatabase.getInstance();

    private UserValidator userValidator;    //fakeuservalidator         //aus Unterricht
    private Database database;              //MockDatabase     jedoch MockDatabase db geht nicht              //aus Unterricht

    public UserController(UserValidator UserValidator){//inject db.adduser
        userValidator = UserValidator;
    }   //aus Unterricht
    public UserController(UserValidator UserValidator, Database database){//inject db.adduser       //aus fake
        userValidator = UserValidator;
        this.database = database;                               //Mok-database
    }

    public Message create(User user){
        if(user == null){
            throw new IllegalArgumentException("user required");
        }
        Boolean canCreate = userValidator.isValidUsername(user.getUsername())       //aus Unterricht    //static bei Uservalidator weg, dann hier Uservalidator klein , weil hier oberhalb konstruktor eine instanz reinkommt irgendwas hier rein komt
                && !userValidator.doesUsernameExist(user.getUsername());    //aus Unterricht
        if(canCreate){
            db.addUser(user);//db
            database.addUser(user);
            return Message.createOK();
        }else{
            return Message.createNotOK();
        }
    }
}



//
//package fakes;
//
//public class UserController {
//
//    private static Database db = FileDatabase.getInstance();
//
//    public Message create(User user){
//        if(user == null){
//            throw new IllegalArgumentException("user required");
//        }
//        Boolean canCreate = UserValidator.isValidUsername(user.getUsername())
//                            && !UserValidator.doesUsernameExist(user.getUsername());
//        if(canCreate){
//            db.addUser(user);
//            return Message.createOK();
//        }else{
//            return Message.createNotOK();
//        }
//    }
//}
