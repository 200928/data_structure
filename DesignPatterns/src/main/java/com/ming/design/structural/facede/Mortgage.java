package com.ming.design.structural.facede;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/5/15 - 下午2:10
 * @ Description: com.ming.design.structural.facede
 * @ Version: 1.0
 */
// 外观模式类
public class Mortgage {
    private Bank bank = new Bank();
    private Credit credit = new Credit();
    private Loan loan = new Loan();

    public boolean isEligible(Customer customer, int amount) {
        System.out.println(customer.getName() + "申请贷款：" + amount);
        // 改变了表示该用户是否可贷款
        boolean eligible = true;
        // 检查银行存款是否满足贷款条件
        if (!bank.HasSufficientSavings(customer,amount)) {
            eligible = false;
        }
        // 检查信用是否满足贷款条件
        else if (!credit.HasGoodCredit(customer)) {
            eligible = false;
        }
        // 检查有无不良贷款记录,以便判断是否能够贷款
        else if (!loan.HasNoBadLoans(customer)) {
            eligible = false;
        }
        return eligible;
    }
}
