package ru.abasov.springbootmvchibernate.service;

import ru.abasov.springbootmvchibernate.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);
    User getUserById(Long id);
}
