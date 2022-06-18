package com.ming.design.behavior.command.work.commands;

/**
 * @author MingHui Fan
 * @version 1.0
 * @date 2022/6/18-下午9:58
 * @description com.ming.design.behavior.command.work.command
 */

import com.ming.design.behavior.command.work.Barbecuer;

/**
 * 烤鸡翅命令
 */
public class BakeChickenWingCommand extends Command {
    public BakeChickenWingCommand(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void excuteCommand() {
        receiver.bakeChickenWing();
    }

    @Override
    public String toString() {
        return "BakeChickenWingCommand";
    }
}
