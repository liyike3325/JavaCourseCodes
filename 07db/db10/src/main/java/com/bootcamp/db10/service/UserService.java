package com.bootcamp.db10.service;

import com.bootcamp.db10.entity.User;

import java.util.List;

public interface UserService {

    List<User> list();

    String saveOne(User user);
}
