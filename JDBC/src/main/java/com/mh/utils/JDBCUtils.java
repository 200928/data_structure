package com.mh.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/12/15 - 10:47
 * @ Description: com.mh.utils
 * @ Version: 1.0
 * 工具类，MySQL的连接和关闭资源
 */
public class JDBCUtils {
    private static String DRIVER;   // 驱动名
    private static String URL;      // 连接
    private static String USER;     // 用户名
    private static String PASSWORD; // 密码

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("JDBC/src/main/resources/mysql.properties"));
            DRIVER = properties.getProperty("Driver");
            URL = properties.getProperty("url");
            USER = properties.getProperty("user");
            PASSWORD = properties.getProperty("password");
        } catch (IOException e) {
             // 将编译异常转化为运行异常
             // 调用者可以选择捕获异常，也可以选择默认处理异常
            throw new RuntimeException(e);
        }
    }

    // 连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    // 关闭连接
    public static void close(ResultSet set, Statement statement, Connection connection) {
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
