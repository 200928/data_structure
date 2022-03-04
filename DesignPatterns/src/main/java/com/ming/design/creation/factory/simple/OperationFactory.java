package com.ming.design.creation.factory.simple;

import com.ming.design.creation.factory.operations.Operation;
import com.ming.design.creation.factory.operations.OperationAdd;
import com.ming.design.creation.factory.operations.OperationDiv;
import com.ming.design.creation.factory.operations.OperationMul;
import com.ming.design.creation.factory.operations.OperationSd;
import com.ming.design.creation.factory.operations.OperationSos;
import com.ming.design.creation.factory.operations.OperationSub;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/3 - 上午10:31
 * @ Description: com.ming.design.creation.factory
 * @ Version: 1.0
 */
public class OperationFactory {
    public static Operation createOperate(String operate) {
        Operation operation = null;
        switch (operate) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
            case "^":
                operation = new OperationSos();
                break;
            case "^-":
                operation = new OperationSd();
                break;
            default:
                break;
        }
        return operation;
    }
}
