package com.ming.design.creation.factory.method;

import com.ming.design.creation.factory.operations.Operation;
import com.ming.design.creation.factory.operations.OperationMul;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/3 - 上午11:48
 * @ Description: com.ming.design.creation.factory.method
 * @ Version: 1.0
 */
public class MulFactory implements IFactory{
    @Override
    public Operation createOperation() {
        return new OperationMul();
    }
}
