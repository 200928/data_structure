package com.ming.design.responsibility;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/5/29 - 下午12:22
 * @ Description: com.ming.design.responsibility
 * @ Version: 1.0
 */

//申请
class Request {
    //申请类别
    private String requestType;

    //申请内容
    private String requestContent;

    //数量
    private int number;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String value) {
        requestType = value;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String value) {
        requestContent = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int value) {
        number = value;
    }
}
