package com.ming.design.structural.decorate.tank;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/20 - 下午9:46
 * @ Description: com.ming.design.structural.decorate.tank
 * @ Version: 1.0
 */
public class T50 implements Tank{
    @Override
    public void shot() {
        System.out.println("T50坦克平均每秒发射5发子弹");
    }

    @Override
    public void run() {
        System.out.println("T50坦克平均每时运行30KM");
    }
}
