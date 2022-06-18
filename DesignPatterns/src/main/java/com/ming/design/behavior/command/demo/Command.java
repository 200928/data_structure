package com.ming.design.behavior.command.demo;

/**
 * @author minghui
 */
public abstract class Command {
    protected Receiver receiver;

    protected Command(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * 命令执行
     */
    public abstract void execute();
}