package Sort.Quick;

import java.util.Arrays;
import java.util.Random;

/**
 * @ Author: MingHuiFan
 * @ Date: 2021/3/9 - 15:02
 * @ Description: Sort.Quick
 * @ Version: 1.0
 */
public class DutchFlagIssue {
    public static void dutchflagissue1(int[] arr, int num) {
        int left = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {    // 如果小于等于
                int tmp = arr[i];
                arr[i] = arr[left + 1];
                arr[left + 1] = tmp;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int sum = 10;
        int[] arr = new int[sum];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10);
        }
        System.out.println(Arrays.toString(arr));
        dutchflagissue1(arr, 5);
        System.out.println(Arrays.toString(arr));


    }
}
