package com.ming.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/*
 * @ Author: MingHui Fan
 * @ Date: 2022/6/8 - 下午4:04
 * @ Description: com.mh.entity
 * @ Version: 1.0
 */

/**
 * 用户订单菜品类
 */
@Data
@AllArgsConstructor
public class UserDish implements Serializable {
    // 菜品份数
    private int number;

    // 菜品编号
    private int dishNo;
}
