package com.mh.homework;

import com.mh.utils.CheckInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/6/6 - 下午11:00
 * @ Description: com.mh
 * @ Version: 1.0
 */
public class HomeWork0606 {
    // 猜数游戏
    public void guessingGame() {
        int[] array = new int[]{8, 4, 2, 1, 344, 12};
        System.out.print("请输入一个数，判断是否在数列中：");
        Scanner scanner = new Scanner(System.in);
        int n = CheckInput.isInputInt(scanner);
        boolean flag = false;
        System.out.print("数列为：");
        int sum = 0; // 保存数组和
        for (int item : array) {
            if (item == n) {
                flag = true;
            }
            sum += item;
            System.out.print(item + " ");
        }
        System.out.println("数列的和为：" + sum);
        System.out.println("该数(" + n + (flag ? ")在数列中" : ")不再数列中"));
    }

    // 获取最低手机价格
    public void lowPhonePrice() {
        int[] prices = new int[4];
        int min = Integer.MAX_VALUE; // 用来求最低价格
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入4家店的价格");
        for (int i = 0; i < prices.length; i++) {
            System.out.print("第" + (i + 1) + "家店的价格：");
            prices[i] = CheckInput.isInputInt(scanner);
            min = min > prices[i] ? prices[i] : min;
        }
        System.out.println("最低价格是：" + min);
    }

    // 插入数值，学员成绩{99,85,82,63,60}，将它们按降序排列
    // 要增加一个学员的成绩，将它插入成绩序列，并保持降序
    public void insertValue() {
        ArrayList<Integer> integers = new ArrayList<>();
        int[] scores = new int[]{99, 85, 82, 63, 60};
        IntStream.rangeClosed(0, scores.length - 1).parallel().forEachOrdered(i -> {
            integers.add(scores[i]);
        });
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入新增成绩：");
        int newScore = CheckInput.isInputInt(scanner);
        int index = integers.size();
        int length = integers.size();
        for (int i = 0; i < length; i++) {
            if (newScore > integers.get(i)) {
                // index 记录插入的位置，index 位置后全部右移
                index = i;
                break;
            }
        }
        integers.add(-1);
        // 12 34 56 0   length=4
        //      0
        for (int i = length - 1; i >= index; i--) {
            integers.set(i+1, integers.get(i));
        }
        integers.set(index, newScore);
        System.out.println(integers.toString());
    }

    // 数组存储5笔购物金额，输出总金额
    public void shop() {
        double[] shops = new double[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入会员本月的消费记录");
        double sum = 0;
        for (int i = 0; i < shops.length; i++) {
            System.out.print("请输入第" + (i + 1) + "笔购物金额：");
            shops[i] = CheckInput.isInputDouble(scanner);
            sum += shops[i];
        }
        // 对结果输出
        System.out.println("序号" + "\t\t金额(元)");
        for (int i = 0; i < shops.length; i++) {
            System.out.println((i + 1) + "\t\t" + shops[i]);
        }
        System.out.println("总金额\t" + sum);
    }

    // 判断回文数
    public void numberOfPalindromes() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数判断是否是回文数：");
        int num = CheckInput.isInputInt(scanner);
        // 两面夹击法
        char[] s = String.valueOf(num).toCharArray();
        boolean flag = true;
        // 12344321
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            if (s[i] != s[j]) {
                flag = false;
                break;
            }
        }
        System.out.println(num + (flag ? "是回文数" : "不是回文数"));
    }

    // 删除数
    public void deleteNumber() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner scanner = new Scanner(System.in);
        // 需要删除的数
        int num = CheckInput.isInputInt(scanner);
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (!flag && array[i] == num) {
                flag = true; // 找到了设置为 true
            }
            // 如果找到(flag为真)，下面删除 i 位置元素，[i+1,array.length)前移一位，最后一位置0
            array[i] = flag ? array[i + 1] : array[i];
        }
        if (!flag && array[array.length - 1] != num) {
            System.out.println("数组中没有这个数！");
            return;
        }
        array[array.length - 1] = 0;
        System.out.println(Arrays.toString(array));
    }

    // 删除数
    public void deleteNumbe1() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner scanner = new Scanner(System.in);
        // 需要删除的数
        System.out.print("请输入要删除的数：");
        int num = CheckInput.isInputInt(scanner);
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                index = i;
            }
            // 如果找到(flag为真)，下面删除 i 位置元素，[i+1,array.length)前移一位，最后一位置0
        }
        if (-1 != index) {
            int i;
            for (i = index + 1; i < array.length; i++) {
                array[i - 1] = array[i];
            }
            array[i - 1] = 0;
        } else {
            System.out.println("数组中没有这个数！");
            return;
        }
        System.out.println(Arrays.toString(array));
    }

    // 反转数组，并处理，偶数替换为2
    public void reverseArray() {
        int[] array = new int[]{5, 82, 3, 88, 6, 9};
        int[] newArray = new int[array.length];
        int index = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[index++] = (0 == array[i] % 2) ? 2 : array[i];
        }
        System.out.println("原数组：" + Arrays.toString(array));
        System.out.print("逆序并处理后的数组为：");
        System.out.println(Arrays.toString(newArray));
    }

    public static void main(String[] args) {
        HomeWork0606 homeWork0606 = new HomeWork0606();
//        homeWork0606.guessingGame();
//        homeWork0606.lowPhonePrice();
        homeWork0606.insertValue();
//        homeWork0606.shop();
//        homeWork0606.numberOfPalindromes();
//        homeWork0606.deleteNumber();
//        homeWork0606.deleteNumbe1();
//        homeWork0606.reverseArray();
    }
}
