package com.ming.design.behavior.command.demo;

/**
 * @author MingHui Fan
 * @version 1.0
 * @date 2022/6/18-下午2:38
 * @description com.ming.design.behavior.command
 */

public class ConcreteCommand extends Command {
    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.action();
    }

}
