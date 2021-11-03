package com.bootcamp.db10.service.impl;

import com.bootcamp.db10.entity.User;
import com.bootcamp.db10.mapper.UserMapper;
import com.bootcamp.db10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public String saveOne(User user) {
        userMapper.insert(user);
        return "保存成功";
    }
}
