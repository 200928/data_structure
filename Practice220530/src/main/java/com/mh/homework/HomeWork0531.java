package com.mh.homework;

import java.util.Scanner;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/5/31 - 下午4:20
 * @ Description: com.mh
 * @ Version: 1.0
 */
public class HomeWork0531 {

    public void homeWork1() {
        String name = "小明";
        int age = 25;
        int workYear = 3;
        int projectNumber = 5;
        String way = "java";
        String hobby = "篮球";

        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
        System.out.println("工作了" + workYear + "年");
        System.out.println("做过了" + projectNumber + "个项目");
        System.out.println("技术方向是" + way);
        System.out.println("兴趣爱好是" + hobby);
    }

    public void homeWork2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入4位会员卡号：");
        int cardId = scanner.nextInt();
        System.out.println("您输入的卡号是：" + cardId);
    }

    public void homeWork3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入4位会员卡号：");
        int cardId = scanner.nextInt();
        int sum = 0;
        int[] sums = new int[String.valueOf(cardId).length()];
        int _cardId = cardId;
        for (int i = 0; i < 4; i++) {
            sums[i] = _cardId % 10;
            _cardId /= 10;
            sum += sums[i];
        }
        System.out.print("千位数：" + sums[3]);
        System.out.print("，百位数：" + sums[2]);
        System.out.print("，十位数：" + sums[1]);
        System.out.println("，个位数：" + sums[0]);
        System.out.println("各位数之和为：" + sum);
    }

    public void homeWork4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入4位会员卡号：");
        int cardId = scanner.nextInt();
        int[] sums = new int[String.valueOf(cardId).length()];
        int sum = 0;
        int _cardId = cardId;
        for (int i = 0; i < 4; i++) {
            sums[i] = _cardId % 10;
            _cardId /= 10;
            sum += sums[i];
        }
        System.out.print("千位数：" + sums[3]);
        System.out.print("，百位数：" + sums[2]);
        System.out.print("，十位数：" + sums[1]);
        System.out.println("，个位数：" + sums[0]);
        System.out.println("会员卡号：" + cardId + "各位之和为：" + sum);
        if (sum > 20) {
            System.out.println("会员卡号为：" + cardId + "的会员，您中奖了！，奖品是MP5");
        } else {
            System.out.println("会员卡号为：" + cardId + "的会员，您还差一点就中奖了，真可惜啊！");
        }

    }

    public static void main(String... args) {
        HomeWork0531 homeWork0531 = new HomeWork0531();
        System.out.println("===========homeWork1============");
        homeWork0531.homeWork1();
        System.out.println("===========homeWork2============");
        homeWork0531.homeWork2();
        System.out.println("===========homeWork3============");
        homeWork0531.homeWork3();
        System.out.println("===========homeWork4============");
        homeWork0531.homeWork4();
    }


//        test2();
//        test3();
//        Person.person();
//        Person.person();
//        Person person = new Person();
//        person.person();
//        person.setNum();
//        Person.person();
//        Person.person();
}
