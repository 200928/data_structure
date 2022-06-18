package com.ming.service;/*
 * @ Author: MingHui Fan
 * @ Date: 2022/6/09 - 下午10:21
 * @ Description: com.ming.service
 * @ Version: 1.0
 */

/**
 * 该业务层接口定义了两个功能
 * 1. 订餐功能
 * 2. 查看餐袋功能
 */
public interface OrderService {
    // 点餐
    void order();

    // 查看餐袋
    void viewOrder();
}
