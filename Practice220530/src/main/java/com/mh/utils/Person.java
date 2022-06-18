package com.mh.utils;

import java.io.IOException;
import java.io.Serializable;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/6/9 - 下午3:51
 * @ Description: com.mh.utils
 * @ Version: 1.0
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 7592930394427200495L;
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名:" + name + "年龄:" + age;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //实例化一个需要序列化的Person对象
//        Person jack = new Person("jack", 12);
//        //生成一个文件对象,文件不存在将自动创建文件
//        File f = new File("/home/minghui/serTest.txt");
//        //构造一个对象输出流oos
//        ObjectOutputStream oos = null;
//        //构造一个文件输出流
//        FileOutputStream fileOutputStream = new FileOutputStream(f);
//        //构造对象输出流
//        oos = new ObjectOutputStream(fileOutputStream);
//        //序列化一个对象到文件变成二进制内容
//        oos.writeObject(jack);
//        oos.close();
//        FileInputStream fileInputStream = new FileInputStream("/home/minghui/serTest.txt");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Person person = (Person)objectInputStream.readObject();
//        System.out.println(objectInputStream);
//        System.out.println(person);

    }
}
