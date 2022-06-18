package com.ming.service.impl;/*
 * @ Author: MingHui Fan
 * @ Date: 2022/6/09 - 下午10:21
 * @ Description: com.ming.service.impl
 * @ Version: 1.0
 */

import com.ming.dao.DishDao;
import com.ming.dao.impl.DishDaoImpl;
import com.ming.entity.Dish;
import com.ming.service.DishService;
import com.ming.utils.Align;
import com.ming.utils.CheckInput;

import java.util.Scanner;

public class DishServiceImpl implements DishService {

    Scanner scanner = new Scanner(System.in);

    // 该类自己包装，用于输出对齐
    Align align = new Align(15);

    // 需要 DishDao 对象修改和查看 菜品列表 数据
    DishDao dishDao = DishDaoImpl.getInstance();

    @Override
    public void like() {
        System.out.println("*****我要点赞*****");
        // 待点赞的编号
        int likeNo;
        boolean flag = false;
        do {
            // 先展示以下菜品列表
            showDishList();
            System.out.print("请输入要点赞的菜品序号(输入0返回主菜单)：");
            // 输入要点赞的菜品编号
            likeNo = CheckInput.isInputInt(scanner);
            // 判断输入编号对应菜品是否存在
            boolean isDish = isDish(likeNo);
            if (0 == likeNo) {
                flag = true;
                continue;
            }
            // 如果对应菜品不存在
            if (!isDish) {
                System.out.println("抱歉，没有找到对应的菜品");
            } else {    // 如果找到则点赞
                dishDao.getDishList().get(likeNo - 1).like();
                System.out.println("恭喜你，点赞成功！");
            }
        } while (!flag);
    }

    @Override
    public void showDishList() {
        for (Dish d : dishDao.getDishList()) {
            align.add(d.getNo()).add(d.getName()).add(d.getPrice() + "元").add((0 == d.getLikes()) ? "" : (d.getLikes() + "赞"));
            align.format();
        }
    }

    @Override
    public boolean isDish(int no) {
        return no > 0 && no <= dishDao.getDishList().size();
    }
}
