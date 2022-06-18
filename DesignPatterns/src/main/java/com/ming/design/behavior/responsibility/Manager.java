package com.ming.design.behavior.responsibility;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/5/29 - 下午12:10
 * @ Description: com.ming.design.responsibility
 * @ Version: 1.0
 */
abstract class Manager {
    // 管理者名称
    protected String name;
    //管理者的上级
    protected Manager superior;

    public Manager(String name) {
        this.name = name;
    }

    //设置管理者的上级
    public void SetSuperior(Manager superior) {
        this.superior = superior;
    }

    //申请请求
    abstract public void RequestApplications(Request request);
}
