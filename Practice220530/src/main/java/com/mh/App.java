package com.mh;

import com.mh.foodie.Menu;

import java.io.IOException;
import java.io.Serializable;

/**
 * Hello world!
 */
public class App implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Menu menu = new Menu();
        menu.showMenu();
        menu.selectMenu();
//        File file = new File("/mnt/file/Code/JAVA_IDEA/JavaSE_study/Test/src/main/resources/data");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Data data = new Data();
//        data = (Data) objectInputStream.readObject();
//        System.out.println(data);
    }
}
