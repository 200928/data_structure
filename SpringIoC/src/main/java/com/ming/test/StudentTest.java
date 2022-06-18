package com.ming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/18 - 下午10:07
 * @ Description: com.ming.test
 * @ Version: 1.0
 */
public class StudentTest {
   public static void main(String[] args) {
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
      Object student = (Object) applicationContext.getBean("student");
      System.out.println(student);
   }
}
