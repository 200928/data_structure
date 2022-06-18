package com.mh.entity;

import java.io.Serializable;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/6/8 - 下午4:04
 * @ Description: com.mh.entity
 * @ Version: 1.0
 */
public class UserDish implements Serializable {
    // 菜品份数
    private int number;

    // 菜品编号
    private int dishNo;

    public UserDish(int number, int dishNo) {
        this.number = number;
        this.dishNo = dishNo;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDishNo() {
        return dishNo;
    }

    public void setDishNo(int dishNo) {
        this.dishNo = dishNo;
    }
}
