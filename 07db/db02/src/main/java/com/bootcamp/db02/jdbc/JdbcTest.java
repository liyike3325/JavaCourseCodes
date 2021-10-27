package com.bootcamp.db02.jdbc;

import com.bootcamp.db02.DBUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 插入100万订单模拟数据，测试不同方式的插入效率
 */
public class JdbcTest {

    private String tid = "TN2021102601";

    /**
     * 方式一：单条sql插入，使用Statement
     * 用时319.11秒
     */
    public void add1() throws SQLException {
        String sql = "";
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
        Connection conn = DBUtil.getConnection();
        Statement stat = conn.createStatement();
        for (int i = 0; i < 1000000; i++) {
            String oid = "ON" + i;
            sql = "INSERT INTO bs_order (uid, tid, oid, item_id, quantity, price, total_fee, payment, item_name, " +
                    "status, create_time, update_time) VALUE(1, '" + tid + "', '" + oid + "', 1, 1, 100, 100, 100, " +
                    "'鞋子', 'TRADE_FINISHED', '" + date + "', '" + date + "')";
            stat.executeUpdate(sql);
            System.out.println("insert " + i);
        }
        DBUtil.close(stat);
        DBUtil.close(conn);
    }

    /**
     * 方式二：单条sql插入，使用PreparedStatement
     * 用时332.6秒
     */
    public void add2() throws SQLException {
        String sql = "";
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
        Connection conn = DBUtil.getConnection();
        sql = "INSERT INTO bs_order (uid, tid, oid, item_id, quantity, price, total_fee, payment, item_name, " +
                "status, create_time, update_time) VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < 1000000; i++) {
            String oid = "ON" + i;
            ps.setInt(1, 1);
            ps.setString(2, tid);
            ps.setString(3, oid);
            ps.setInt(4, 1);
            ps.setInt(5, 1);
            ps.setDouble(6, 100);
            ps.setDouble(7, 100);
            ps.setDouble(8, 100);
            ps.setString(9, "鞋子");
            ps.setString(10, "TRADE_FINISHED");
            ps.setString(11, date);
            ps.setString(12, date);
            ps.executeUpdate();
            System.out.println("insert " + i);
        }
        DBUtil.close(ps);
        DBUtil.close(conn);
    }

    /**
     * 方式三：多条sql批量插入（每次插入1000条）
     * 用时249.66秒
     */
    public void add3() throws SQLException {
        String sql = "";
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
        Connection conn = DBUtil.getConnection();
        sql = "INSERT INTO bs_order (uid, tid, oid, item_id, quantity, price, total_fee, payment, item_name, " +
                "status, create_time, update_time) VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < 1000000; i++) {
            String oid = "ON" + i;
            ps.setInt(1, 1);
            ps.setString(2, tid);
            ps.setString(3, oid);
            ps.setInt(4, 1);
            ps.setInt(5, 1);
            ps.setDouble(6, 100);
            ps.setDouble(7, 100);
            ps.setDouble(8, 100);
            ps.setString(9, "鞋子");
            ps.setString(10, "TRADE_FINISHED");
            ps.setString(11, date);
            ps.setString(12, date);
            // 添加批量处理的sql语句
            ps.addBatch();
            if (i % 1000 == 0) {
                // 执行批量插入
                ps.executeBatch();
                // 清空
                ps.clearBatch();
                System.out.println("insert " + i);
            }
        }
        DBUtil.close(ps);
        DBUtil.close(conn);
    }

    /**
     * 方式四：多条sql批量插入，不自动提交数据（每次插入1000条）
     * 用时84.83秒
     */
    public void add4() throws SQLException {
        String sql = "";
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
        Connection conn = DBUtil.getConnection();
        // 不自动提交数据
        conn.setAutoCommit(false);
        sql = "INSERT INTO bs_order (uid, tid, oid, item_id, quantity, price, total_fee, payment, item_name, " +
                "status, create_time, update_time) VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < 1000000; i++) {
            String oid = "ON" + i;
            ps.setInt(1, 1);
            ps.setString(2, tid);
            ps.setString(3, oid);
            ps.setInt(4, 1);
            ps.setInt(5, 1);
            ps.setDouble(6, 100);
            ps.setDouble(7, 100);
            ps.setDouble(8, 100);
            ps.setString(9, "鞋子");
            ps.setString(10, "TRADE_FINISHED");
            ps.setString(11, date);
            ps.setString(12, date);
            // 添加批量处理的sql语句
            ps.addBatch();
            if (i % 1000 == 0) {
                // 执行批量插入
                ps.executeBatch();
                // 清空
                ps.clearBatch();
                System.out.println("insert " + i);
            }
        }
        // 提交数据
        conn.commit();
        DBUtil.close(ps);
        DBUtil.close(conn);
    }

    public static void main(String[] args) throws SQLException {
        JdbcTest jdbcTest = new JdbcTest();
        Long startTime = System.currentTimeMillis();
//        jdbcTest.add1();
//        jdbcTest.add2();
//        jdbcTest.add3();
        jdbcTest.add4();
        Long endTime = System.currentTimeMillis();
        String seconds = String.format("%.2f", (endTime - startTime) / 1000.0);
        System.out.println("插入数据结束，用时" + seconds + "s");
    }
}
