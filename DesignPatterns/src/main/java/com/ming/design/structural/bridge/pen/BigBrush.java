package com.ming.design.structural.bridge.pen;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/13 - 下午2:19
 * @ Description: com.ming.design.structural.bridge
 * @ Version: 1.0
 */
public class BigBrush extends Brush {
    @Override
    public void paint() {
        System.out.println("使用的是大号画笔，颜色为" + color.getColor());
    }
}
