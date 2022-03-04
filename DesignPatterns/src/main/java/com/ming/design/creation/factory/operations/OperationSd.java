package com.ming.design.creation.factory.operations;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/3 - 下午12:36
 * @ Description: com.ming.design.creation.factory.operations
 * @ Version: 1.0
 * 该类实现平方差的计算
 */
public class OperationSd extends Operation {
    @Override
    public double GetResult() {
        double result = getNumberA() * getNumberA() - getNumberB() * getNumberB();
        return result;
    }
}
