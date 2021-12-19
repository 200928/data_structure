package com.mh.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class RegExp {
    public static void main(String[] args) {
        String text = "改革开放由中华人民共和国第二代最高领导人邓小平提出和创立，" +
                "是在1978年12月18日第十一届中央委员会第三次全体会议后，" +
                "开始实施的一系列以经济为主的改革措施，可总结为“对内改革，对外开放”[1][2]。" +
                "改革开放是中华人民共和国历史上的重大决策，起始于文化大革命后的“拨乱反正”时期，" +
                "改变了中国大陆自1949年后经济上对外比较封闭近30年的情况，使中华人民共和国经济高速发展，" +
                "2001年中国加入世界贸易组织，大力发展进出口贸易，" +
                "2010年中国的国内生产总值（GDP）超越日本、成为全球第二大经济体[3][4]。" +
                "中国人均GDP从1978年的115美元增长到2019年的10276美元，达到中等偏上国家的收入水平，GDP总量达14.4万亿美元[5]。";
        // 创建匹配规则
        String reg = "(\\d\\d)(\\d\\d)";
        // 创建模式对象 [即正则表达式对象]
        Pattern pattern = Pattern.compile(reg);
        // 创建匹配器，按照正则表达式的规则，去匹配 text 文本串
        Matcher matcher = pattern.matcher(text);

        /**
         * 源码
         *    public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *     }
         */
        while (matcher.find()) {
            System.out.println("找到目标:" + matcher.group(0));     // groups[0]-groups[1]
            System.out.println("第一组()匹配目标:" + matcher.group(1));  // groups[2]-groups[3]
            System.out.println("第二组()匹配目标:" + matcher.group(2));  // groups[4]-groups[5]
        }

        String regexp = "\\w*\\.java";
        System.out.println(".java".matches(regexp));
        System.out.println("a.java".matches(regexp));
        System.out.println("aaa.java".matches(regexp));
        System.out.println("aa_.java".matches(regexp));
        System.out.println("8java".matches(regexp));

//        String string = "012345";
//        System.out.println(string.subSequence(0, 4));

    }
}
