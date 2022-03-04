package com.ming.design.creation.factory.operations;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/2 - 下午3:37
 * @ Description: com.ming.design.creation.factory
 * @ Version: 1.0
 * 该类是一个二元运算功能的运算类
 */
public class Operation {
    private double numberA = 0; // 操作数一
    private double numberB = 0; // 操作数二

    // 返回两数操作结果
    public double GetResult() {
        return 0;
    }

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }
}
