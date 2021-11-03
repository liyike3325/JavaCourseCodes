package com.bootcamp.db09.service;

import com.bootcamp.db09.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("secondJdbcTemplate")
    JdbcTemplate secondJdbcTemplate;

    /**
     * 新增使用master数据库
     */
    @RequestMapping("/api/add")
    public void add() {
        String sql = "INSERT INTO user (user_name, user_password, user_age) VALUE('老王', '123456', 18)";
        jdbcTemplate.update(sql);
    }

    /**
     * 查询使用slave数据库
     */
    @RequestMapping("/api/query")
    public List<User> query() {
        String sql = "SELECT * FROM user";
        return secondJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
}
