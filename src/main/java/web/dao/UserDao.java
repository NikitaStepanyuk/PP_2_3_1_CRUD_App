package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    User readUser(int id);

    List<User> readAllUsers();
}
