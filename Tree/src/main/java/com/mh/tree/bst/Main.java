package com.mh.tree.bst;

import com.mh.tree.Visitor;
import com.mh.tree.file.Files;
import com.mh.tree.printer.BinaryTrees;

import java.util.Comparator;
import java.util.Random;

/**
 * @ Author: MingHui Fan @ Date: 2021/8/7 - 15:08 @ Description:
 * com.mh.tree.binarysearchtree @ Version: 1.0
 */
public class Main {

    // 整形二叉搜索树
    public static void test1() {
        Integer data[] = new Integer[] { 44, 35, 62, 33, 39, 59, 68, 38, 40, 57, 61, 67, 76, 60 };
        final BST<Integer> bst = new BST<>();
        for (int i : data) {
            bst.add(i);
        }
        BinaryTrees.println(bst, BinaryTrees.PrintStyle.LEVEL_ORDER);
    }

    // 自定义类型 Person 二叉搜索树 —— age大的为大
    public static void test2() {
        Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3 };
        BST<Person> bst = new BST<>();
        for (Integer integer : data) {
            bst.add(new Person(integer));
        }
        BinaryTrees.println(bst);
    }

    // 自定义类型 Person 二叉搜索树 —— age小的为大
    public static void test3() {
        Integer data[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3 };
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        };
        BST<Person> bst = new BST<>(comparator);
        for (Integer integer : data) {
            bst.add(new Person(integer));
        }
        BinaryTrees.println(bst);
    }

    // 随机生成整形二叉搜索树,并写入文件
    public static void test4() {
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 30; i++) {
            bst.add((int) (Math.random() * 100));
        }
        // BinaryTrees.println(bst, BinaryTrees.PrintStyle.LEVEL_ORDER);
        String string = BinaryTrees.printString(bst);
        string += "\n\n";
        Files.writeToFile("F:/BinarySearchTree.txt", string, true);
    }

    // 随机生成整形二叉搜索树,并测试遍历结果
    public static void test5() {
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 15; i++) {
            bst.add((int) (Math.random() * 100));
        }
        BinaryTrees.println(bst);
        Visitor<Integer> visitor = new OutTraversal<>();
        System.out.println(bst.height());
        System.out.println(bst.heightIteration());
        bst.preorderTraversal(visitor);
        bst.inorderTraversal(visitor);
        bst.postorderTraversal(visitor);
        bst.levelOrderTraversal(visitor);
    }

    // 生成一个完全二叉树并做判断
    public static void test6() {
        Integer data[] = new Integer[] { 54, 12, 64, 1, 8, 77, 36, 57, 29, 0, -2 };
        BST<Integer> bst = new BST<>();
        for (Integer datum : data) {
            bst.add(datum);
        }
        BinaryTrees.println(bst);
        System.out.println(bst.isComplete());
    }

    // 手动输入数据生成二叉搜索树，测试前驱和后继节点函数是否正确
    public static void test7() {
        Integer data[] = new Integer[] { 44, 35, 62, 33, 39, 59, 68, 38, 40, 57, 61, 67, 76, 60 };
        final BST<Integer> bst = new BST<>();
        for (int i : data) {
            bst.add(i);
        }
        BinaryTrees.println(bst, BinaryTrees.PrintStyle.LEVEL_ORDER);
        bst.inorderTraversal(new OutTraversal<Integer>());
        bst.inorderTraversal(new Visitor<Integer>() {
            public void visit(Integer element) {
                System.out.print("(前驱)");
                System.out.print(bst.predecessor(element) + " <-- " + element + " --> " + bst.successor(element));
                System.out.println("(后继)");
            }
        });
    }

    // 手动输入数据生成二叉搜索树，测试删除节点函数
    public static void test8() {
        Integer data[] = new Integer[] { 44, 35, 62, 33, 39, 59, 68, 38, 40, 57, 61, 67, 76, 60 };
        final BST<Integer> bst = new BST<>();
        for (int i : data) {
            bst.add(i);
        }
        BinaryTrees.println(bst, BinaryTrees.PrintStyle.LEVEL_ORDER);

        bst.remove(44);
        BinaryTrees.println(bst);
        bst.remove(39);
        BinaryTrees.println(bst);
    }

    public static void main(String[] args) {
        Random r = new Random();
        int n = 10;
        while (n-- > 0) {
            int rand = r.nextInt(50);
            System.out.print(rand + " ");
        }
        System.out.println();
        // test1();
        // test2();
        // test3();
        // test4();
        // test5();
        // test6();
        // test7();
        // test8();
        // String b = "\"b\"";
        // String a = b;
        // System.out.println(a);

    }
}
