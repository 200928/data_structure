package com.ming.design.structural.bridge.pen;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/13 - 下午2:29
 * @ Description: com.ming.design.structural.bridge.pen
 * @ Version: 1.0
 */
public class SmallBrush extends Brush {
    @Override
    public void paint() {
        System.out.println("使用的是小号画笔，颜色为" + color.getColor());
    }
}
