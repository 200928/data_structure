package com.ming.design.behavior.responsibility;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/5/29 - 下午12:20
 * @ Description: com.ming.design.responsibility
 * @ Version: 1.0
 */

//总监
class Majordomo extends Manager {
    public Majordomo(String name) {
        super(name);
    }

    @Override
    public void RequestApplications(Request request) {

        if (request.getRequestType().equals("请假") && request.getNumber() <= 5) {
            System.out.println(request.getRequestContent() + " 数量" +
                    request.getNumber() + " -->被批准" + ",处理人：" + name);
        } else {
            if (superior != null) superior.RequestApplications(request);
        }

    }
}
