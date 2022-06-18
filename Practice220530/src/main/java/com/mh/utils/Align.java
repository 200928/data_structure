package com.mh.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/6/8 - 下午7:03
 * @ Description: com.mh.utils
 * @ Version: 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Align {

    private StringBuilder placeholder = new StringBuilder(); // 保存%-8s
    private StringBuilder placeholders = new StringBuilder(); // 保存多个%-8s
    private int width = 10;  // 字符所占的宽度
    private ArrayList<Object> arrayList = new ArrayList<>();   // 保存用户加入的字符串

    public Align(int width) {
        this.width = width;
    }

    // 链式添加参数
    // 左对齐处理
    public Align add(Object object) {
        arrayList.add(object);
//        // 临时保存用来判断是否是半角/全角字符
        String str = String.valueOf(object);
        char[] chars = str.toCharArray();
        double countBan = 0; // 半角个数
        double countQuan = 0;  // 全角个数
        for (char aChar : chars) {
            String temp = String.valueOf(aChar);
            // 判断是全角字符
            if (temp.matches("[^\\x00-\\xff]")) {
                countQuan++;
            }
            // 判断是半角字符
            else {
                countBan += 1;
            }
        }
        this.placeholder.append("%-").append(width + (int) Math.ceil(countBan)).append("s");
        this.placeholders.append(this.placeholder);
        this.placeholder.setLength(0);
        return this;
    }

    public void format() {
//        System.out.println(this.placeholders);
        System.out.printf(String.valueOf(placeholders), this.arrayList.toArray());
        System.out.println();
        arrayList.clear();  // 清空数组，便于下次使用
        this.placeholders.setLength(0);
    }
}
