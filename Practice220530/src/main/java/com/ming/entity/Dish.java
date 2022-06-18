package com.ming.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/*
  @ Author: MingHui Fan
  @ Date: 2022/6/8 - 上午10:03
  @ Description: com.mh.entity
  @ Version: 1.0
 */


/**
 * 菜品实体类，
 */
@Data
@AllArgsConstructor
public class Dish implements Serializable {

    // 菜品编号
    private int no;

    // 菜名
    private String name;

    // 单价
    private double price;

    // 点赞数
    private int likes = 0;

    // 添加点赞
    public void like() {
        this.likes++;
    }
}
