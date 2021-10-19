package com.bootcamp.spring10.hikari;

import com.bootcamp.spring10.HikariUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hikari连接池，实现数据库增删改查
 */
public class HikariTest {

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
        Connection conn = HikariUtil.getConnection();
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
        HikariUtil.close(stat);
        HikariUtil.close(conn);
    }

    /**
     * 增加数据
     */
    public static void add() throws SQLException {
        String sql = "INSERT INTO USER (user_name, user_password, user_age) VALUE('老王', '123456', 18)";
        Connection conn = HikariUtil.getConnection();
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
        HikariUtil.close(stat);
        HikariUtil.close(conn);
    }

    /**
     * 删除数据
     */
    public static void delete() throws SQLException {
        String sql = "DELETE FROM USER WHERE USER.user_name = '老王'";
        Connection conn = HikariUtil.getConnection();
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
        HikariUtil.close(stat);
        HikariUtil.close(conn);
    }

    /**
     * 修改数据
     */
    public static void update() throws SQLException {
        String sql = "UPDATE USER SET USER.user_name = '老李'";
        Connection conn = HikariUtil.getConnection();
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
        HikariUtil.close(stat);
        HikariUtil.close(conn);
    }

    /**
     * 查找数据
     */
    public static void query() throws SQLException {
        String sql = "SELECT * FROM USER";
        Connection conn = HikariUtil.getConnection();
        Statement stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery(sql);
        while(resultSet.next()) {
            String username = resultSet.getString("user_name");
            String password = resultSet.getString("user_password");
            String age = resultSet.getString("user_age");
            System.out.println(username + " " + password + " " + age);
        }
        HikariUtil.close(resultSet);
        HikariUtil.close(stat);
        HikariUtil.close(conn);
    }

    public static void main(String[] args) throws SQLException {
        HikariTest hikariTest = new HikariTest();
        hikariTest.createTable();
        hikariTest.add();
//        hikariTest.delete();
        hikariTest.update();
        hikariTest.query();
    }
}
