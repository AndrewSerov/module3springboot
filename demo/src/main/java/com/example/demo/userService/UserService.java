package com.example.demo.userService;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service

public class UserService {


    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public List<User> getAllPeople() {
        return userDao.getAllPeople();
    }

    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Transactional
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }

    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
