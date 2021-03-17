package Chapter_9;

import java.util.Random;

/**
 * @ Author: MingHuiFan
 * @ Date: 2021/3/16 - 19:09
 * @ Description: Chapter_9
 * @ Version: 1.0
 */
public class 判断一个点是否在三角形内部 {

    // 两个点之间的距离
    private static double getSideLength(double x1, double y1, double x2, double y2) {
        double x = Math.abs(x1 - x2);
        double y = Math.abs(y1 - y2);
        return Math.sqrt(x * x + y * y);
    }

    // 计算三角形的面积
    private static double getArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double len1 = getSideLength(x1, y1, x2, y2);
        double len2 = getSideLength(x1, y1, x3, y3);
        double len3 = getSideLength(x2, y2, x3, y3);
        double p = (len1 + len2 + len3) / 2;
        return Math.sqrt((p - len1) * (p - len2) * (p - len3) * p);
    }

    // 法一 ：利用面积和
    private static boolean isInside1(double x1, double y1, double x2, double y2,
                                     double x3, double y3, double x, double y)  {
        // 大面积和
        double sMax = getArea(x1, y1, x2, y2, x3, y3);
        double s1 = getArea(x1, y1, x2, y2, x, y);
        double s2 = getArea(x1, y1, x3, y3, x, y);
        double s3 = getArea(x2, y2, x3, y3, x, y);
        return sMax >= s1 + s2 + s3;
    }

    // 计算两向量叉乘
    private static double crossProduct(double x1, double y1, double x2, double y2) {
        return x1 * y2 - x2 * y1;
    }

    // 法二 ：向量
    private static boolean isInside2(double x1, double y1, double x2, double y2,
                                     double x3, double y3, double x, double y) {
        if (crossProduct(x2 - x1, y2 - y1, x3 - x1, y3 - y1) < 0) {
            double tmp1 = x2;
            x2 = x3;
            x3 = tmp1;
            tmp1 = y2;
            y2 = y3;
            y3 = tmp1;
        }
        if (crossProduct(x2 - x1, y2 - y1, x - x1, y - y1) < 0) {
            return false;
        }
        if (crossProduct(x3 - x2, y3 - y2, x - x2, y - y2) < 0) {
            return false;
        }
        if (crossProduct(x1 - x3, y1 - y3, x - x3, y - y3) < 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int sum = 100000;
        int cot = 0;
        for (int i = 0; i < sum; i++) {
            double x1 = 1 + Math.random() * 10 % (10);
            double y1 = 1 + Math.random() * 10 % (10);
            double x2 = 1 + Math.random() * 10 % (10);
            double y2 = 1 + Math.random() * 10 % (10);
            double x3 = 1 + Math.random() * 10 % (10);
            double y3 = 1 + Math.random() * 10 % (10);
            double x = 1 + Math.random() * 10 % (10);
            double y = 1 + Math.random() * 10 % (10);
//            System.out.print(x1 + " ");
//            System.out.print(y1 + " ");
//            System.out.print(x2 + " ");
//            System.out.print(y2 + " ");
//            System.out.print(x3 + " ");
//            System.out.print(y3 + " ");
//            System.out.print(x + " ");
//            System.out.println(y + " ");
            if (isInside1(x1, y1, x2, y2, x3, y3, x, y) != isInside2(x1, y1, x2, y2, x3, y3, x, y)) {
                cot++;
                System.out.println("NO!");
                System.out.println(isInside1(x1, y1, x2, y2, x3, y3, x, y));
            }
        }
        System.out.println(cot);
    }
}
