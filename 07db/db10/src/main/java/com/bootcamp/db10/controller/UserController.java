package com.bootcamp.db10.controller;

import com.bootcamp.db10.entity.User;
import com.bootcamp.db10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("save-user")
    public Object saveUser() {
        User user = new User();
        user.setUserName("小黄");
        user.setUserPassword("123");
        user.setUserAge(20);
        return userService.saveOne(user);
    }

    @RequestMapping("list-user")
    public Object listUser() {
        return userService.list();
    }
}
