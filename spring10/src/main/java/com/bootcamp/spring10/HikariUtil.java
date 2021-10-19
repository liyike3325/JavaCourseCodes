package com.bootcamp.spring10;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class HikariUtil {

    private static String url;
    private static String user;
    private static String password;
    private static HikariDataSource ds;

    static {
        try {
            // 读取配置文件
            InputStream in = DBUtil.class.getResourceAsStream("/db.properties");
            Properties properties = new Properties();
            // 加载配置文件
            properties.load(in);
            // 获取配置文件中的数据
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(url);
            config.setUsername(user);
            config.setPassword(password);
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            ds = new HikariDataSource(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个数据库链接
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 关闭资源
     */
    public static void close(AutoCloseable rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
