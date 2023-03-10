package com.example.demo.dao;



import com.example.demo.entity.User;

import java.util.List;


public interface UserDao {


    List<User> getAllPeople();

    void saveUser(User user);

    User getById(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
