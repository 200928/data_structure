package com.ming.design.creation.builder;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/3/14 - 下午7:11
 * @ Description: com.ming.design.creation.builder
 * @ Version: 1.0
 */
public class Program {
    public static void main(String[] args) {
        // new一个创建者实例
        ComputerFactory computerFactory = new ComputerFactory();
        // 获取办公电脑类，里面有办公电脑的配置
        ComputerBuilder officeComputerBuilder = new OfficeComputerBuilder();
        // 通过创建者实例的buildComputer方法，传配置清单给创建者，让它生成出产品
        computerFactory.buildComputer(officeComputerBuilder);
        // 获取组装好的办公电脑
        Computer officeComputer = officeComputerBuilder.getComputer();
        // 查看配置
        System.out.println(officeComputer.toString());


        // 获取游戏电脑类，里面有游戏电脑的配置
        ComputerBuilder gameComputerBuilder = new GameComputerBuilder();
        // 通过创建者实例的buildComputer方法，传配置清单给创建者，让它生成出产品
        computerFactory.buildComputer(gameComputerBuilder);
        // 获取组装好的办公电脑
        Computer gameComputer = gameComputerBuilder.getComputer();
        // 查看配置
        System.out.println(gameComputer.toString());
    }
}



