package com.ming.design.structural.bridge;

import com.ming.design.structural.bridge.color.Blue;
import com.ming.design.structural.bridge.color.Green;
import com.ming.design.structural.bridge.color.Red;
import com.ming.design.structural.bridge.pen.BigBrush;
import com.ming.design.structural.bridge.pen.MedBrush;
import com.ming.design.structural.bridge.pen.SmallBrush;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/13 - 下午2:30
 * @ Description: com.ming.design.structural.bridge
 * @ Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建一个大号画笔实例
        BigBrush bigBrush = new BigBrush();
        // 将大号画笔的颜色设置为红色
        bigBrush.setColor(new Red());
        // 输出大号画笔的信息
        bigBrush.paint();
        // 将大号画笔设置为绿色
        bigBrush.setColor(new Green());
        // 输出大号画笔的信息
        bigBrush.paint();

        // 创建一个中号画笔实例
        MedBrush medBrush = new MedBrush();
        // 将中号画笔的颜色设置为红色
        medBrush.setColor(new Red());
        // 输出中号画笔的信息
        medBrush.paint();
        // 将中号画笔设置为蓝色
        medBrush.setColor(new Blue());
        // 输出中号画笔的信息
        medBrush.paint();

        // 创建一个大号画笔实例
        SmallBrush smallBrush = new SmallBrush();
        // 将小号画笔设置为绿色
        smallBrush.setColor(new Green());
        // 输出小号画笔信息
        smallBrush.paint();
        // 将小号画笔设置为蓝色
        smallBrush.setColor(new Blue());
        // 输出小号画笔的信息
        smallBrush.paint();
    }
}
