package com.ming.controller;

/*
 * @ Author: MingHui Fan
 * @ Date: 2022/6/09 - 下午10:21
 * @ Description: com.ming.controller
 * @ Version: 1.0
 */

import com.ming.enums.MenuEnum;
import com.ming.service.DishService;
import com.ming.service.OrderProcessService;
import com.ming.service.OrderService;
import com.ming.service.impl.DishServiceImpl;
import com.ming.service.impl.OrderProcessServiceImpl;
import com.ming.service.impl.OrderServiceImpl;
import com.ming.utils.CheckInput;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 该类为客户端直接接触的类，只有两个接口给用户
 * 1. 展示主菜单
 * 2. 选择主菜单的选项实现一些功能
 */
public class MenuController {

    Scanner scanner = new Scanner(System.in);

    /**
     * 该业务类实现的功能有
     * 1. 订餐
     * 2. 查看餐袋
     */
    OrderService orderService = new OrderServiceImpl();

    /**
     * 该业务类实现的功能有
     * 1. 签收订单
     * 2. 删除订单
     */
    OrderProcessService orderProcessService = new OrderProcessServiceImpl();

    /**
     * 该业务类实现的功能有
     * 1. 点赞
     * 2.
     */
    DishService dishService = new DishServiceImpl();

    // 菜单
    public void showMenu() {
        System.out.println("\n欢迎使用\"吃货联盟订餐系统\"");
        System.out.println("****************************************");
        // 遍历枚举类，以展示菜单，需要重写枚举类的 toString()方法
        Arrays.stream(MenuEnum.values()).filter(i -> {
            return i != MenuEnum.ERROR;
        }).forEachOrdered(System.out::println);
        System.out.println("****************************************");
    }

    public void userSystem() {
        // 用来处理各个功能的类
        Scanner scanner = new Scanner(System.in);
        // selectMenuNum 为用户选择菜单编号
        int selectMenuNum;
        do {
            showMenu();
            System.out.print("请选择：");
            selectMenuNum = CheckInput.isInputInt(scanner);
            switch (MenuEnum.getCodeType(selectMenuNum)) {
                // 1.我要订餐
                case ORDER:
                    // 订餐的需要一个订单
                    orderService.order();
                    break;
                // 2.查看餐袋
                case VIEW_ORDER:
                    orderService.viewOrder();
                    break;
                // 3.签收订单
                case SIGN_THE_ORDER:
                    orderProcessService.orderSign();
                    break;
                // 4.删除订单
                case DELETE_ORDER:
                    orderProcessService.orderDelete();
                    break;
                // 5.我要点赞
                case LIKE:
                    dishService.like();
                    break;
                // 6.退出系统
                case EXIT:
                    System.out.println("感谢您的使用，欢迎下次光临！");
                    break;
                // 来到 ERROR 的情况是 selectMenuNum
                case ERROR:
                    System.out.println("输入有误，请输入1-6之间的整数！，请重新选择");
                    break;
                default:
                    System.out.println("程序有问题！还不赶紧修Bug");
                    break;
            }
        } while (selectMenuNum != 6);
    }
}
