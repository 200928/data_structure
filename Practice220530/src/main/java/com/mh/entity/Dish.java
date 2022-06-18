package com.mh.entity;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/6/8 - 上午10:03
 * @ Description: com.mh.entity
 * @ Version: 1.0
 */

import java.io.Serializable;

/**
 * 菜品实体类，
 */
public class Dish implements Serializable {

    // 菜品编号
    private int no;

    // 菜名
    private String name;

    // 单价
    private double price;

    // 点赞数
    private int likes = 0;

    public Dish(int no, String name, double price, int likes) {
        this.no = no;
        this.name = name;
        this.price = price;
        this.likes = likes;
    }

    public void like() {
        this.likes++;
    }

    public int getNo() {
        return no;
    }

    public void setNo(short no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
