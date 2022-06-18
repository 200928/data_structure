package com.ming.design.structural.facede;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/5/15 - 下午2:04
 * @ Description: com.ming.design.structural.facede
 * @ Version: 1.0
 */
// 信用子系统
public class Credit {
    public boolean HasGoodCredit(Customer customer) {
        System.out.println("检查信用：" + customer.getName());
        return true;
    }
}
