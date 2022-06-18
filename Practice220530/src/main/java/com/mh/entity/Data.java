package com.mh.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/6/8 - 下午3:25
 * @ Description: com.mh.entity
 * @ Version: 1.0
 */
@lombok.Data
public class Data implements Serializable {

    // 用来存储订单，ArrayList每一个元素都是一个订单
    ArrayList<OrderInfo> orderInfos = new ArrayList<>();

    // 用来存储菜品
    ArrayList<Dish> dishes = new ArrayList<>();

    public Data() {
        // 默认菜品
        Dish dishes;
        dishes = new Dish(1, "红烧带鱼", 38.0, 2);
        this.dishes.add(dishes);
        dishes = new Dish(2, "鱼香肉丝", 20.0, 1);
        this.dishes.add(dishes);
        dishes = new Dish(3, "时令蔬菜", 10.0, 0);
        this.dishes.add(dishes);

        // 默认餐袋
        OrderInfo orderInfo; // 订单
        ArrayList<UserDish> userDishes = new ArrayList<>();
        UserDish userDish = new UserDish(3, 1); // 菜品选择
        userDishes.add(userDish);
        userDishes.add(userDish);
        userDishes.add(userDish);
        orderInfo = new OrderInfo("老六", userDishes, 15, "东院", 0);
        orderInfo.calculateMoney(this.dishes);
        orderInfos.add(orderInfo);
    }
}
