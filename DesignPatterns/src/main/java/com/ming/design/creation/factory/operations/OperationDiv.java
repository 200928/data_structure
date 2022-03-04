package com.ming.design.creation.factory.operations;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/3 - 上午10:18
 * @ Description: com.ming.design.creation.factory.operations
 * @ Version: 1.0
 * 该类实现两数除法
 */
public class OperationDiv extends Operation {
    @Override
    public double GetResult() {
        try {
            if (0 == getNumberB()) {
                throw new Exception("除数不能为0！");
            }
            double result = getNumberA() / getNumberB();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
