package com.ming.dao.impl;/*
 * @ Author: MingHui Fan
 * @ Date: 2022/6/09 - 下午10:21
 * @ Description: com.ming.dao.impl
 * @ Version: 1.0
 */

import com.ming.dao.DishDao;
import com.ming.entity.Dish;

import java.util.ArrayList;
import java.util.List;

public class DishDaoImpl implements DishDao {

    // 私有化构造器
    private DishDaoImpl() {}
    // 内部创建对象
    private static DishDaoImpl instant;
    // 对外公开的创建对象方法
    public static DishDaoImpl getInstance() {
        if (instant == null) {
            instant = new DishDaoImpl();
            instant.init();
        }
        return instant;
    }

    // 菜品列表
    List<Dish> dishList = new ArrayList<>();

    /**
     * @return 返回菜品数据
     */
    @Override
    public List<Dish> getDishList() {
        return dishList;
    }

    /**
     * 对菜品列表数据初始化（做项目展示用）
     */
    @Override
    public void init() {
        Dish dish;
        dish = new Dish(1, "红烧带鱼", 38.0, 2);
        this.dishList.add(dish);
        dish = new Dish(2, "鱼香肉丝", 20.0, 1);
        this.dishList.add(dish);
        dish = new Dish(3, "时令蔬菜", 10.0, 0);
        this.dishList.add(dish);
    }
}
