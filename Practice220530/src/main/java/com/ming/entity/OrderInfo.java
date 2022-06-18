package com.ming.entity;

/*
 * @ Author: MingHui Fan
 * @ Date: 2022/6/8 - 上午10:01
 * @ Description: com.mh.entity
 * @ Version: 1.0
 */

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户订单实体类，包括用户订单的信息
 */
@Data
@NoArgsConstructor
public class OrderInfo implements Serializable {
    // 姓名
    private String name;

    // 菜品
    // 菜品份数
    List<UserDish> userDishes = new ArrayList<>();

    // 送餐时间（10点-20点且整点）
    private int deliveryTime;

    // 送餐地址
    private String address;

    // 状态（已预订0/已签收1）
    private int status;

    // 总金额（菜品单价*份数-送餐费）
    private double money;

    // 计算金额函数
    public void calculateMoney(List<Dish> dishes) {
        // 遍历一下点的菜品列表
        for (UserDish userDish : userDishes) {
            this.money = userDish.getNumber() * dishes.get(userDish.getDishNo()).getPrice();
        }
        this.money = (this.money < 50) ? (this.money + 6) : this.money;
    }

    public OrderInfo(String name, List<UserDish> userDishes, int deliveryTime, String address, int status) {
        this.name = name;
        this.userDishes = userDishes;
        this.deliveryTime = deliveryTime;
        this.address = address;
        this.status = status;
    }
}
