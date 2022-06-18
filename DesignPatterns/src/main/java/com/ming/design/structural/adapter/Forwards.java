package com.ming.design.structural.adapter;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/30 - 下午2:19
 * @ Description: com.ming.design.structural.adapter
 * @ Version: 1.0
 */
public class Forwards extends Player {
    Forwards(String name) {
        this.name = name;
    }

    @Override
    void attack() {
        System.out.println("前锋" + name + "进攻");
    }

    @Override
    void defense() {
        System.out.println("前锋" + name + "防守");
    }
}
