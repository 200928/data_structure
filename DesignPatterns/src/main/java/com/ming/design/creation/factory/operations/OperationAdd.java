package com.ming.design.creation.factory.operations;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/3 - 上午10:05
 * @ Description: com.ming.design.creation.factory.operations
 * @ Version: 1.0
 * 该类实现两数加法
 */
public class OperationAdd extends Operation {
    @Override
    public double GetResult() {
        double result = getNumberA() + getNumberB();
        return result;
    }
}

