package com.example.test_task.service;

import com.example.test_task.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUser(String login);
    void deleteUser(String login);
}
