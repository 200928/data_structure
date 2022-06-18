package com.ming.utils;

import java.util.Scanner;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/6/5 - 下午3:43
 * @ Description: com.mh.utils
 * @ Version: 1.0
 */
public class CheckInput {
    public static double isInputDouble(Scanner scanner) {
        double num = 0;
        boolean flag = false;
        while (!flag) {
            // 如果是整数 flag=true，否则为 false
            flag = scanner.hasNextDouble();
            // 如果是整数
            if (flag) {
                num = scanner.nextDouble();
            } else {
                System.out.print("您输入的不是小数，请重新输入：");
                scanner.nextLine();
            }
        }
        return num;
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
                scanner.next();
            }
        }
        return num;
    }

    // 判断数字是否在 [begin,end] 之间
    public static int isInputIntAndTime(Scanner scanner, int begin, int end) {
        int num = 0;
        boolean flag = false;
        while (!flag) {
            // 如果是整数 flag=true，否则为 false
            flag = scanner.hasNextInt();
            // 如果是整数
            if (flag) {
                num = scanner.nextInt();
                if (num < begin || num > end) {
                    flag = false;
                    System.out.print("送餐时间有误，请重新输入：");
                }
            } else {
                System.out.print("您输入的不是整数，请重新输入：");
                scanner.nextLine();
            }
        }
        return num;
    }

    public static int isInputIntAndNumber(Scanner scanner, int begin, int end) {
        int num = 0;
        boolean flag = false;
        while (!flag) {
            // 如果是整数 flag=true，否则为 false
            flag = scanner.hasNextInt();
            // 如果是整数
            if (flag) {
                num = scanner.nextInt();
                if (num > end) {
                    flag = false;
                    System.out.print("真牛皮，点那么多，小店破产了，请您重新输入：");
                } else if (num < begin) {
                    flag = false;
                    System.out.print("怎么滴，还想入股？不想拖累你：");
                }
            } else {
                System.out.print("您输入的不是整数，请重新输入：");
                scanner.nextLine();
            }
        }
        return num;
    }
}
