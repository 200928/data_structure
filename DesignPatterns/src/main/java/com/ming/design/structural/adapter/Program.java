package com.ming.design.structural.adapter;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/30 - 下午2:39
 * @ Description: com.ming.design.structural.adapter
 * @ Version: 1.0
 */
public class Program {
    public static void main(String[] args) {
        Player forwards = new Forwards("巴蒂尔");
        forwards.attack();
        forwards.defense();

        Player guards = new Guards("麦克格雷迪");
        guards.attack();
        guards.defense();

        Player ym = new Translator("姚明");
        ym.attack();
        ym.defense();
    }
}
