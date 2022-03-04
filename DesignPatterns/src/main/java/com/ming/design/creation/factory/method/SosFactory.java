package com.ming.design.creation.factory.method;

import com.ming.design.creation.factory.operations.Operation;
import com.ming.design.creation.factory.operations.OperationSos;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/3 - 下午12:40
 * @ Description: com.ming.design.creation.factory.method
 * @ Version: 1.0
 * 该类是平方和工厂
 */
public class SosFactory implements IFactory{
    @Override
    public Operation createOperation() {
        return new OperationSos();
    }
}
