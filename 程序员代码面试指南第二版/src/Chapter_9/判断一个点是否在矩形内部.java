package Chapter_9;

/**
 * @ Author: MingHuiFan
 * @ Date: 2021/3/16 - 18:08
 * @ Description: 第9章_其他题目
 * @ Version: 1.0
 */
public class 判断一个点是否在矩形内部 {

    // 矩形平行于 x-y 轴情况
    private static boolean isInside(double x1, double y1, double x4, double y4, double x, double y) {
        return !(x < x1) && !(x > x4) && !(y < y1) && !(y > y4);    // 只有都满足才返回真
    }

    private static boolean isInside(double x1, double y1, double x2, double y2,
                                    double x3, double y3, double x4, double y4, double x, double y) {
        if (y1 == y2) {
            return isInside(x1, y1, x4, y4, x, y);
        }
        double l = Math.abs(y4 - y3);   // 直角边1
        double k = Math.abs(x4 - x3);   // 直角边2
        double s = Math.sqrt(l*l + k*k);    // 斜边
        double sin = l / s;
        double cos = k / s;
        // 变化后的坐标公式
        // x' = cos * x + sin * y
        // y' = -sin * x + cos * y  就是 x' 求导即可
        double x11 = cos * x1 + sin * y1;   // 变化后的 x 坐标
        double y11 = -sin * x1 + cos * y1;  // 变化后的 y 坐标（x11求导即可）
        double x44 = cos * x4 + sin * y4;
        double y44 = -sin * x4 + cos * y4;
        double xx = cos * x + sin * y;
        double yy = -sin * x + cos * y;
        return isInside(x11, y11, x44, y44, xx, yy);
    }

    public static void main(String[] args) {
        System.out.println(isInside(0,0,5,5,1,4));
    }
}
