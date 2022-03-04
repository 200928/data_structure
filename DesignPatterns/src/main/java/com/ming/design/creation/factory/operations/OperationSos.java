package com.ming.design.creation.factory.operations;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/3 - 下午12:34
 * @ Description: com.ming.design.creation.factory.operations
 * @ Version: 1.0
 * 该类是实现平方和的计算
 */
public class OperationSos extends Operation {
    @Override
    public double GetResult() {
        double result = getNumberA() * getNumberA() + getNumberB() * getNumberB();
        return  result;
    }
}
