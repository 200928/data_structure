package com.ming.design.behavior.responsibility;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/5/29 - 下午12:26
 * @ Description: com.ming.design.responsibility
 * @ Version: 1.0
 */

public class Program {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根

        //构建管理者层级结构
        CommonManager jinli = new CommonManager("金利");
        Majordomo zongjian = new Majordomo("宗剑");
        GeneralManager zhongjingli = new GeneralManager("钟精励");
        // 将总监zongjian设置为jinli的上级
        jinli.SetSuperior(zongjian);
        // 将总经理zongjingli设置为zongjian的上级
        zongjian.SetSuperior(zhongjingli);

        //请求处理
        Request request = new Request();
        request.setRequestType("请假");
        request.setRequestContent("小菜请假");
        request.setNumber(1);
        jinli.RequestApplications(request);

        Request request2 = new Request();
        request2.setRequestType("请假");
        request2.setRequestContent("小菜请假");
        request2.setNumber(4);
        jinli.RequestApplications(request2);

        Request request3 = new Request();
        request3.setRequestType("加薪");
        request3.setRequestContent("小菜请求加薪");
        request3.setNumber(500);
        jinli.RequestApplications(request3);

        Request request4 = new Request();
        request4.setRequestType("加薪");
        request4.setRequestContent("小菜请求加薪");
        request4.setNumber(1000);
        jinli.RequestApplications(request4);
    }
}
