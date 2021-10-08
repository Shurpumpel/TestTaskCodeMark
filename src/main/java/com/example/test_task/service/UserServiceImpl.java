package com.example.test_task.service;

import com.example.test_task.controller.ResponseStatus;
import com.example.test_task.entity.Role;
import com.example.test_task.repositories.RoleRepository;
import com.example.test_task.repositories.UserRepository;
import com.example.test_task.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public ResponseStatus saveUser(User user) {
        ResponseStatus responseStatus = checkEnteredData(user);
        if(!responseStatus.isSuccess())
            return responseStatus;
        User newUser = new User(user.getName(), user.getLogin(), user.getPassword());
        newUser.getRoles().addAll(user.getRoles().stream().map(
                r -> {
                    Role role;
                    if (roleRepository.findById(r.getId()).isPresent()) {
                        role = roleRepository.getById(r.getId());
                    } else {
                        role = new Role(r.getId(), r.getRole());
                    }
                    return role;
                }).collect(Collectors.toList()));
        userRepository.save(newUser);
        return responseStatus;
    }

    private ResponseStatus checkEnteredData(User user){
        ResponseStatus responseStatus = new ResponseStatus();
        if(user.getName() == null)
            responseStatus.addError("User name is null");
        if(user.getLogin() == null)
            responseStatus.addError("User login is null");
        if(user.getPassword() == null)
            responseStatus.addError("User password is null");
        return responseStatus;
    }

    @Override
    public User getUser(String login) {
        Optional<User> user = userRepository.findById(login);
        if (user.isPresent())
            return user.get();
        else
            throw new NullPointerException("There is not user with login: " + login);
    }

    @Override
    public void deleteUser(String login) {
        User user = getUser(login);
        userRepository.delete(user);
    }
}
