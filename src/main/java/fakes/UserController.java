package fakes;

public class UserController {

  private final Database db;
  private final UserValidator userValidator;

  public UserController() {
    this.userValidator = new UserValidator();
    this.db = FileDatabase.getInstance();
  }

  public UserController(UserValidator userValidator) {
    this.userValidator = userValidator;
    this.db = FileDatabase.getInstance();
  }

  public UserController(UserValidator userValidator, Database db) {
    this.userValidator = userValidator;
    this.db = db;
  }

  public Message create(User user) {
    if (user == null) {
      throw new IllegalArgumentException("user required");
    }
    Boolean canCreate = userValidator.isValidUsername(user.getUsername())
            && !userValidator.doesUsernameExist(user.getUsername());
    if (canCreate) {
      db.addUser(user);
      return Message.createOK();
    } else {
      return Message.createNotOK();
    }
  }
}
