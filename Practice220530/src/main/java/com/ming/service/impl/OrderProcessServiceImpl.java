package com.ming.service.impl;/*
 * @ Author: MingHui Fan
 * @ Date: 2022/6/09 - 下午10:21
 * @ Description: com.ming.service.impl
 * @ Version: 1.0
 */

import com.ming.dao.OrderInfoDao;
import com.ming.dao.impl.OrderInfoDaoImpl;
import com.ming.service.OrderProcessService;
import com.ming.utils.Align;
import com.ming.utils.CheckInput;

import java.util.Scanner;

public class OrderProcessServiceImpl implements OrderProcessService {

    Scanner scanner = new Scanner(System.in);

    // 该类自己包装，用于输出对齐
    Align align = new Align(15);

    // 需要 OrderInfoDao 对象修改和查看 订单列表 数据
    OrderInfoDao orderInfoDao = OrderInfoDaoImpl.getInstance();

    @Override
    public void orderSign() {
        System.out.println("*****签收订单*****");
        // 签收订单编号
        int orderNo;
        boolean flag = false;
        do {
            System.out.print("请选择要签收的订单序号(输入0返回主菜单)：");
            orderNo = CheckInput.isInputInt(scanner);
            // 判断订单是否存在(true)
            boolean isOrder = isOrder(orderNo);
            // 判断订单是否已经签收，已经已经签收才能删除
            boolean isSign = isSign(orderNo);
            if (0 == orderNo) {
                flag = true;
                continue;
            }
            // 如果订单不存在
            // 如果订单不存在
            if (!isOrder) {
                System.out.print("您要签收的订单不存在，");
            }
            // 如果订单还未签收，则签收
            else if (!isSign) {
                orderInfoDao.getOrderInfoList().get(orderNo - 1).setStatus(1);
                System.out.println("订单签收成功！");
            }
            // 如果订单已经签收了，无需在次签收
            else {
                System.out.print("订单已经签收了，无需在次签收！");
            }
        } while (!flag);
    }

    @Override
    public void orderDelete() {
        System.out.println("*****删除订单*****");
        boolean flag = false;
        System.out.print("请输入要删除的订单序号(输入0返回主菜单)：");
        // 要删除的订单
        int orderNo;
        do {
            orderNo = CheckInput.isInputInt(scanner);
            // 判断订单是否存在(true)
            boolean isOrder = isOrder(orderNo);
            // 判断订单是否已经签收，已经已经签收才能删除
            boolean isSign = isSign(orderNo);
            if (0 == orderNo) {
                flag = true;
                continue;
            }
            // 如果订单不存在
            if (!isOrder) {
                System.out.print("您要删除的订单不存在，请重新输入订单号(输入0返回主菜单)：");
            }
            // 如果订单还未签收，也不能删除
            else if (!isSign) {
                System.out.print("您要删除的订单还未签收，请先签收在删除，请重新输入订单号(输入0返回主菜单)：");
            }
            // 如果存在且签收了，则可以删除了
            else {
                orderInfoDao.getOrderInfoList().remove(orderNo - 1);
                System.out.print("订单删除成功！\n继续输入要删除的订单号");
                System.out.print("(输入0返回主菜单)：");
            }
        } while (!flag);
    }

    @Override
    public boolean isOrder(int orderNo) {
        return orderNo > 0 && orderNo <= orderInfoDao.getOrderInfoList().size();
    }

    @Override
    public boolean isSign(int orderNo) {
        if (!isOrder(orderNo)) {
            return false;
        }
        return 0 != orderInfoDao.getOrderInfoList().get(orderNo - 1).getStatus();
    }
}
