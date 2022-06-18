package com.ming.design.creation.builder;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/14 - 下午7:05
 * @ Description: com.ming.design.creation.builder
 * @ Version: 1.0
 */
public class GameComputerBuilder extends ComputerBuilder{
    public GameComputerBuilder() {
        computerName = "游戏电脑";
    }
    @Override
    void setupMainBoard() {
        computer.setMainBoard("游戏--主板");
    }

    @Override
    void setupCpu() {
        computer.setCpu("游戏——CPU");
    }

    @Override
    void setupMemory() {
        computer.setMemory("游戏——内存");
    }

    @Override
    void setupHardDisk() {
        computer.setHardDisk("游戏——硬盘");
    }

    @Override
    void setupVideoCard() {
        computer.setVideoCard("游戏——显卡");
    }
}
