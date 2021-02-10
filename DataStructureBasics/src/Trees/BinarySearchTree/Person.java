package Trees.BinarySearchTree;

/**
 * @ Author: 范名辉
 * @ Date: 2021/2/6 - 16:29
 * @ Description: BinarySearchTree
 * @ Version: 1.0
 */
public class Person<E> /*implements Comparable<Person>*/ {
     private int age;

//    @Override
//    public int compareTo(Person person) {
//        return this.age - person.age;
//    }

    public int getAge() {
        return age;
    }

    public Person(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + '}';
    }
}
