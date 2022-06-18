package com.ming.design.creation.builder;

import lombok.Getter;
import lombok.Setter;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/14 - 下午6:48
 * @ Description: com.ming.design.creation.builder
 * @ Version: 1.0
 * 这是一个
 */
@Getter
@Setter
public abstract class ComputerBuilder {
    protected String computerName;  // 不同配置电脑的名字，比如办公，游戏等
    protected Computer computer;

    // 下面是电脑组装的必要过程
    abstract void setupMainBoard(); // 组装主板
    abstract void setupCpu();       // 组装CPU
    abstract void setupMemory();    // 组装内存条
    abstract void setupHardDisk();  // 组装硬盘
    abstract void setupVideoCard(); // 组装显卡

    public ComputerBuilder() {
        computer = new Computer();
    }

    Computer getComputer() {
        return computer;
    }
}
