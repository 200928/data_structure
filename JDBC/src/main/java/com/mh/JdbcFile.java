package com.mh;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/11/25 - 13:31
 * @ Description: com.mh
 * @ Version: 1.0
 * 读取配置文件 mysql.properties 连接数据库
 */
public class JdbcFile {
    public static void main(String[] args) throws IOException {
        // 从文件流中获取 Driver、url、user、password
        Properties properties = new Properties();
        properties.load(new FileInputStream("JDBC/src/main/resources/mysql.properties"));
        String driver = properties.getProperty("Driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println(driver);
        System.out.println(url);
        System.out.println(user);
        System.out.println(password);

        try {
            // 注册驱动
            Class.forName(driver);
            // 得到连接
            Connection connection = DriverManager.getConnection(url, user, password);
            // 用于执行静态 SQL 语句并返回其生成的结果对象
//            Statement statement = connection.createStatement();
//            String sql = "select * from ?";
            String sql = "select * from student where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "1");
            // 用于返回查询结果(数据表)
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print("id:" + resultSet.getString("id"));
                System.out.println(",name:" + resultSet.getString("name"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        // Get base path
        System.out.println(new File("").getAbsolutePath());
    }
}
