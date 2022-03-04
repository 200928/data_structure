package com.ming.design.creation.factory.operations;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/3 - 上午10:17
 * @ Description: com.ming.design.creation.factory.operations
 * @ Version: 1.0
 * 该类实现两数乘法
 */
public class OperationMul extends Operation {
    @Override
    public double GetResult() {
        double result = getNumberA() * getNumberB();
        return result;
    }
}
