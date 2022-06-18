package com.mh.homework;

import java.util.Scanner;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/6/2 - 下午5:19
 * @ Description: com.mh
 * @ Version: 1.0
 */
public class HomeWork0602 {
    // 100 以内偶数和
    public void homeWork1_for() {
        System.out.println("===========homeWork1_for============");
        int sum = 0;
        for (int i = 2; i <= 100; i += 2) {
            sum += i;
        }
        System.out.println("for-100" + "偶数和是：" + sum);
    }

    public void homeWork1_while() {
        System.out.println("===========homeWork1_while============");
        int sum = 0;
        int i = 0;
        while (i <= 100) {
            sum += i;
            i += 2;
        }
        System.out.println("while-100" + "偶数和是：" + sum);
    }

    public void homeWork1_doWhile() {
        System.out.println("===========homeWork1_doWhile============");
        int sum = 0;
        int i = 2;
        do {
            sum += i;
            i += 2;
        } while (i <= 100);
        System.out.println("doWhile-100" + "偶数和是：" + sum);
    }

    public static int isInputInt(Scanner scanner) {
        int num = 0;
        boolean flag = false;
        while (!flag) {
            // 如果是整数 flag=true，否则为 false
            flag = scanner.hasNextInt();
            // 如果是整数
            if (flag) {
                num = scanner.nextInt();
            } else {
                System.out.print("您输入的不是整数，请重新输入：");
                scanner.nextLine();
            }
        }
        return num;
    }

    // 水仙花数，如 153 = 1^3 + 5^3 + 3^3
    public void homeWork2() {
        System.out.println("===========homeWork2============");
        System.out.print("请输入一个三位整数，判定其是否为水仙花数：");
        Scanner scanner = new Scanner(System.in);
        int num = isInputInt(scanner);
        int cubeAndNum = 0;
        int _num = num;
        while (_num > 0) {
            cubeAndNum += Math.pow(_num % 10, 3);
            _num /= 10;
        }
        System.out.println(num + (num == cubeAndNum ? "是水仙花数" : "不是水仙花数"));
    }

    public void homeWork3() {
        System.out.println("===========homeWork3============");
        StringBuffer further = new StringBuffer("前进一步的学生序号有：");
        StringBuffer back = new StringBuffer("后退一步的学生序号有：");
        for (int i = 1; i <= 38; i++) {
            // 这是报数为 1 的同学，前进一步
            if (1 == i % 3) {
                further.append(i).append(" ");
            } else if (2 == i % 3) { // 这是报数为 2 的同学，后退一步
                back.append(i).append(" ");
            }
        }
        System.out.println(further);
        System.out.println(back);
    }

    // 求出 200~300之间的数，且满足条件，它们 3 个数字之积为 42，三个数字之和为 12
    public void homeWork4() {
        System.out.println("===========homeWork4============");
        int begin = 200;
        int end = 300;
        for (; begin <= end; begin++) {
            int temp = begin;
            int accumulate = 1; // 保存积
            int sum = 0; // 保存和
            // 循环计算积和和
            while (temp > 0) {
                int cur = temp % 10;
                accumulate *= cur;
                sum += cur;
                temp /= 10;
            }
            if (42 == accumulate && 12 == sum) {
                System.out.print(begin + " ");
            }
        }
    }

    // 假设一张纸厚度 0.5mm，对折多少次达到 8843.43m
    public void homeWork5() {
        System.out.println("===========homeWork5============");
        int count = 0;
        double thickness = 0.5; // 厚度，初始为一张纸厚度
        double aims = 8843430;
        while (thickness < aims) {
            count++;
            thickness += thickness;
            System.out.println("第" + count + "次对折的厚度变为：" + thickness + "mm");
        }
        System.out.println("需要对折" + count + "次能达到 8843.43m");
        // log[2]
        System.out.println(Math.ceil(Math.log(8843430) / Math.log(2)) + 1);
    }

    public void homeWork6() {
        System.out.println("===========homeWork6============");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数a(用于计算s=a+aa+...aa.aa)：");
        int a = isInputInt(scanner);
        int s = a;
        StringBuffer stringBuffer = new StringBuffer("s=");
        stringBuffer.append(a).append("+");
        int temp = a;
        for (int i = 2; i <= a; i++) {
            temp = temp * 10 + a;
            s += temp;
            stringBuffer.append(temp).append(i == a ? "=" : "+");
        }
        stringBuffer.append(s);
        System.out.println(stringBuffer);
    }

    public static void main(String[] args) {
        HomeWork0602 homeWork0602 = new HomeWork0602();
//        homeWork0602.homeWork1_for();
//        homeWork0602.homeWork1_while();
//        homeWork0602.homeWork1_doWhile();
//        homeWork0602.homeWork2();
        homeWork0602.homeWork3();
//        homeWork0602.homeWork4();
//        homeWork0602.homeWork5();
//        homeWork0602.homeWork6();
        for (int i = 1, j = 2; i <= 38; i += 3, j += 3) {
            System.out.print("前进" + i);
            System.out.print("后退" + j);
        }
        /*
        # Generated by NetworkManager
                nameserver 211.69.244.1
                nameserver 211.69.224.3

         */
    }
}
