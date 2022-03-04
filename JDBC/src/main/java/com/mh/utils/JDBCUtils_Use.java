package com.mh.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/12/15 - 12:04
 * @ Description: com.mh.utils
 * @ Version: 1.0
 */
public class JDBCUtils_Use {

    public static void testUML() {
        // 连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into student values(?, ?)";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            // 给占位符赋值
            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, "小王");
            // 执行
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    public static void testSelect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from student where id = ?";
        try {
            // 得到连接
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "1");
            // 执行得到结果集
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print("id:" + resultSet.getString("id"));
                System.out.println("\tname:" + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }

    public static void main(String[] args) {
        // testUML();
        testSelect();
    }
}
