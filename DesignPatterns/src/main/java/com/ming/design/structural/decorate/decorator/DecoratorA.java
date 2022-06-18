package com.ming.design.structural.decorate.decorator;

import com.ming.design.structural.decorate.tank.Tank;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/20 - 下午9:54
 * @ Description: com.ming.design.structural.decorate.decorator
 * @ Version: 1.0
 */
public class DecoratorA extends Decorator {
    public DecoratorA(Tank tank) {
        super(tank);
    }

    @Override
    public void shot() {
        System.out.println("增加红外线功能");
        super.shot();
    }

    @Override
    public void run() {
        super.run();
    }
}
