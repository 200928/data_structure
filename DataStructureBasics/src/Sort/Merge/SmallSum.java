package Sort.Merge;

import tools.Asserts;
import tools.Times;

import java.util.Arrays;
import java.util.Random;

/**
 * @ Author: MingHuiFan
 * @ Date: 2021/3/8 - 18:16
 * @ Description: Sort.Merge
 * @ Version: 1.0
 */

// 小和问题
public class SmallSum {
    // 小和问题求解函数
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    // 递归过程
    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 2);
        int left = mergeSort(arr, l, mid);  // 左边小和
        int right = mergeSort(arr, mid + 1, r); // 右边小和
        int sum = merge(arr, l, mid, r);    // 左右合并求小和
        return left + right + sum;
    }

    // 左右两边排序并返回此次左右两边的小和
    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];    // 辅助数组
        int left = l;
        int right = m + 1;
        int i = 0;
        int res = 0;
        // 如果左边不越界并且右边不越界
        while (left <= m && right <= r) {
            res += arr[left] < arr[right] ? arr[left] * (r - right + 1) : 0;
            // 小->大排序 并且 相等要移右边
            help[i++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
        }
        // 下面两个 while 循环只会进入其一
        while (left <= m) {
            help[i++] = arr[left++];
        }
        while (right <= r) {
            help[i++] = arr[right++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }

    // 暴力求解小和
    public static int force(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    res += arr[i];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int testSum = 10000000;   // 测试的次数

        // Times测试时间工具
        Times.test("小和计算", () -> {
            for (int test = 0; test < testSum; test++) {
                int sum = 100;  // 数组的大小
                int[] arr0 = new int[sum];
                for (int i = 0; i < arr0.length; i++) {
                    arr0[i] = new Random().nextInt(500);
                }
                int[] arr1 = Arrays.copyOf(arr0, arr0.length);
                Asserts.test(force(arr0) == smallSum(arr1));
//                System.out.println(Arrays.toString(arr0));
//                System.out.println(Arrays.toString(arr1));
//                System.out.println("递归求小和：" + smallSum(arr0));
//                System.out.println("暴力求小和：" + force(arr1));
            }
        });
    }
}
