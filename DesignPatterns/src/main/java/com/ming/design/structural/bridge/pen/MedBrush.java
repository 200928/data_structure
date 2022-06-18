package com.ming.design.structural.bridge.pen;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/16 - 下午8:29
 * @ Description: com.ming.design.structural.bridge.pen
 * @ Version: 1.0
 */
public class MedBrush extends Brush{
    @Override
    public void paint() {
        System.out.println("使用的是中号画笔，颜色为" + color.getColor());
    }
}
