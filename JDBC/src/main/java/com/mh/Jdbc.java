//package com.mh;
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Properties;
//import java.sql.Driver;
///**
// * @ Author: MingHui Fan
// * @ Date: 2021/11/24 - 15:33
// * @ Description: com.mh
// * @ Version: 1.0
// */
//public class Jdbc {
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        // 1.注册驱动
//        Driver driver = new Driver();
//        // 2.连接
//        // 'jdbc:mysql://' 规定好的，表示协议，通过 jdbc 的方式连接 mysql
//        // mysql 的连接本质就是 socket 连接
//        String url = "jdbc:mysql://localhost:3306/learnjdbc";
//        Class.forName(url);
//        // 将用户名和密码放到 Properties 对象
//        Properties properties = new Properties();
//        properties.setProperty("user", "root"); // 用户名
//        properties.setProperty("password", "minghuifan");  // 密码
//        Connection connect = driver.connect(url, properties);
//
//        // 3.执行 SQL 语句
//        String sql = "select * from students";
//        Statement statement = connect.createStatement();
//        int rows = statement.executeUpdate(sql); // 受影响的行数
//
//        if (rows > 0) {
//            System.out.println("查询成功");
//        } else {
//            System.out.println("失败");
//        }
//
//        // 4.关闭连接
//        statement.close();
//        connect.close();
//
//    }
//}
