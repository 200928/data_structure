package com.ming.design.structural.decorate.tank;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/20 - 下午9:48
 * @ Description: com.ming.design.structural.decorate.tank
 * @ Version: 1.0
 */
public class T90 implements Tank {
    @Override
    public void shot() {
        System.out.println("T90坦克平均每秒发射10发子弹");
    }

    @Override
    public void run() {
        System.out.println("T90坦克平均每时运行40KM");
    }
}
