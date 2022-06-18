package com.ming.design.creation.builder;

import lombok.Getter;
import lombok.Setter;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/14 - 下午6:37
 * @ Description: com.ming.design.creation.builder
 * @ Version: 1.0
 * 电脑的组成
 */
@Getter
@Setter
public class Computer {
    private String mainBoard;   // 主板
    private String cpu;         // CPU
    private String memory;      // 内存
    private String hardDisk;    // 硬盘
    private String videoCard;   // 显卡

    @Override
    public String toString() {
        return "Computer{" +
                "mainBoard='" + mainBoard + '\'' +
                ", cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", videoCard='" + videoCard + '\'' +
                '}';
    }
}
