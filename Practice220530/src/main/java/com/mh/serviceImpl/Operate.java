package com.mh.serviceImpl;

import com.mh.entity.Data;
import com.mh.entity.Dish;
import com.mh.entity.OrderInfo;
import com.mh.entity.UserDish;
import com.mh.utils.Align;
import com.mh.utils.CheckInput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/6/8 - 上午11:14
 * @ Description: com.mh.serviceImpl
 * @ Version: 1.0
 */
public class Operate {

    Align align = new Align(15);

    public static Scanner scanner = new Scanner(System.in);

    // 我要点餐功能
    public boolean order(ArrayList<OrderInfo> orderInfos, ArrayList<Dish> dishes) {
        System.out.println("*****我要订餐*****");
        // 建立一个订单对象，当用户订单完成之后添加到订单列表(orderInfos)中
        OrderInfo orderInfo = new OrderInfo();
        System.out.print("请输入订餐人姓名：");
        // 将姓名保存到订单对象(orderInfo)中
        orderInfo.setName(scanner.next());

        // 默认不继续点菜
        String ch = "N";
        // 保存用户菜品的列表
        ArrayList<UserDish> userDishes = new ArrayList<>();
        // 这个 doWhile 循环用来判断是否继续点菜
        do {
            // 选择要点的菜品编号
            int no = -1;
            boolean flag = true; // 默认输入没有错误
            // 这个 doWhile 循环是用来判断输入的点菜编号是否存在
            do {
                // 先展示以下菜品菜单
                showDishes(dishes);
                System.out.print("请输入您要点的菜品：");
                no = CheckInput.isInputInt(scanner);
                // 这里表示输入的菜品编号有误
                if (no <= 0 || no > dishes.size()) {
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
        orderInfo.calculateMoney(dishes);

        // 然后将订单添加到订单列表中(orderInfos)
        orderInfos.add(orderInfo);
        System.out.println("订餐成功");
        return true;
    }

    // 查看餐袋
    public void viewOrder(ArrayList<OrderInfo> orderInfos, ArrayList<Dish> dishes) {
        System.out.println("*****查看餐袋*****");
        align.add("序号")
                .add("订餐人")
                .add("餐品信息")
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
        for (int i = 0; i < orderInfos.size(); i++) {
            // 获取第每个用户的订单
            OrderInfo user = orderInfos.get(i);
            align.add(i + 1)   // 订单序号
                    .add(user.getName());  // 订餐人
            // 遍历每个用户选择的菜单 OrderInfo 有一个 ArrayList<UserDish>
            for (int j = 0; j < user.getUserDishes().size(); j++) {
                // 输出订餐人选的第一个菜
                if (j != user.getUserDishes().size() - 1) {   // 不是最后一个菜，只需要展示菜品名称
                    align.add(dishes.get(user.getUserDishes().get(j).getDishNo()).getName() + " " + user.getUserDishes().get(0).getNumber() + "份")
                            .add("\n*").add("*");
                } else {
                    align.add(dishes.get(user.getUserDishes().get(j).getDishNo()).getName() + " " + user.getUserDishes().get(0).getNumber() + "份")
                            .add(user.getDeliveryTime())
                            .add(user.getAddress())
                            .add(user.getMoney())
                            .add((user.getStatus() == 0) ? "已预订" : "已签收");
                }
            }
            align.format();
        }
    }

    // 签收订单
    public void signTheOrder(ArrayList<OrderInfo> orderInfos) {
        System.out.println("*****签收订单*****");
        // 签收订单编号
        int orderNo;
        boolean flag = false;
        do {
            System.out.print("请选择要签收的订单序号(输入0返回主菜单)：");
            orderNo = CheckInput.isInputInt(scanner);
            // 判断订单是否存在(true)
            boolean isOrder = isOrder(orderInfos, orderNo);
            // 判断订单是否已经签收，已经已经签收才能删除
            boolean isSign = isSign(orderInfos, orderNo);
            if (0 == orderNo) {
                flag = true;
                continue;
            }
            // 如果订单不存在
            // 如果订单不存在
            if (!isOrder) {
                System.out.print("您要签收的订单不存在，");
            }
            // 如果订单还未签收，则签收
            else if (!isSign) {
                orderInfos.get(orderNo - 1).setStatus(1);
                System.out.println("订单签收成功！");
            }
            // 如果订单已经签收了，无需在次签收
            else {
                System.out.print("订单已经签收了，无需在次签收！");
            }
        } while (!flag);
    }

    // 删除订单
    public void deleteOrder(ArrayList<OrderInfo> orderInfos) {
        System.out.println("*****删除订单*****");
        boolean flag = false;
        System.out.print("请输入要删除的订单序号(输入0返回主菜单)：");
        // 要删除的订单
        int orderNo;
        do {
            orderNo = CheckInput.isInputInt(scanner);
            // 判断订单是否存在(true)
            boolean isOrder = isOrder(orderInfos, orderNo);
            // 判断订单是否已经签收，已经已经签收才能删除
            boolean isSign = isSign(orderInfos, orderNo);
            if (0 == orderNo) {
                flag = true;
                continue;
            }
            // 如果订单不存在
            if (!isOrder) {
                System.out.print("您要删除的订单不存在，请重新输入订单号(输入0返回主菜单)：");
            }
            // 如果订单还未签收，也不能删除
            else if (!isSign) {
                System.out.print("您要删除的订单还未签收，请先签收在删除，请重新输入订单号(输入0返回主菜单)：");
            }
            // 如果存在且签收了，则可以删除了
            else {
                orderInfos.remove(orderNo - 1);
                System.out.print("订单删除成功！继续输入要删除的订单号");
                System.out.print("(输入0返回主菜单)：");
            }
        } while (!flag);
    }

    // 点赞
    public void like(ArrayList<Dish> dishes) {
        System.out.println("*****我要点赞*****");
        // 待点赞的编号
        int likeNo;
        boolean flag = false;
        do {
            // 先展示以下菜品列表
            showDishes(dishes);
            System.out.print("请输入要点赞的菜品序号(输入0返回主菜单)：");
            // 输入要点赞的菜品编号
            likeNo = CheckInput.isInputInt(scanner);
            // 判断输入编号对应菜品是否存在
            boolean isDish = idDish(dishes, likeNo);
            if (0 == likeNo) {
                flag = true;
                continue;
            }
            // 如果对应菜品不存在
            if (!isDish) {
                System.out.println("抱歉，没有找到对应的菜品");
            } else {    // 如果找到则点赞
                dishes.get(likeNo - 1).like();
                System.out.println("恭喜你，点赞成功！");
            }
        } while (!flag);
    }

    // 退出系统
    public void exit() {
        System.out.println("感谢您的使用，欢迎下次光临！");
    }

    // 判断订单是否存在
    public boolean isOrder(ArrayList<OrderInfo> orderInfos, int orderNo) {
        return orderNo > 0 && orderNo <= orderInfos.size();
    }

    // 判断订单是否签收
    public boolean isSign(ArrayList<OrderInfo> orderInfos, int orderNo) {
        if (!isOrder(orderInfos, orderNo)) {
            return false;
        }
        return 0 != orderInfos.get(orderNo - 1).getStatus();
    }

    // 列举菜品种类
    public void showDishes(ArrayList<Dish> dishes) {
        for (Dish d : dishes) {
            align.add(d.getNo()).add(d.getName()).add(d.getPrice() + "元").add((0 == d.getLikes()) ? "" : (d.getLikes() + "赞"));
            align.format();
        }
    }

    // 判断 no 菜品编号是否在菜品菜单中
    public boolean idDish(ArrayList<Dish> dishes, int no) {
        return no > 0 && no <= dishes.size();
    }

    public void saveLocally(Data data) throws IOException {
        File file = new File("/mnt/file/Code/JAVA_IDEA/JavaSE_study/Test/src/main/resources/data");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(data);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public Data readLocally() throws IOException, ClassNotFoundException {
        File file = new File("/mnt/file/Code/JAVA_IDEA/JavaSE_study/Test/src/main/resources/data");
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Data data = new Data();
        data = (Data) objectInputStream.readObject();
        return data;
    }

}