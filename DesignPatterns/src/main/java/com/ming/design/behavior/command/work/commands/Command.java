package com.ming.design.behavior.command.work.commands;

import com.ming.design.behavior.command.work.Barbecuer;

/**
 * 抽象命令
 * @author minghui
 */
public abstract class Command {
    protected Barbecuer receiver;

    protected Command(Barbecuer receiver) {
        this.receiver = receiver;
    }

    /**
     * 执行命令
     */
    public abstract void excuteCommand();
}

