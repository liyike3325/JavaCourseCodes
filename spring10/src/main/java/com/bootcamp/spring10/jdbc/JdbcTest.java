package com.bootcamp.spring10.jdbc;

import com.bootcamp.spring10.DBUtil;
import com.bootcamp.spring10.HikariUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc原生接口，实现数据库增删改查
 */
public class JdbcTest {

    /**
     * 创建表
     */
    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS `user` (" +
                "`id` INT UNSIGNED AUTO_INCREMENT, " +
                "`user_name` VARCHAR(100), " +
                "`user_password` VARCHAR(100), " +
                "`user_age` INT(11), " +
                "PRIMARY KEY (`id`)" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        Connection conn = DBUtil.getConnection();
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
        DBUtil.close(stat);
        DBUtil.close(conn);
    }

    /**
     * 增加数据
     */
    public static void add() throws SQLException {
        String sql = "INSERT INTO USER (user_name, user_password, user_age) VALUE('老王', '123456', 18)";
        Connection conn = DBUtil.getConnection();
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
        DBUtil.close(stat);
        DBUtil.close(conn);
    }

    /**
     * 删除数据
     */
    public static void delete() throws SQLException {
        String sql = "DELETE FROM USER WHERE USER.user_name = '老王'";
        Connection conn = DBUtil.getConnection();
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
        DBUtil.close(stat);
        DBUtil.close(conn);
    }

    /**
     * 修改数据
     */
    public static void update() throws SQLException {
        String sql = "UPDATE USER SET USER.user_name = '老李'";
        Connection conn = DBUtil.getConnection();
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
        DBUtil.close(stat);
        DBUtil.close(conn);
    }

    /**
     * 查找数据
     */
    public static void query() throws SQLException {
        String sql = "SELECT * FROM USER";
        Connection conn = DBUtil.getConnection();
        Statement stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery(sql);
        while(resultSet.next()) {
            String username = resultSet.getString("user_name");
            String password = resultSet.getString("user_password");
            String age = resultSet.getString("user_age");
            System.out.println(username + " " + password + " " + age);
        }
        DBUtil.close(resultSet);
        DBUtil.close(stat);
        DBUtil.close(conn);
    }

    public static void main(String[] args) throws SQLException {
        JdbcTest jdbcTest = new JdbcTest();
        jdbcTest.createTable();
        jdbcTest.add();
//        jdbcTest.delete();
        jdbcTest.update();
        jdbcTest.query();
    }
}
