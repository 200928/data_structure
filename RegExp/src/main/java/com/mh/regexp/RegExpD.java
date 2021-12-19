package com.mh.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/10/1 - 14:58
 * @ Description: com.mh.regexp
 * @ Version: 1.0
 */
public class RegExpD {
    public static void main(String[] args) {
//        String reg = "[_0-9a-zA-Z]";
//        String reg = "[abcd]{3,5}";
        String reg = "^[0-9]+-[a-z]*";
        String str = "8-df";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
