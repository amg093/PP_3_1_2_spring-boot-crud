package ru.abasov.springbootmvchibernate.dao;

import ru.abasov.springbootmvchibernate.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);
    User getUserById(Long id);
}
