package com.ming.design.structural.bridge.pen;

import com.ming.design.structural.bridge.color.Color;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/13 - 下午1:28
 * @ Description: com.ming.design.structural.bridge
 * @ Version: 1.0
 */
abstract class Brush {
    // 画笔拥有颜色，创建一个颜色对象
    protected Color color;
    // 输出画笔的信息
    public abstract void paint();
    // 给颜色对象赋予颜色
    public void setColor(Color color) {
        this.color = color;
    }
}
