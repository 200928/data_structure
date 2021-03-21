package Chapter_9其他问题;

/**
 * @ Author: MingHuiFan
 * @ Date: 2021/3/18 - 18:52
 * @ Description: Chapter_9
 * @ Version: 1.0
 */
public class BitArr {

    // 加入数组中一共有 N 个数，每个数占 4 字节
    // 共有 4N Byte = 4N*8 bit

    /**
     * 改变第 index 位的 0 1
     * @param arr
     */
    static int bitarr(int[] arr, int index) {
        int numIndex = index / 32;  // 定位到数组的哪一位
        int bitIndex = index % 32;  // 定位在该数的第多少位
        int bit = (arr[numIndex] >> bitIndex) & 1;  // 拿到第 index 位的状态
        arr[numIndex] = arr[numIndex] | (1 << bitIndex);    // 将 index 位的数修改为 1
//        arr[numIndex] = arr[numIndex] & (~(1 << bitIndex));   // 将 index 位的数修改为 0

        // 总结：取得第 i 位的 0/1 状态 int bit = (arr[i / 32] >> (i % 32)) & 1
        return bit;
    }

    // 打印二进制数
    static void test1() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int sum = 0;
        for (int i = 0; i < 192; i++) {
            System.out.print(bitarr(arr, i));
            if (sum++ % 32 == 31) {
                System.out.println();
            }
        }
    }

    // 一位一位的改变, 下面写法省略了前面 28 个0
    // 1 0001   0~31
    // 2 0010   32~63
    // 3 0011   64~95
    // 4 0100   96~127
    static void test2() {
        int[] arr = {1, 2, 3, 4};
        bitarr(arr, 1);
        bitarr(arr, 32);
        bitarr(arr, 66);
        bitarr(arr, 96);
        for (int i : arr) {
            System.out.print(i + "_");
        }

    }

    public static void main(String[] args) {
        test1();
        test2();
    }

}

/** out
 * 10000000000000000000000000000000
 * 01000000000000000000000000000000
 * 11000000000000000000000000000000
 * 00100000000000000000000000000000
 * 10100000000000000000000000000000
 * 01100000000000000000000000000000
 * 3_3_7_5_
 */
