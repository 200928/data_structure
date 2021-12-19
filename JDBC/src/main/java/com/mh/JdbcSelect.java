package com.mh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/11/24 - 16:28
 * @ Description: com.mh
 * @ Version: 1.0
 */
public class JdbcSelect {
    // 数据库驱动
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://127.0.0.1:3306/learnjdbc";
    // 账户
    private static String USER = "root";
    // 密码
    private static String PASSWORD = "minghuifan";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.使用反射加载了 Driver 类，
        // 在加载 Driver 类时，自动完成注册，静态类内部加载
        /* Driver 类源代码
        public class Driver extends NonRegisteringDriver implements java.sql.Driver {
            public Driver() throws SQLException {
            }
            static {
                try {
                    DriverManager.registerDriver(new Driver());
                } catch (SQLException var1) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
        }
         */
        Class.forName(JDBC_DRIVER);
        // 2.与数据库连接
        // 数据库连接
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        // 3.用于执行静态 SQL 语句并返回其生成的结果对象
        Statement statement = connection.createStatement();
        String sql = "select * from students";
        // 4.用于返回查询结果(数据表)
        ResultSet resultSet = statement.executeQuery(sql);
        // 输出结果，next() boolean
        while (resultSet.next()) {
            System.out.print("id:" + resultSet.getString("id"));
            System.out.print(",name:" + resultSet.getString("name"));
            System.out.print(",gender:" + resultSet.getString("gender"));
            System.out.println(",score:" + resultSet.getString("score"));
        }
//        String sql = "INSERT INTO students (name, gender, grade, score) VALUES ('小范', 0, 3, 55);";

//        resultSet.close();
//        statement.close();
//        connection.close();
    }
}
