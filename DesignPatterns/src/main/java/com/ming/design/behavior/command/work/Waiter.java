package com.ming.design.behavior.command.work;

import com.ming.design.behavior.command.work.commands.Command;

import java.util.List;
import java.util.LinkedList;
import java.util.Date;

/**
 * 服务员
 *
 * @author minghui
 */
public class Waiter {
    private final List<Command> orders = new LinkedList<>();

    /**
     * 设置订单
     */
    public void setOrder(Command command) {
        if (command.toString().equals("BakeChickenWingCommand")) {
            System.out.println("服务员：鸡翅没有了，请点别的烧烤。");
        } else {
            orders.add(command);
            System.out.println("增加订单：" + command.toString() + "  时间：" + (new Date()).toString());
        }
    }

    /**
     * 取消订单
     */
    public void cancelOrder(Command command) {
        orders.remove(command);
        System.out.println("取消订单：" + command.toString() + "  时间：" + (new Date()).toString());
    }

    /**
     * 通知全部执行
     */
    public void noitify() {
        for (Command cmd : orders) {
            cmd.excuteCommand();
        }
    }
}

