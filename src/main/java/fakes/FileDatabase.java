package fakes;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ideadapt on 19.10.16.
 */
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
        List<User> users = null;
        try(Stream<String> stream = Files.lines(dbPath)){
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
