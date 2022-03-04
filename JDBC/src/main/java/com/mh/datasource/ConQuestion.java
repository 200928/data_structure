package com.mh.datasource;

import com.mh.utils.JDBCUtils;

import java.sql.Connection;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/12/15 - 15:07
 * @ Description: com.mh.datasource
 * @ Version: 1.0
 */
public class ConQuestion {

    // 连接 5000 次
    private static void testCon() {
        System.out.println("开始执行......");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            Connection connection = JDBCUtils.getConnection();
//            JDBCUtils.close(null, null, connection);
            System.out.println("第" + i);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "ms");
    }

    public static void main(String[] args) {
        testCon();
    }
}
