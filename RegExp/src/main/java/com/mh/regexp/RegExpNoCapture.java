package com.mh.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/10/2 - 11:17
 * @ Description: com.mh.regexp
 * @ Version: 1.0
 */
public class RegExpNoCapture {
    public static void main(String[] args) {
        String content = "张三是我 张三是老师 张三是zhangsan 我是张三";
//        String regStr = "张三是我|张三是老师|张三是zhangsan";
        String regStr = "张三是(?:我|老师|zhangsan)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
