package com.mh.foodie;

import com.mh.entity.Data;
import com.mh.enums.MenuEnum;
import com.mh.serviceImpl.Operate;
import com.mh.utils.CheckInput;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/6/8 - 上午9:54
 * @ Description: com.mh.foodie
 * @ Version: 1.0
 */
public class Menu implements Serializable {

    Operate operate = new Operate();

    Data data = operate.readLocally();
//    Data data = new Data();

    public Menu() throws IOException, ClassNotFoundException {
    }

    // 菜单
    public void showMenu() {
        System.out.println("欢迎使用\"吃货联盟订餐系统\"");
        System.out.println("****************************************");
        // 遍历枚举类，以展示菜单，需要重写枚举类的 toString()方法
        Arrays.stream(MenuEnum.values()).filter(i -> {
            return i != MenuEnum.ERROR;
        }).forEachOrdered(System.out::println);
        System.out.println("****************************************");
    }

    public void selectMenu() throws IOException {
        // 用来处理各个功能的类
        Scanner scanner = new Scanner(System.in);
        // selectMenuNum 为用户选择菜单编号
        int selectMenuNum;
        do {
            System.out.print("\n请选择：");
            selectMenuNum = CheckInput.isInputInt(scanner);
            switch (MenuEnum.getCodeType(selectMenuNum)) {
                // 1.我要订餐
                case ORDER:
                    // 订餐的需要一个订单
                    operate.order(data.getOrderInfos(), data.getDishes());
                    break;
                // 2.查看餐袋
                case VIEW_ORDER:
                    operate.viewOrder(data.getOrderInfos(), data.getDishes());
                    break;
                // 3.签收订单
                case SIGN_THE_ORDER:
                    operate.signTheOrder(data.getOrderInfos());
                    break;
                // 4.删除订单
                case DELETE_ORDER:
                    operate.deleteOrder(data.getOrderInfos());
                    break;
                // 5.我要点赞
                case LIKE:
                    operate.like(data.getDishes());
                    break;
                // 6.退出系统
                case EXIT:
                    operate.saveLocally(data);
                    operate.exit();
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
        operate.saveLocally(data);
    }
}
