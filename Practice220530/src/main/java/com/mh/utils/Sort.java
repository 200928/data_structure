package com.mh.utils;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/6/7 - 上午9:17
 * @ Description: com.mh.utils
 * @ Version: 1.0
 */
public class Sort {
    // 3 4 2 5 0
    public static void bubbleSort(Integer[] e) {
        // 比较伦次为：长度-1
        for (int i = e.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                // 如果前一个小于后一个，交换，则为降序
                if (e[j] < e[j+1]) {
                    int temp = e[j];
                    e[j] = e[j+1];
                    e[j+1] = temp;
                }
            }
        }
    }
}
