package com.ming.service;/*
 * @ Author: MingHui Fan
 * @ Date: 2022/6/09 - 下午10:21
 * @ Description: com.ming.service
 * @ Version: 1.0
 */

/**
 * 该业务接口主要有两个功能
 * 1. 菜品点赞
 * 2. 输出菜品列表
 */
public interface DishService {
    // 1. 菜品点赞
    void like();

    // 2. 输出菜品列表
    void showDishList();

    // 根据序号查看菜品是否存在
    boolean isDish(int no);
}
