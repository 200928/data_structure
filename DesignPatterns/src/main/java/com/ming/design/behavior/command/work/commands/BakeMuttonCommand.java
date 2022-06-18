package com.ming.design.behavior.command.work.commands;

/**
 * @author MingHui Fan
 * @version 1.0
 * @date 2022/6/18-下午9:59
 * @description com.ming.design.behavior.command.work.command
 */

import com.ming.design.behavior.command.work.Barbecuer;

/**
 * 烤羊肉串命令
 * @author minghui
 */
public class BakeMuttonCommand extends Command {
    public BakeMuttonCommand(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void excuteCommand() {
        receiver.bakeMutton();
    }

    @Override
    public String toString() {
        return "BakeMuttonCommand";
    }
}

