package com.ming.design.structural.facede;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/5/15 - 下午2:22
 * @ Description: com.ming.design.structural.facede
 * @ Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 创建一个外观对象
        Mortgage mortgage = new Mortgage();
        Customer customer = new Customer("张三");
        // 该变量记录张三是否能够贷款
        boolean eligible = mortgage.isEligible(customer, 10000000);
        System.out.println(customer.getName() + "贷款" + (eligible ? "批准" : "不批准"));
    }
}
