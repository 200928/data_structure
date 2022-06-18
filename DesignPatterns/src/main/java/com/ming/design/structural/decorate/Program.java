package com.ming.design.structural.decorate;

import com.ming.design.structural.decorate.decorator.DecoratorA;
import com.ming.design.structural.decorate.decorator.DecoratorB;
import com.ming.design.structural.decorate.decorator.DecoratorC;
import com.ming.design.structural.decorate.tank.T75;
import com.ming.design.structural.decorate.tank.Tank;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/20 - 下午10:07
 * @ Description: com.ming.design.structural.decorate
 * @ Version: 1.0
 */
public class Program {
    public static void main(String[] args) {
        // 先创建一个 T75 坦克
        Tank tank = new T75();
        // 给坦克增加红外线功能
        System.out.println("==================给坦克增加红外线功能==================");
        DecoratorA decoratorA = new DecoratorA(tank);
        decoratorA.shot();
        // 给坦克增加水红外线功能和水路两硒功能
        System.out.println("==================给坦克增加水红外线功能和水路两硒功能==================");
        DecoratorB decoratorB = new DecoratorB(decoratorA);
        decoratorB.shot();
        // 给坦克增加水红外线功能,水路两硒功能和卫星定位功能
        System.out.println("==================给坦克增加水红外线功能,水路两硒功能和卫星定位功能==================");
        DecoratorC decoratorC = new DecoratorC(decoratorB);
        decoratorC.shot();
    }
}
