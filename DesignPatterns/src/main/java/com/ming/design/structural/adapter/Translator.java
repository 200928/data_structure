package com.ming.design.structural.adapter;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/30 - 下午2:37
 * @ Description: com.ming.design.structural.adapter
 * @ Version: 1.0
 */
public class Translator extends Player {

    private ForeignCenter foreignCenter = new ForeignCenter();

    Translator(String name) {
        foreignCenter.name = name;
    }

    @Override
    void attack() {
        foreignCenter.进攻();
    }

    @Override
    void defense() {
        foreignCenter.防守();
    }
}
