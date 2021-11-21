package fakes;

public class User {

    private String username;

    public User(String username){
        this.username = username;
    }

    public String getUsername() {

        System.out.println("User getUserName: Hello Kitty"+username);
        return username;
    }
}
