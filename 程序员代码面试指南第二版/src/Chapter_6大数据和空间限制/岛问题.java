package Chapter_6大数据和空间限制;

import java.util.Random;

/**
 * @ Author: MingHuiFan
 * @ Date: 2021/3/19 - 10:21
 * @ Description: Chapter_6大数据和空间限制
 * @ Version: 1.0
 */
public class 岛问题 {

    // 时间复杂度 O(r*c)
    public static int contIslands(int[][] m) {
        int r = m.length;
        int c = m[0].length;
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, r, c);
                }
            }
        }
        return res;
    }

    // 感染过程
    public static void infect(int[][] m, int i, int j, int r, int c) {
        if (i < 0 || i >= r || j < 0 || j >= c || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        infect(m, i + 1, j, r, c);
        infect(m, i - 1, j, r, c);
        infect(m, i, j + 1, r, c);
        infect(m, i, j - 1, r, c);
    }

    public static void main(String[] args) {
        int r = 5;
        int c = 10;
        int[][] m = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = (int)(2 * Math.random());
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(contIslands(m));
    }

}
