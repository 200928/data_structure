package com.ming.design.structural.decorate.decorator;

import com.ming.design.structural.decorate.tank.Tank;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/20 - 下午9:50
 * @ Description: com.ming.design.structural.decorate.decorator
 * @ Version: 1.0
 */
public abstract class Decorator implements Tank {

    // 对应类图中的聚合关系
    private Tank tank;

    // 构造函数需要传入一个 Tank 实例
    public Decorator(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void shot() {
        this.tank.shot();
    }

    @Override
    public void run() {
        this.tank.run();
    }
}
