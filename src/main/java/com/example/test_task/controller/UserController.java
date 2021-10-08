package com.example.test_task.controller;

import com.example.test_task.dto.UserDTO;
import com.example.test_task.dto.UserWithRolesDTO;
import com.example.test_task.entity.User;
import com.example.test_task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    private List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> result = new ArrayList<>();
        for (User user : users) {
            result.add(UserDTO.fromModel(user));
        }
        return result;
    }

    @GetMapping("/users/{login}")
    private UserWithRolesDTO getUserByLogin(@PathVariable String login) {
        User user = userService.getUser(login);
        return UserWithRolesDTO.fromModel(user);
    }

    @PostMapping("/users")
    private ResponseStatus createUser(@RequestBody User user) {
       return userService.saveUser(user);
    }

//    Пока не знаю, так ли нужен этот метод, createUser итак все делает
//    @PutMapping("/users")
//    private void updateUser(@RequestBody User user){
//        userService.saveUser(user);
//    }

    @DeleteMapping("/users/{login}")
    private void deleteUser(@PathVariable String login){
        userService.deleteUser(login);
    }

}
