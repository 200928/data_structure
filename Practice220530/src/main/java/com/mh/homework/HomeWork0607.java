package com.mh.homework;

import com.mh.utils.CheckInput;
import com.mh.utils.Integers;
import com.mh.utils.Sort;
import com.mh.utils.Times;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/6/7 - 上午9:28
 * @ Description: com.mh
 * @ Version: 1.0
 */
public class HomeWork0607 {
    public void test() {
        Integer[] array = Integers.random(100000, -10000, 10000);
        Integer[] array1 = Integers.copy(array);
        Times.test("快排", () -> {
            assert array != null;
            Arrays.sort(array, Collections.reverseOrder());
        });
        Times.test("手写冒泡", () -> {
            Sort.bubbleSort(array1);
        });
    }

    // 冒泡排序成绩
    public void bubbleSortScore() {
        int[] scores = new int[5];
        Scanner scanner = new Scanner(System.in);
        // 输入分数保存在数组中
        System.out.print("请输入5名学生成绩：");
        IntStream.rangeClosed(0, scores.length - 1).forEachOrdered(i -> {
            scores[i] = CheckInput.isInputInt(scanner);
        });
        // 冒泡排序
        // 4  6  8  -6  9
        for (int i = scores.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (scores[j] < scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                }
            }
        }
        System.out.println("学员成绩按照降序排列为：" + Arrays.toString(scores));
    }

    // 字符数组排序和查找
    public void charSort() {
        char[] ch = new char[]{'a', 'b', '0', '1', '!', '{', '}'};
        Arrays.sort(ch);
        char c = 'b';
        int index = Arrays.binarySearch(ch, c);
        System.out.println(Arrays.toString(ch));
        System.out.println(c + "在字符数组的位置为" + index);
    }

    /*
    ************第1个班************
    请输入第1个学生的成绩：63
    请输入第2个学生的成绩：95
    请输入第3个学生的成绩：86
    请输入第4个学生的成绩：77
    请输入第5个学生的成绩：59
    ************第2个班************
    请输入第1个学生的成绩：100
    请输入第2个学生的成绩：63
    请输入第3个学生的成绩：69
    请输入第4个学生的成绩：74
    请输入第5个学生的成绩：99
    ************第3个班************
    请输入第1个学生的成绩：82
    请输入第2个学生的成绩：91
    请输入第3个学生的成绩：67
    请输入第4个学生的成绩：52
    请输入第5个学生的成绩：100
    1班总成绩：380
    2班总成绩：405
    3班总成绩：392
     */
    public void showStudentScore() {
        int[][] scores = new int[3][6];
        scores[0][5] = scores[1][5] = scores[2][5] = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("************第" + (i + 1) + "个班************");
            for (int j = 0; j < 5; j++) {
                System.out.print("请输入第" + (j + 1) + "个学生的成绩：");
                scores[i][j] = CheckInput.isInputInt(scanner);
                scores[i][5] += scores[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + "班总成绩：" + scores[i][5]);
        }
    }

    public static void main(String[] args) {
        HomeWork0607 homeWork0607 = new HomeWork0607();
//        homeWork0607.bubbleSortScore();
//        homeWork0607.charSort();
//        homeWork0607.showStudentScore();

        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        ArrayList<Integer> arrayList = new ArrayList<>(set);
        Iterator<Integer> iterator = arrayList.iterator();
        int[] a = new int[]{1, 2, -1, 3, 4};
        Arrays.stream(a).filter(i -> {
            if (i < 2) {
                return false;
            }
            return true;
        }).forEach(System.out::print);

//        while (iterator.hasNext()) {
//            iterator.next();
//            System.out.print(iterator.next() + " ");
//        }

//        int[] array = new int[]{3, 5, -9, 6, 8 ,1};
//        int[] array1 = Arrays.copyOf(array, array.length);
//        System.out.println(Arrays.toString(array1));
//        array[0] = 1;
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(array1));
//        System.out.println(Arrays.binarySearch(array, 1));
//        IntStream.rangeClosed(0, 5).parallel().forEachOrdered(i -> {
//            System.out.print(i);
//        });
//        System.out.println();
//        IntStream.rangeClosed(0, 5).parallel().forEach(i -> {
//            System.out.print(i);
//        });
    }
}
