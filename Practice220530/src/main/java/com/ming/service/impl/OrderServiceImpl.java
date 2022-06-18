package com.ming.service.impl;/*
 * @ Author: MingHui Fan
 * @ Date: 2022/6/09 - 下午10:21
 * @ Description: com.ming.service.impl
 * @ Version: 1.0
 */

import com.mh.utils.CheckInput;
import com.ming.dao.DishDao;
import com.ming.dao.OrderInfoDao;
import com.ming.dao.impl.DishDaoImpl;
import com.ming.dao.impl.OrderInfoDaoImpl;
import com.ming.entity.OrderInfo;
import com.ming.entity.UserDish;
import com.ming.service.DishService;
import com.ming.service.OrderService;
import com.ming.utils.Align;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {

    Scanner scanner = new Scanner(System.in);
    
    // 该类自己包装，用于输出对齐
    Align align = new Align(15);

    // 需要 OrderInfoDao 对象修改和查看 订单列表 数据
    OrderInfoDao orderInfoDao = OrderInfoDaoImpl.getInstance();

    // 需要 DishDao 对象修改和查看 菜品列表 数据
    DishDao dishDao = DishDaoImpl.getInstance();

    // 定义一个菜品业务唯一作用是为了调用输出菜品的方法
    DishService dishService = new DishServiceImpl();

    /**
     * 订餐业务
     */
    @Override
    public void order() {
        System.out.println("*****我要订餐*****");
        if (orderInfoDao.getOrderInfoList().size() >= 10) {
            System.out.print("不好意思，餐袋已满！");
            return;
        }
        // 建立一个订单对象，当用户订单完成之后添加到订单列表(orderInfos)中
        OrderInfo orderInfo = new OrderInfo();
        System.out.print("请输入订餐人姓名：");
        // 将姓名保存到订单对象(orderInfo)中
        orderInfo.setName(scanner.next());

        // 默认不继续点菜
        String ch;
        // 保存用户菜品的列表
        List<UserDish> userDishes = new ArrayList<>();
        // 这个 doWhile 循环用来判断是否继续点菜
        do {
            // 选择要点的菜品编号
            int no;
            boolean flag = true; // 默认输入没有错误
            // 这个 doWhile 循环是用来判断输入的点菜编号是否存在
            do {
                // 先展示以下菜品菜单
                dishService.showDishList();
                System.out.print("请输入您要点的菜品：");
                no = CheckInput.isInputInt(scanner);
                // 这里表示输入的菜品编号有误
                if (no <= 0 || no > dishDao.getDishList().size()) {
                    flag = false;   // 输入有误
                    System.out.println("您输入的菜品编号有误，请重新输入");
                } else {    // 如果输入没问题则需要将 flag=true 退出循环(!flag)
                    flag = true;
                }
            } while (!flag);
            // 选择您的份数
            System.out.print("请选择您的份数：");
            int number = CheckInput.isInputIntAndNumber(scanner, 1, 10);
            UserDish userDish = new UserDish(number, no - 1);
            userDishes.add(userDish);
            System.out.print("您是否还要继续点菜(y/n)：");
            ch = scanner.next();
        } while (ch.equals("Y") || ch.equals("y"));  // 满足则继续点菜
        // 添加到订单对象中，到这里算是点餐已经完成了
        orderInfo.setUserDishes(userDishes);

        // 选择送餐时间
        System.out.print("请选择送餐时间(送餐时间是10点至20点间整点送餐)：");
        orderInfo.setDeliveryTime(CheckInput.isInputIntAndTime(scanner, 10, 20));

        // 送餐地点
        System.out.print("请输入送餐地址：");
        orderInfo.setAddress(scanner.next());

        // 订单状态，0表示未签收
        orderInfo.setStatus(0);

        // 计算总金额
        orderInfo.calculateMoney(dishDao.getDishList());

        // 然后将订单添加到订单列表中(orderInfos)
        orderInfoDao.getOrderInfoList().add(orderInfo);
        System.out.println("订餐成功");
    }

    /**
     * 查看餐袋
     */
    @Override
    public void viewOrder() {
        System.out.println("*****查看餐袋*****");
        align.add("序号")
                .add("订餐人")
                .add("餐品信息")
                .add("单价")
                .add("送餐时间")
                .add("送餐地点")
                .add("总金额")
                .add("订单状态");
        align.format();
        // 遍历的是菜单列表
        // 首先 orderInfos 是一个列表
        // 每个用户都是 orderInfos 的一个元素
        // 而每个用户都有一个菜品的列表 dishes,需要遍历
//        for (OrderInfo o : orderInfos) {
        for (int i = 0; i < orderInfoDao.getOrderInfoList().size(); i++) {
            // 获取第每个用户的订单
            OrderInfo user = orderInfoDao.getOrderInfoList().get(i);
            align.add(i + 1)   // 订单序号
                    .add(user.getName());  // 订餐人
            // 遍历每个用户选择的菜单 OrderInfo 有一个 ArrayList<UserDish>
            for (int j = 0; j < user.getUserDishes().size(); j++) {
                // 输出订餐人选的第一个菜
                if (j != user.getUserDishes().size() - 1) {   // 不是最后一个菜，只需要展示菜品名称
                    align.add(dishDao.getDishList().get(user.getUserDishes().get(j).getDishNo()).getName() + " " + user.getUserDishes().get(0).getNumber() + "份")
                            .add(dishDao.getDishList().get(j).getPrice())
                            .add("\n*").add("*");
                } else {
                    align.add(dishDao.getDishList().get(user.getUserDishes().get(j).getDishNo()).getName() + " " + user.getUserDishes().get(0).getNumber() + "份")
                            .add(dishDao.getDishList().get(j).getPrice())
                            .add(user.getDeliveryTime())
                            .add(user.getAddress())
                            .add(user.getMoney())
                            .add((user.getStatus() == 0) ? "已预订" : "已签收");
                }
            }
            align.format();
        }
        System.out.print("输入回车回到主菜单");
        scanner.nextLine();
    }
}
