package com.ming.dao;/*
 * @ Author: MingHui Fan
 * @ Date: 2022/6/09 - 下午10:21
 * @ Description: com.ming.dao
 * @ Version: 1.0
 */

import com.ming.entity.Dish;

import java.util.List;

public interface DishDao {
    // 返回菜品列表数据
    List<Dish> getDishList();

    // 数据初始化，展示效果用
    void init();
}
