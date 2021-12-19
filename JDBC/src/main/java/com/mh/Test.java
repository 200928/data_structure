package com.mh;

import javax.swing.*;
import java.awt.*;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/11/26 - 19:51
 * @ Description: com.mh
 * @ Version: 1.0
 */
public class Test extends Frame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("第一个窗体");
        jFrame.setSize(500, 500);             // 设置组件的大小
        jFrame.setBackground(Color.green);  // 将背景设置成白色

        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.PINK);
        JButton button1=new JButton("按钮1");
        JButton button2=new JButton("按钮2");
        JButton button3=new JButton("按钮3");
        jPanel.add(button1);//添加一个按钮
        jPanel.add(button2);
        jPanel.add(button3);
        jFrame.add(jPanel);
        jFrame.setLocation(300, 200);        // 设置组件的显示位置
        jFrame.setVisible(true);            // 让组件可见
    }

}
