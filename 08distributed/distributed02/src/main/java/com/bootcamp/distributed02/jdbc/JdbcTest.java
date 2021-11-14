package com.bootcamp.distributed02.jdbc;

import com.bootcamp.distributed02.DBUtil;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * 水平分库分表增删改查
 */
public class JdbcTest {

    /**
     * 新增数据
     */
    public void create() throws SQLException {
        String sql = "";
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
        Connection conn = DBUtil.getConnection();
        Statement stat = conn.createStatement();
        String oid = "ON1";
        sql = "INSERT INTO bs_order (uid, oid, item_id, quantity, price, total_fee, payment, item_name, " +
                "status, create_time, update_time) VALUE(2, '" + oid + "', 1, 1, 100, 100, 100, " +
                "'鞋子', 'TRADE_FINISHED', '" + date + "', '" + date + "')";
        stat.executeUpdate(sql);
        DBUtil.close(stat);
        DBUtil.close(conn);
    }

    /**
     * 删除数据
     */
    public void delete() throws SQLException {
        String sql = "DELETE FROM bs_order WHERE tid = 664119294002462721";
        Connection conn = DBUtil.getConnection();
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
        DBUtil.close(stat);
        DBUtil.close(conn);
    }

    /**
     * 修改数据
     */
    public void update() throws SQLException {
        String sql = "UPDATE bs_order SET item_name = '鞋子1999' WHERE tid = 664127664474292224";
        Connection conn = DBUtil.getConnection();
        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
        DBUtil.close(stat);
        DBUtil.close(conn);
    }

    /**
     * 查找数据
     */
    public void query() throws SQLException {
        String sql = "SELECT * FROM bs_order";
        Connection conn = DBUtil.getConnection();
        Statement stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery(sql);
        while(resultSet.next()) {
            String tid = resultSet.getString("tid");
            String item_name = resultSet.getString("item_name");
            String price = resultSet.getString("price");
            System.out.println(tid + " " + item_name + " " + price);
        }
        DBUtil.close(resultSet);
        DBUtil.close(stat);
        DBUtil.close(conn);
    }

    public static void main(String[] args) throws SQLException {
        JdbcTest jdbcTest = new JdbcTest();
        jdbcTest.create();
//        jdbcTest.delete();
//        jdbcTest.update();
//        jdbcTest.query();
    }
}
