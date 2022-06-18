package com.ming.dao.impl;

/*
 * @ Author: MingHui Fan
 * @ Date: 2022/6/09 - 下午10:21
 * @ Description: com.ming.dao.impl
 * @ Version: 1.0
 */

import com.ming.dao.DishDao;
import com.ming.dao.OrderInfoDao;
import com.ming.entity.OrderInfo;
import com.ming.entity.UserDish;

import java.util.ArrayList;
import java.util.List;

public class OrderInfoDaoImpl implements OrderInfoDao {

    // 私有化构造器
    private OrderInfoDaoImpl() {}
    // 内部创建对象
    private  static OrderInfoDaoImpl instant;
    // 对外公开的创建对象方法
    public static OrderInfoDaoImpl getInstance() {
        if (instant == null) {
            instant = new OrderInfoDaoImpl();
            instant.init();
        }
        return instant;
    }

    // 订单列表
    List<OrderInfo> orderInfoList = new ArrayList<>();

    // 菜品类，需要用到每个菜品的价钱计算
    DishDao dishDao = DishDaoImpl.getInstance();

    @Override
    public List<OrderInfo> getOrderInfoList() {
        return orderInfoList;
    }

    @Override
    public void init() {
        OrderInfo orderInfo; // 订单
        List<UserDish> userDishes = new ArrayList<>();
        UserDish userDish = new UserDish(3, 1); // 菜品选择
        userDishes.add(userDish);
        userDishes.add(userDish);
        userDishes.add(userDish);
        orderInfo = new OrderInfo("老六", userDishes, 15, "东院", 0);
        orderInfo.calculateMoney(dishDao.getDishList());
        orderInfoList.add(orderInfo);
    }
}
