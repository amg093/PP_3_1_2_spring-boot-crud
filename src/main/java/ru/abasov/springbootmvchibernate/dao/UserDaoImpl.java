package ru.abasov.springbootmvchibernate.dao;


import org.springframework.stereotype.Repository;
import ru.abasov.springbootmvchibernate.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
            entityManager.remove(getUserById(id));
        if (getAllUsers().isEmpty()) {
            entityManager.createNativeQuery("TRUNCATE TABLE users", User.class).executeUpdate();
        }
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}
