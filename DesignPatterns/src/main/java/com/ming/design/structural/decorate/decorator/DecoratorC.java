package com.ming.design.structural.decorate.decorator;

import com.ming.design.structural.decorate.tank.Tank;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/20 - 下午10:06
 * @ Description: com.ming.design.structural.decorate.decorator
 * @ Version: 1.0
 */
public class DecoratorC extends Decorator {
    public DecoratorC(Tank tank) {
        super(tank);
    }

    public void shot() {
        System.out.println("增加卫星定位功能");
        super.shot();
    }

    public void run() {
        super.run();
    }
}
