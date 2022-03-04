package com.ming.design.creation.factory.method;

import com.ming.design.creation.factory.operations.Operation;
import com.ming.design.creation.factory.operations.OperationSub;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/3 - 上午11:47
 * @ Description: com.ming.design.creation.factory.method
 * @ Version: 1.0
 */
public class SubFactory implements IFactory{
    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}
