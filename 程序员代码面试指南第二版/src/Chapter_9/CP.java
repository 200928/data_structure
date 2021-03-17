package Chapter_9;

/**
 * @ Author: MingHuiFan
 * @ Date: 2021/3/16 - 21:45
 * @ Description: Chapter_9
 * @ Version: 1.0
 */
public class CP {

    static int C(int x, int y) {
        int up = x;
        int down = 1;
        for (int i = 1; i <= y; i++) {
            down *= i;
        }
        for (int i = x - 1; i > x - y; i--) {
            up *= i;
        }
        System.out.println(up);
        System.out.println(down);
        return up / down;
    }

    public static void main(String[] args) {
        System.out.println(C(47, 27));
    }

}
