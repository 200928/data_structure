package com.ming.design.creation.builder;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/14 - 下午7:02
 * @ Description: com.ming.design.creation.builder
 * @ Version: 1.0
 */
public class OfficeComputerBuilder extends ComputerBuilder {
    public OfficeComputerBuilder() {
        computerName = "办公电脑";
    }

    @Override
    void setupMainBoard() {
        computer.setMainBoard("办公--主板");
    }

    @Override
    void setupCpu() {
        computer.setCpu("办公——CPU");
    }

    @Override
    void setupMemory() {
        computer.setMemory("办公——内存");
    }

    @Override
    void setupHardDisk() {
        computer.setHardDisk("办公——硬盘");
    }

    @Override
    void setupVideoCard() {
        computer.setVideoCard("办公——显卡");
    }
}
