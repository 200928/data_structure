package com.mh;

import java.util.Scanner;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/12/14 - 21:54
 * @ Description: com.mh
 * @ Version: 1.0
 */
public class TArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split("\\s+");
        Integer[] integers = new Integer[strings.length];

        int min = Integer.MIN_VALUE;
        int minIndex = -1;
        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
            min = (i == 0) ? integers[0] : min;
            minIndex = (min > integers[i]) ? i : minIndex;
        }
        int tmp = integers[0];
        integers[0] = integers[minIndex];
        integers[minIndex] = tmp;
        for (int st : integers) {
            System.out.print(st + " ");
        }
    }
}
