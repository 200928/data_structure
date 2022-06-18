package com.ming.design.responsibility;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/5/29 - 下午12:21
 * @ Description: com.ming.design.responsibility
 * @ Version: 1.0
 */

//总经理
class GeneralManager extends Manager {
    public GeneralManager(String name) {
        super(name);
    }

    public void RequestApplications(Request request) {
        if (request.getRequestType().equals("请假")) {
            System.out.println(request.getRequestContent() + " 数量" +
                    request.getNumber() + " -->被批准" + ",处理人：" + name);
        } else if (request.getRequestType().equals("加薪") && request.getNumber() <= 500) {
            System.out.println(request.getRequestContent() + " 数量" +
                    request.getNumber() + " -->被批准" + ",处理人：" + name);
        } else if (request.getRequestType().equals("加薪") && request.getNumber() > 500) {
            System.out.println(request.getRequestContent() + " 数量" +
                    request.getNumber() + " -->再说吧！" + ",处理人：" + name);
        }
    }
}
