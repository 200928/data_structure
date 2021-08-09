package com.mh.tree.binarysearchtree;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/8/7 - 17:08
 * @ Description: com.mh.tree.binarysearchtree
 * @ Version: 1.0
 */
public class Person<E> implements Comparable<E> {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(E o) {
        return this.age - ((Person<E>) o).age;
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + '}';
    }
}
