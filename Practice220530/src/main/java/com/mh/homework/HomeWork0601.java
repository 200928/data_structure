package com.mh.homework;

import java.util.Scanner;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/6/1 - 上午10:12
 * @ Description: com.mh
 * @ Version: 1.0
 */
public class HomeWork0601 {
    public void HomeWork1() {
        System.out.print("请输入您的成绩：");
        int score = new Scanner(System.in).nextInt();
        if (score > 90) {
            System.out.println("老师奖励Ip6");
        }
        System.out.println();
    }

    public void HomeWork2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您的Java成绩：");
        int javaScore = scanner.nextInt();
        System.out.print("请输入您的音乐成绩：");
        int musicScore = scanner.nextInt();
        boolean a = javaScore > 90 && musicScore > 80;
        boolean b = javaScore == 100 && musicScore > 70;
        if (a || b) {
            System.out.println("奖励");
        }
    }

    public void test1() {
        System.out.println("我行我素购物管理系统 > 幸运抽奖");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入4位会员号：");
        int vipId = scanner.nextInt();
        // 计算输入会员号的百位
        int num = vipId / 100 % 10;
        // 随机生成一个[0,9]的整数
        int random = (int) (Math.random() * 10);
        if (num == random) {
            System.out.println(vipId + "号VIP用户，恭喜你中奖了，获得宇宙无敌第一称号");
        } else {
            System.out.println(vipId + "号VIP用户，恭喜你没中奖");
        }
    }

    public void test2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您的成绩：");
        int score = scanner.nextInt();
        if (score > 90) {
            System.out.println("成绩为A");
        } else if (score > 80) {
            System.out.println("成绩为B");
        } else {
            System.out.println("成绩太垃跨了");
        }
    }

    public void test3() {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[3];
        int numMax = Integer.MIN_VALUE;
        int numMin = Integer.MAX_VALUE;
        System.out.println("请输入3个数用于比较大小");
        for (int i = 0; i < 3; i++) {
            int temp = scanner.nextInt();
            nums[i] = temp;
            numMax = numMax < temp ? temp : numMax; // or Math.max(numMax, temp);
            numMin = numMin > temp ? temp : numMin;
        }
        System.out.println("这3个数中最大的是：" + numMax);
        System.out.println("这3个数中最小的是：" + numMin);
    }

    public void test4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个数和一个操作符(如3 4 *)：");
        int d1 = scanner.nextInt();
        int d2 = scanner.nextInt();
        String o = scanner.next();
        double result = 0;
        switch (o) {
            case "+":
                result = d1 + d2;
                break;
            case "-":
                result = d1 - d2;
                break;
            case "*":
                result = d1 * d2;
                break;
            case "/":
                result = (double) d1 / (double) d2;
                break;
            case "^":
                result = (int) Math.pow(d1, d2);
                break;
            default:
                System.out.println("操作符有误！");
                return;
        }
        System.out.println(d1 + o + d2 + "=" + result);
    }

    public static void main(String[] args) {
        HomeWork0601 homeWork0601 = new HomeWork0601();
        System.out.println("================test1==============");
        homeWork0601.test1();
        System.out.println("================test2==============");
        homeWork0601.test2();
        System.out.println("================test3==============");
        homeWork0601.test3();
        System.out.println("================test4==============");
        homeWork0601.test4();





//        Scanner scanner = new Scanner(System.in);
//        int i = 0;
//
//        while (true) {
//            boolean flag = scanner.hasNextInt();
//            if (!flag) {
//                // 判斷輸入的是否是整數
//                i = scanner.nextInt();
//                // 接收整數
//                System.out.println("输入为：" + i);
//                break;
//            } else {
//                // 輸入錯誤的信息
//                System.out.println("输入的不是整数！");
//            }
//        }
//        System.out.println("请输入一个整数：");
//        int value = checkInput(scanner);
//        System.out.println(value);

        double num1 = 9.999999999998;
        double num2 = 9.999999999999;
        System.out.println(num1 == num2);
    }


    public static void checkInput() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        int i = 0;
        while (!flag) {
            flag = scanner.hasNextInt();
            System.out.println("flag:" + flag);
            if (flag) {
                i = scanner.nextInt();
                System.out.println(i);
            } else {
                System.out.println("您输入的不是数字");
            }
            scanner.next();
        }
    }

    public static int checkInput(Scanner input) {
        int value = 0; // 键盘录入的值
        boolean flag = true; // 检测是不是int类型 默认是false;
        do {
            if (!input.hasNextInt()) {
                System.out.println("您输入的有误，请输入一个整数：");
                input.next();
                flag = false;
            } else {
                value = input.nextInt();
            }

        } while (!flag);
        return value;
    }
}
