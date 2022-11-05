package fakes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileDatabase extends Database {

    public static FileDatabase instance;

    public static Database getInstance(){
        if(instance == null){
            instance = new FileDatabase();
        }
        return instance;
    }

    private final String PATH = "src/main/resources/db.txt";
    private final Path dbPath = Paths.get(PATH);

    public FileDatabase(){
        File f = new File(dbPath.toString());
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addUser(User user) {
        List<User> users = this.getUsers();
        users.add(user);
        try {
            Files.write(dbPath, users.stream().map(u -> u.getUsername()).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUsers() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<User> users = null;
        try (Stream<String> stream = Files.lines(dbPath)) {
            users = stream
                    .map(String::trim)
                    .filter(line -> line.length() > 0)
                    .map(line -> new User(line))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
