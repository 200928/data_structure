package String;

import tools.Times;

import javax.naming.NamingException;
import javax.sound.midi.Soundbank;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * @ Author: MingHuiFan
 * @ Date: 2021/3/20 - 15:18
 * @ Description: String
 * @ Version: 1.0
 */
public class KMP {

    /*
    KMP
    O(N)
     */
    public static int getIndexOf(String text, String pattern) {
        if (text.length() < pattern.length() || text.length() < 1) {
            return -1;
        }
        char[] str1 = text.toCharArray();   // 文本串
        char[] str2 = pattern.toCharArray();    // 匹配串
        int[] next = getNextArray(str2);    // next 数组
        int i1 = 0;
        int i2 = 0;
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) { // 如果字符相等两者同时移动到下一个字符
                i1++;
                i2++;
            } else if (next[i2] == -1) {    // str2 中比对的位置已经无法往前跳了
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        // 只要是 i2 越界了，那么一定匹配成功
        // 但是 i1 越界不一定匹配失败，因为 i1 i2 可能同时越界
        return i2 == str2.length ? i1 - i2 : -1;
    }

    /*
    next 数组
    O(M)
     */
    public static int[] getNextArray(char[] str2) {
        if (str2.length == 1) {
            return new int[] {-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (str2[i - 1] == str2[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {   // cn 位置和 i - 1 不匹配，继续向前找
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }


    public static int force(String text, String pattern)  {
        int tlen = text.length();
        int plen = pattern.length();
        int ti = 0;
        int pi = 0;
        // 但凡有一个下标越界都退出
        while (pi < plen && ti < tlen) {
            if (text.charAt(ti) == pattern.charAt(pi)) {
                ti++;
                pi++;
            } else {
                ti -= pi - 1;   // 退回到下一个位置
                pi = 0;         // 匹配串回到 0 位置
            }
        }
        // 如果是匹配串越界了一定是匹配成功
        return pi == plen ? ti - pi : -1;
    }

    public static String getRandomString(int length){
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<length; ++i){
            //产生0-61的数字
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }

    public static String getRandomString(String str) {
//        int num = (int)new Random().nextInt(str.length());
        int num = 10;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int cn = new Random().nextInt(str.length());
            stringBuilder.append(str.charAt(cn));
        }
        String s = new String(stringBuilder);
        return s;
    }

    public static void main(String[] args) {
        Times.test("KMP", () -> {
            int num = 10000000;
            int success = 0;
            int f = 0;
            for (int i = 0; i < num; i++) {
                String t = getRandomString(100);
                String p = getRandomString(t);
                int tmp = getIndexOf(t, p);
                if (tmp == -1) {
                    f++;
                } else {
                    success++;
                }
            }
            System.out.println(success + "_" + f);
        });

        Times.test("force", () -> {
            int num = 10000000;
            int success = 0;
            int f = 0;
            for (int i = 0; i < num; i++) {
                String t = getRandomString(10);
                String p = getRandomString(t);
                int tmp = force(t, p);
                if (tmp == -1) {
                    f++;
                } else {
                    success++;
                }
            }
            System.out.println(success + "_" + f);
        });
    }
}
