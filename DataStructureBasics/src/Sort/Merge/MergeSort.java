package Sort.Merge;

import java.util.Random;

/**
 * @ Author: MingHuiFan
 * @ Date: 2021/3/8 - 15:05
 * @ Description: Sort
 * @ Version: 1.0
 */

/**
 * 时间复杂度分析
 *  T(N) = a * T(N/b) + O(N^d)
 *  T(N) = 2 * T(N/2) + O(N)
 *  log(a,b) == d   ->  O(N) = O(N*logN)
 * 空间复杂度：O(N)
 */
public class MergeSort {

    // 注意 R 是数组最后一个下标，不是下标加一
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 2);
        process(arr, L, mid);   // 左边排序
        process(arr, mid + 1, R);   // 右边排序
        merge(arr, L, mid, R);  // 整合
        return;
    }

    // 注意这里 R 是数组最后一个下标，不是下标加一
    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int left = L;
        int right = M + 1;
        while (left <= M && right <= R) {
            help[i++] = arr[left] <= arr[right] ? arr[left++] : arr[right++];
        }
        while (left <= M) {
            help[i++] = arr[left++];
        }
        while (right <= R) {
            help[i++] = arr[right++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return;
    }

    public static void main(String[] args) {
        int[] arr = new int[new Random().nextInt(51) + 50]; // 数组大小区间 [50, 100]
        for (int i = 0; i <arr.length; i++) {
            arr[i] = new Random().nextInt(100) + 100;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "_");
        }
        System.out.println(arr.length);
        process(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "_");
        }
    }
}
