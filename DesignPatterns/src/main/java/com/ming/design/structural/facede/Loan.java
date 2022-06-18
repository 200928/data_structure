package com.ming.design.structural.facede;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/5/15 - 下午2:08
 * @ Description: com.ming.design.structural.facede
 * @ Version: 1.0
 */
// 贷款子系统
public class Loan {
    public boolean HasNoBadLoans(Customer customer) {
        System.out.println("检查有无不良贷款记录：" + customer.getName());
        return true;
    }
}
