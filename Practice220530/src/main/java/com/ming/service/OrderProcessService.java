package com.ming.service;

/*
 * @ Author: MingHui Fan
 * @ Date: 2022/6/09 - 下午10:21
 * @ Description: com.ming.service
 * @ Version: 1.0
 */

/**
 * 该业务接口主要定义了两个功能
 * 1. 订单签收
 * 2. 订单删除
 */
public interface OrderProcessService {
    // 1. 订单签收
    void orderSign();

    // 2. 订单删除
    void orderDelete();

    // 下面是一些为上面两个业务服务的功能
    // 判断订单是否存在
    boolean isOrder(int orderNo);

    // 判断订单是否签收
    boolean isSign(int orderNo);
}
