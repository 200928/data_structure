package com.ming.ioc;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/18 - 下午10:51
 * @ Description: com.ming.ioc
 * @ Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("./SpringIoC/src/main/resources/spring.xml");
    }
}
