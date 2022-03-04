package com.mh.batch;

import com.mh.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/12/15 - 14:11
 * @ Description: com.mh.batch
 * @ Version: 1.0
 * 比较批处理和非批处理执行插入语句的时间
 */
public class Batch {

    /**5000条
     * 开始执行
     * 耗时:437
     *
     * 5000000条
     * 开始执行
     * 耗时:179408ms
     */
    private static void batchTest() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into user values(null, ?, ?)";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("开始执行");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 5000000; i++) {
                preparedStatement.setString(1, "jack" + i);
                preparedStatement.setString(2, "include");
                preparedStatement.addBatch();
                // 每 1000 条执行一下
                if ((i + 1) % 1000000 == 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("耗时:" + (end - start) + "ms");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    /**
     * 开始执行
     * 耗时:169171
     */
    private static void noBatchTest() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into user values(null, ?, ?)";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("开始执行");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 5000; i++) {
                preparedStatement.setString(1, "jack" + i);
                preparedStatement.setString(2, "include");
                preparedStatement.executeUpdate();
            }
            long end = System.currentTimeMillis();
            System.out.println("时间:" + (end - start));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    public static void main(String[] args) {
        batchTest();
//        noBatchTest();
    }
}
