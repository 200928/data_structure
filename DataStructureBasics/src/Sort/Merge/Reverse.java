package Sort.Merge;

import tools.Asserts;
import tools.Times;

import java.util.Arrays;
import java.util.Random;

/**
 * @ Author: MingHuiFan
 * @ Date: 2021/3/9 - 12:30
 * @ Description: Sort.Merge
 * @ Version: 1.0
 */

// 逆序对数量
public class Reverse {

    public static int reverse(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 2);
        int L = mergeSort(arr, l, mid);
        int R = mergeSort(arr, mid + 1, r);
        int sum = merge(arr, l, mid, r);
        return L + R + sum;
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int ans = 0;
        int left = l;
        int right = m + 1;
        int i = 0;
        while (left <= m && right <= r) {
            ans += arr[left] > arr[right] ? r - right + 1 : 0;
            // 大->小排序 并且 相等要先移右边
            help[i++] = arr[left] > arr[right] ? arr[left++] : arr[right++];
        }
        // 把未排好的排好
        while (left <= m) {
            help[i++] = arr[left++];
        }
        while (right <= r) {
            help[i++] = arr[right++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return ans;
    }

    // 暴力求解
    public static int force(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int testSum = 10000000;
        Times.test("逆序数", () -> {
            for (int test = 0; test < testSum; test++) {
                int sum = 5;
                int[] arr0 = new int[sum];
                for (int i = 0; i < sum; i++) {
                    arr0[i] = new Random().nextInt(51) + 50;
                }
                int[] arr1 = Arrays.copyOf(arr0, arr0.length);
                Asserts.test(reverse(arr0) == force(arr1));
//                System.out.println(Arrays.toString(arr0));
//                System.out.println(Arrays.toString(arr1));
//                System.out.print(force(arr0) + "_" + reverse(arr1) + '\n');

            }
        });
    }
}

