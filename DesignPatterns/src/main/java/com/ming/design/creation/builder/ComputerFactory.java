package com.ming.design.creation.builder;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/14 - 下午7:07
 * @ Description: com.ming.design.creation.builder
 * @ Version: 1.0
 */
public class ComputerFactory {
    public void buildComputer(ComputerBuilder computerBuilder) {
        System.out.println("开始组装" + computerBuilder.getComputerName() + "电脑");
        computerBuilder.setupMainBoard();
        computerBuilder.setupCpu();
        computerBuilder.setupMemory();
        computerBuilder.setupHardDisk();
        computerBuilder.setupVideoCard();
        System.out.println("组装完成");
    }
}
