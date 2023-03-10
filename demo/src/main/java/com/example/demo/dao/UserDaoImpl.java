package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;



    @Override
    @Transactional
    public List<User> getAllPeople() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getById(int id) {
        Query query = entityManager.createQuery("from User where id = :p");
        query.setParameter("p", id);
        return (User) query.getSingleResult();
    }

    @Override
    public void updateUser(int id, User user) {
        User user1 = getById(id);
        user1.setName(user.getName());
        user1.setLastname(user.getLastname());
    }

    @Override
    public void deleteUser(int id) {
        User user = getById(id);
        entityManager.remove(user);
    }
}
