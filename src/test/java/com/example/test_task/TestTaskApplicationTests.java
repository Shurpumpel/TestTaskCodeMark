package com.example.test_task;

import com.example.test_task.entity.User;
import com.example.test_task.repositories.UserRepository;
import com.example.test_task.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class TestTaskApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void newUserAdds(){
        User user = new User("name", "login", "password");
        userService.saveUser(user);
        boolean isSaved = userRepository.findById(user.getLogin()).isPresent();
        Assert.isTrue(isSaved,"Assertion failed, didn't save to database");
    }

    @Test
    void userUpdates(){
        User user = new User("name", "login", "password");
        userRepository.save(user);
        User user1 = new User("new", "login", "password");
        userService.saveUser(user1);
        User saved = null;
        Optional<User> savedOpt = userRepository.findById(user.getLogin());
        if(savedOpt.isPresent())
            saved = savedOpt.get();
        userRepository.delete(user1);
        Assert.isTrue(saved!=user, "Assertion failed, didn't update database");
    }

    @Test
    void userDeletes(){
        User user = new User("name", "login", "password");
        userRepository.save(user);
        userService.deleteUser(user.getLogin());
        Optional<User> userOpt = userRepository.findById(user.getLogin());
        Assert.isTrue(userOpt.isEmpty(), "Assertion failed, didn't delete from database");
    }

}
