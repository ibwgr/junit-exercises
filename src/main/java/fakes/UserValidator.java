package fakes;

import java.util.regex.Pattern;

public class UserValidator {

    private Database db = FileDatabase.getInstance();
    private final Pattern validUsernamePattern = Pattern.compile("[A-Za-z]+");

    public UserValidator() {
    }

    public UserValidator(Database db) {
        this.db = db;
    }

    public boolean doesUsernameExist(String username) {
        return db.getUsers().stream().anyMatch(user -> user.getUsername().equalsIgnoreCase(username));
    }

    /**
     * Es gibt verschiedene Varianten diese Methode zu implementieren. Auf
     * https://github.com/ibwgr/junit-exercises/commit/3d762d78399812ac32c9c4346264bef98e011415
     * siehst du weitere Möglichkeiten.
     */
    public boolean isValidUsername(String username) {
        if (containsNonAlphanumericChar(username)) {
            return false;
        }
        if (Character.isDigit(username.charAt(0))) {
            return false;
        }
        if (containsForLettersOnly(username)) {
            return true;
        }
        if (containsNumberButNotAsFirstChar(username)) {
            return true;
        }
        return false;
    }


    private boolean containsForLettersOnly(String name) {
        return validUsernamePattern.matcher(name).matches();
    }

    private boolean containsNonAlphanumericChar(String name) {
        boolean hasNonAlphanumeric = false;

        if (name != null && !name.isEmpty()) {
            for (char c : name.toCharArray()) {
                if (!Character.isLetterOrDigit(c)) {
                    hasNonAlphanumeric = true;
                    break;
                }
            }
        }
        return hasNonAlphanumeric;
    }

    private boolean containsNumberButNotAsFirstChar(String name) {
        if (name != null && !name.isEmpty()) {
            if (Character.isDigit(name.charAt(0))) {
                return false;
            }

            String shortName = name.substring(1);
            for (char c : shortName.toCharArray()) {
                if (Character.isDigit(c)) {
                    return true;
                }
            }
        }
        return false;
    }
}
