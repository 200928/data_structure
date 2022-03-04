package com.ming.design.creation.factory;

import com.ming.design.creation.factory.method.AddFactory;
import com.ming.design.creation.factory.method.DivFactory;
import com.ming.design.creation.factory.method.IFactory;
import com.ming.design.creation.factory.method.MulFactory;
import com.ming.design.creation.factory.method.SdFactory;
import com.ming.design.creation.factory.method.SosFactory;
import com.ming.design.creation.factory.method.SubFactory;
import com.ming.design.creation.factory.operations.Operation;
import com.ming.design.creation.factory.simple.OperationFactory;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/3 - 上午10:08
 * @ Description: com.ming.design.creation.factory
 * @ Version: 1.0
 */
public class Main {
    static double numberA = 10;
    static double numberB = 20;
    private static void simpleFactory() {
        Operation operationAdd = OperationFactory.createOperate("+");
        operationAdd.setNumberA(numberA);
        operationAdd.setNumberB(numberB);
        System.out.println("简单工厂模式加法测试:" + numberA + "+" + numberB + "=" + operationAdd.GetResult());

        Operation operationSub = OperationFactory.createOperate("-");
        operationSub.setNumberA(numberA);
        operationSub.setNumberB(numberB);
        System.out.println("简单工厂模式减法测试:" + numberA + "-" + numberB + "=" + operationSub.GetResult());

        Operation operationMul = OperationFactory.createOperate("*");
        operationMul.setNumberA(numberA);
        operationMul.setNumberB(numberB);
        System.out.println("简单工厂模式乘法测试:" + numberA + "*" + numberB + "=" + operationMul.GetResult());

        Operation operationDiv = OperationFactory.createOperate("/");
        operationDiv.setNumberA(numberA);
        operationDiv.setNumberB(numberB);
        System.out.println("简单工厂模式除法测试:" + numberA + "/" + numberB + "=" + operationDiv.GetResult());

        Operation operationSos = OperationFactory.createOperate("^");
        operationSos.setNumberA(numberA);
        operationSos.setNumberB(numberB);
        System.out.println("简单工厂模式平方和测试:" + numberA + "^2+" + numberB + "^2=" + operationSos.GetResult());

        Operation operationSd = OperationFactory.createOperate("^-");
        operationSd.setNumberA(numberA);
        operationSd.setNumberB(numberB);
        System.out.println("简单工厂模式平方差测试:" + numberA + "^2-" + numberB + "^2=" + operationSd.GetResult());
    }
    private static void methodFactory() {
        IFactory iFactory = new AddFactory();   // 创建加法工厂实例
        Operation operation = iFactory.createOperation();   // 通过函数createOperation()得到加法类
        operation.setNumberA(numberA);  // 赋值给操作数A
        operation.setNumberB(numberB);  // 赋值给操作数B
        System.out.println("工厂方法模式加法测试:" + numberA + "+" + numberB + "=" + operation.GetResult());

        iFactory = new SubFactory();
        operation = iFactory.createOperation();   // 通过函数createOperation()得到减法类
        operation.setNumberA(numberA);
        operation.setNumberB(numberB);
        System.out.println("工厂方法模式减法测试:" + numberA + "-" + numberB + "=" + operation.GetResult());

        iFactory = new MulFactory();
        operation = iFactory.createOperation();   // 通过函数createOperation()得到乘法类
        operation.setNumberA(numberA);
        operation.setNumberB(numberB);
        System.out.println("工厂方法模式加法测试:" + numberA + "*" + numberB + "=" + operation.GetResult());

        iFactory = new DivFactory();
        operation = iFactory.createOperation();   // 通过函数createOperation()得到除法类
        operation.setNumberA(numberA);
        operation.setNumberB(numberB);
        System.out.println("工厂方法模式除法测试:" + numberA + "/" + numberB + "=" + operation.GetResult());

        iFactory = new SosFactory();
        operation = iFactory.createOperation();   // 通过函数createOperation()得到除法类
        operation.setNumberA(numberA);
        operation.setNumberB(numberB);
        System.out.println("工厂方法模式平方和测试:" + numberA + "^2+" + numberB + "^2=" + operation.GetResult());

        iFactory = new SdFactory();
        operation = iFactory.createOperation();   // 通过函数createOperation()得到除法类
        operation.setNumberA(numberA);
        operation.setNumberB(numberB);
        System.out.println("工厂方法模式平方差测试:" + numberA + "^2-" + numberB + "^2=" + operation.GetResult());
    }
    public static void main(String[] args) {
        simpleFactory();
        System.out.println();
        methodFactory();
//        Operation operationAdd = new OperationAdd();
//        operationAdd.setNumberA(12);
//        operationAdd.setNumberB(12);
//        System.out.println(operationAdd.GetResult());
//
//        Operation operationSub = new OperationSub();
//        operationSub.setNumberA(12);
//        operationSub.setNumberB(10);
//        System.out.println(operationSub.GetResult());
    }
}
