package com.ming.design.creation.factory.method;

import com.ming.design.creation.factory.operations.Operation;
import com.ming.design.creation.factory.operations.OperationSd;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/3 - 下午12:41
 * @ Description: com.ming.design.creation.factory.method
 * @ Version: 1.0
 */
public class SdFactory implements IFactory{
    @Override
    public Operation createOperation() {
        return new OperationSd();
    }
}
