package com.ming.dao;/*
 * @ Author: MingHui Fan
 * @ Date: 2022/6/09 - 下午10:21
 * @ Description: com.ming.dao
 * @ Version: 1.0
 */

import com.ming.entity.OrderInfo;

import java.util.List;

public interface OrderInfoDao {
    // 返回订单列表数据
    List<OrderInfo> getOrderInfoList();

    // 数据初始化，展示效果用
    void init();

    //
}
