package com.ming.design.structural.adapter;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/30 - 下午2:30
 * @ Description: com.ming.design.structural.adapter
 * @ Version: 1.0
 */
public class ForeignCenter {

    protected String name;

    void 进攻() {
        System.out.println("外籍中锋" + name + "进攻");
    }

    void 防守() {
        System.out.println("外籍中锋" + name + "防守");
    }
}
