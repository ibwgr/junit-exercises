package fakes;

public class FakeUserValidator extends UserValidator {
  private final boolean doesUsernameExist;
  private final boolean isValidUsername;

  public FakeUserValidator(boolean isValidUsername, boolean doesUsernameExist) {
    this.doesUsernameExist = doesUsernameExist;
    this.isValidUsername = isValidUsername;
  }

  @Override
  public boolean doesUsernameExist(String username) {
    return doesUsernameExist;
  }

  @Override
  public boolean isValidUsername(String username) {
    return isValidUsername;
  }
}
