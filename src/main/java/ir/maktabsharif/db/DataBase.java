package ir.maktabsharif.db;

import ir.maktabsharif.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static final List<User> users = new ArrayList<>();
    public static void addUser(User user) {
        users.add(user);
    }
    public static List<User> getUsers() {
        return users;
    }
}
