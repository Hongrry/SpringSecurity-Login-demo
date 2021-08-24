package com.example.springsecurity;

import com.example.springsecurity.entity.Authority;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.service.UserService;
import com.example.springsecurity.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

@SpringBootTest
class SpringSecurityApplicationTests {
    @Autowired
    UserServiceImpl userService;

    @Test
    void contextLoads() {
        User user = new User("1", "123");
        boolean b = userService.insertUser(user);
        System.out.println(b);
    }

}
