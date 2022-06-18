package com.ming.design.behavior.command.work;

import com.ming.design.behavior.command.work.commands.BakeChickenWingCommand;
import com.ming.design.behavior.command.work.commands.BakeMuttonCommand;
import com.ming.design.behavior.command.work.commands.Command;

public class Program {

    public static void main(String[] args) {

        //开店前的准备，请名厨师
        Barbecuer boy = new Barbecuer();
        // 烤羊肉串的命令
        Command bakeMuttonCommand1 = new BakeMuttonCommand(boy);
        Command bakeMuttonCommand2 = new BakeMuttonCommand(boy);
        // 烤鸡翅的命令
        Command bakeChickenWingCommand1 = new BakeChickenWingCommand(boy);
        // 请一个服务员，接收上面的命令
        Waiter girl = new Waiter();

        //开门营业 顾客点菜，将上面的点单加入服务员的菜单里
        girl.setOrder(bakeMuttonCommand1);
        girl.setOrder(bakeMuttonCommand2);
        girl.setOrder(bakeChickenWingCommand1);

        //点菜完闭，通知厨师烤烧烤
        System.out.println("下面厨师开始烤烧烤：");
        girl.noitify();
    }
}
