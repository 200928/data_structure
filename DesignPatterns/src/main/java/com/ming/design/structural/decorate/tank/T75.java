package com.ming.design.structural.decorate.tank;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/20 - 下午9:47
 * @ Description: com.ming.design.structural.decorate.tank
 * @ Version: 1.0
 */
public class T75 implements Tank {
    @Override
    public void shot() {
        System.out.println("T75坦克平均每秒发射10发子弹");
    }

    @Override
    public void run() {
        System.out.println("T75坦克平均每时运行35KM");
    }
}
