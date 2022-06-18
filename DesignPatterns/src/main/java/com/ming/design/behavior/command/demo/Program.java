package com.ming.design.behavior.command.demo;

/**
 * @author minghui
 */
public class Program {

    public static void main(String[] args) {

        Receiver r = new Receiver();
        Command c = new ConcreteCommand(r);
        Invoker i = new Invoker();

        i.setCommand(c);
        i.executeCommand();

    }

}
