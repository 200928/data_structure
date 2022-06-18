package com.ming.design.structural.facede;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/5/15 - 下午1:58
 * @ Description: com.ming.design.structural.facede
 * @ Version: 1.0
 */
// 银行子系统
public class Bank {
    public boolean HasSufficientSavings(Customer customer, int amount) {
        System.out.println("检查银行存款：" + customer.getName());
        return true;
    }
}
