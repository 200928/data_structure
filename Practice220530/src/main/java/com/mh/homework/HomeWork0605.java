package com.mh.homework;

import com.mh.utils.CheckInput;

import java.util.Scanner;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/6/5 - 上午9:25
 * @ Description: com.mh
 * @ Version: 1.0
 */
public class HomeWork0605 {

    /**
     * 使用循环输出如下图形
     */
    // 输入矩形
    public void printRectangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输出一个数，作为矩形的长度：");
        int n = CheckInput.isInputInt(scanner);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 输入菱形
    public void printDiamond() {
        System.out.print("输出一个数，作为菱形的长度：");
        Scanner scanner = new Scanner(System.in);
        int n = CheckInput.isInputInt(scanner);
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k < n; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 输出三角形
    public void printTriangle() {
        // 1 3 5 7 2n-1
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 空白数 n
        // n = 5
        // 1 3 5 7 9
        // *********
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 输出九九乘法表
    public void multiplicationTable() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + "    ");
            }
            System.out.println();
        }
    }

    // 使用循环输出 100 95 90 85...5
    public void arrayDisplay() {
        int n = 100;
        while (n >= 5) {
            System.out.print(n + " ");
            n -= 5;
        }
    }

    // 循环录入某学生5门课的成绩并计算平均分，如果某分数录入为负数，停止录入并提示录入错误
    public void entryInformation() {
        System.out.print("请输入学生姓名：");
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        int[] scores = new int[5];
        // 用来保存5门成绩
        double scoreSum = 0;
        for (int i = 0; i < scores.length; i++) {
            System.out.print("请输入第" + (i + 1) + "门课的成绩：");
            scores[i] = scanner.nextInt();
            if (scores[i] < 0) {
                System.out.println("录入停止，原因是您输入的成绩为负数，违背了分数不能为负的标准");
                return;
            }
            scoreSum += scores[i];
        }
        System.out.println("平均成绩为：" + scoreSum / 5);
    }

    // 循环录入Java课的学生成绩，统计分数大于等于80分的学生比例
    public void entryInformationJava() {
        Scanner scanner = new Scanner(System.in);
        // 保存班级人数
        int n = CheckInput.isInputInt(scanner);
        int count = 0;
        for (int i = 1; i <= n; i++) {
            System.out.println("请输入第" + i + "位学生的Java成绩：");
            int temp = CheckInput.isInputInt(scanner);
            if (temp <= 80) continue;
            count++;
        }
        System.out.println("80分以上的学生人数是：" + count);
        System.out.println("80分以上的学生人数占的比例为：" + 100.0 * count / n + "%");
    }

    // 从键盘输入一位整数，当输入 1-7 时，输入 “星期一”~“星期日”
    public void weekDisplay() {
        Scanner scanner = new Scanner(System.in);
        // 记录是否输入了 0
        boolean flag = true;
        while (flag) {
            System.out.print("请输入一个 1-7 之间的数，输入0退出程序：");
            int num = CheckInput.isInputInt(scanner);
            if (num < 0 || num > 7) {
                System.out.println("输入有错误，请重新输入：");
                continue;
            }
//            flag = num != 0;
            switch (num) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    System.out.println("星期一");
                    break;
                case 2:
                    System.out.println("星期二");
                    break;
                case 3:
                    System.out.println("星期三");
                    break;
                case 4:
                    System.out.println("星期四");
                    break;
                case 5:
                    System.out.println("星期五");
                    break;
                case 6:
                    System.out.println("星期六");
                    break;
                case 7:
                    System.out.println("星期天");
                    break;
                default:
                    break;
            }
        }
    }

    /*
           1
          222
         33333
        4444444
       555555555
      66666666666
     7777777777777
    888888888888888 */
    public void pyramidDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("您要几行数字：");
        int n = CheckInput.isInputInt(scanner);
        // 最外层为 n 次循环，这里初始 i=n 是内循环比较好操作
        for (int i = n; i > 0; i--) {
            // 输出的数字
            int outNum = n - i + 1;
            // 空格的数量，最顶层空格数为最底层中间数少一（最底层为 2n-1，中间数为 n，故空格数为 n-1）
            for (int j = 0; j < i - 1; j++) {
                System.out.print(" ");
            }
            // 输出的数字个数为 1,3,5,7,..2n-1
            for (int k = 0; k < 2 * (n - i + 1) - 1; k++) {
                System.out.print(outNum);
            }
            System.out.println();
        }
    }

    /* 输出
    如输入 4
       *
      ***
     *****
    *******
     *****
      ***
       *
     */
    public void diamondDisplay() {
        Scanner scanner = new Scanner(System.in);
        int N = CheckInput.isInputInt(scanner);
        for (int i = N; i > 0; i--) {
            // 输出上部分空格
            for (int j = 0; j < i - 1; j++) {
                System.out.print(" ");
            }
            // 输出上部分 * 号
            for (int k = 0; k < 2 * (N - i + 1) - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 输出下部分
        for (int i = 1; i < N; i++) {
            // 输出下部分前置空格
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // 输出下部分 * 号
            for (int k = 2 * (N - i) - 1; k > 0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 啤酒 2.3 元，饮料 1.9 元，一共买了 82.3 元，分别买了多少
    public void buyDrinks() {
        double beer = 2.3;
        double drink = 1.9;
        double price = 82.3;
        // i 啤酒，j 饮料，前提 i<j
        for (int i = 1; i <= Math.floor(price / beer); i++) {
            // j = i 保证了啤酒比饮料少
            for (int j = i + 1; j <= Math.floor(price / drink); j++) {
                double temp = i * beer + j * drink;
                if (Math.abs(temp - price) < 10e-6) {
                    System.out.println("买了" + i + "瓶啤酒，" + j + "瓶饮料");
                }
            }
        }
    }

    // 求小明两个妹妹的年龄，年龄之积是年龄之和的 6 倍，且相差不超过 8 岁
    public void askForAge() {
        label:
        {
            for (int minAge = 1; ; minAge++) {
                for (int maxAge = minAge; maxAge <= minAge + 8; maxAge++) {
                    if (minAge * maxAge == 6 * (minAge + maxAge)) {
                        System.out.println("小明的两个妹妹年龄分别是：" + minAge + "," + maxAge);
                        break label;
                    }
                }
            }
        }
    }

    // 停车场汽车(4轮子)、摩托车(3轮子)共 48 辆，共有 172 个轮子
    public void calculateTheNumberOfCars() {
        int cars = 48;
        int wheel = 172;
        for (int car = 0; car < wheel / 4; car++) {
            for (int motorcycle = 0; motorcycle < wheel / 3; motorcycle++) {
                if ((car + motorcycle == 48) && (car * 4 + motorcycle * 3 == 172)) {
                    System.out.println("汽车和摩托车分别为：" + car + "," + motorcycle);
                }
            }
        }
    }

    // 一个整数，它加上 100 是一个完全平方数，再加上 168 又是一个完全平方数，找出 10000 以内的满足条件的数
    public void perfectSquare() {
        System.out.print("满足条件的数有：");
        for (int i = 0; i <= 10000; i++) {
            // 如果加上 100 是完全平方数，且再加 168 是完全平方数
            if (isPerfectSquare(i + 100) && isPerfectSquare(i + 100 + 168)) {
                System.out.print(i + " ");
            }
        }
    }

    public boolean isPerfectSquare(int num) {
        int cur = 1;
        while (num > 0) {
            num -= cur;
            cur += 2;
        }
        return 0 == num;
    }

    public void perfectSquare1() {

    }

    public static void main(String[] args) {
        HomeWork0605 homeWork0605 = new HomeWork0605();
//        homeWork0605.printTriangle();
//        homeWork0605.printDiamond();
//        homeWork0605.printRectangle();
//        homeWork0605.multiplicationTable();
//        homeWork0605.arrayDisplay();
//        homeWork0605.entryInformation();
//        homeWork0605.weekDisplay();
//        homeWork0605.pyramidDisplay();
//        homeWork0605.diamondDisplay();
//        homeWork0605.buyDrinks();
//        homeWork0605.askForAge();
//        homeWork0605.calculateTheNumberOfCars();
        homeWork0605.perfectSquare();
//        System.out.println(2.3 * 11);
//        System.out.println(1.9 * 30);
//        System.out.println(2.3 * 11 + 1.9 * 30);
//        System.out.println(3.8 % 1.9);
//        System.out.println(5.7 % 1.9);
//        System.out.println(57.0 % 1.9);
//        System.out.println(5.7 % 1.9 < 10e-6);
    }
}
