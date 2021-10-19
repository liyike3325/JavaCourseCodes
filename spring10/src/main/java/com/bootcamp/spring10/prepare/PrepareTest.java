package com.bootcamp.spring10.prepare;

import com.bootcamp.spring10.DBUtil;

import java.sql.*;

/**
 * PrepareStatement方式，实现数据库增删改查
 */
public class PrepareTest {

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
        // 开启事物
        conn.setAutoCommit(false);
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate();
        // 提交事物
        conn.commit();
        // 关闭连接
        conn.close();
    }

    /**
     * 增加数据
     */
    public static void add() throws SQLException {
        String sql = "INSERT INTO USER (user_name, user_password, user_age) VALUE('老王', '123456', 18)";
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate();
        conn.commit();
        conn.close();
    }

    /**
     * 删除数据
     */
    public static void delete() throws SQLException {
        String sql = "DELETE FROM USER WHERE USER.user_name = '老王'";
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate();
        conn.commit();
        conn.close();
    }

    /**
     * 修改数据
     */
    public static void update() throws SQLException {
        String sql = "UPDATE USER SET USER.user_name = '老李'";
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate();
        conn.commit();
        conn.close();
    }

    /**
     * 查找数据
     */
    public static void query() throws SQLException {
        String sql = "SELECT * FROM USER";
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            String username = resultSet.getString("user_name");
            String password = resultSet.getString("user_password");
            String age = resultSet.getString("user_age");
            System.out.println(username + " " + password + " " + age);
        }
        conn.commit();
        conn.close();
    }

    public static void main(String[] args) throws SQLException {
        PrepareTest prepareTest = new PrepareTest();
        prepareTest.createTable();
        prepareTest.add();
//        prepareTest.delete();
        prepareTest.update();
        prepareTest.query();
    }
}
