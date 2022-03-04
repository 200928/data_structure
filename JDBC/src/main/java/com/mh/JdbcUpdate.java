package com.mh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/11/24 - 20:40
 * @ Description: com.mh
 * @ Version: 1.0
 */
public class JdbcUpdate {
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://121.4.26.166/test?characterEncoding=UTF8&useSSL=false";
    private static String USER = "info";
    private static String PASSWORD = "Aoligei2022..";

    private static void update(Statement statement, List<String> s) throws SQLException {
        for (String str : s) {
            int rows = statement.executeUpdate(str);
            System.out.println(rows > 0 ? "成功" : "失败");
        }
    }

    private static void select(Statement statement, String s) throws SQLException {
        ResultSet resultSet = statement.executeQuery(s);
        while (resultSet.next()) {
            System.out.println("id:" + resultSet.getString("id"));
            System.out.println(",name:" + resultSet.getString("name"));
        }
        resultSet.close();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();

        String sql01 = "insert into student values(1,'xiaofan')";
        String sql02 = "insert into student values(2,'范某辉')";
        String sql03 = "delete from student where id='2'";
        List<String> sqlSql = new LinkedList<>();
        sqlSql.add(sql01);
        sqlSql.add(sql02);
        update(statement, sqlSql);
        statement.close();
//        connection.close();
        System.out.println("jifdj");
    }
}
