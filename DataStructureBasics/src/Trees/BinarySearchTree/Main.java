package Trees.BinarySearchTree;

import Trees.BinarySearchTree.printer.BinaryTrees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ Author: 范名辉
 * @ Date: 2021/2/6 - 16:33
 * @ Description: BinarySearchTree
 * @ Version: 1.0
 */
public class Main {

    static void test1() {

        // 比较器一
        Comparator<Person> personComparator = new Comparator<Person>() {
            public int compare(Person person, Person t1) {
                return person.getAge() - t1.getAge();
            }
        };
        // 比较器二
        Comparator<Person> personComparator1 = new Comparator<Person>() {
            public int compare(Person person, Person t1) {
                return t1.getAge() - person.getAge();
            }
        };

        Integer[] data = new Integer[]{
                8, 3, 10, 1, 6, 14, 4, 7, 13
        };

        // 传入比较器
        BinarySearchTree<Person> bstPerson0 = new BinarySearchTree<>(personComparator);
        for (int i : data) {
            bstPerson0.add(new Person(i));
        }
//        BinaryTrees.println(bstPerson0); // 打印树

        // 传入比较器
        BinarySearchTree<Person> bstPerson1 = new BinarySearchTree<>(personComparator1);
        for (Integer i : data) {
            bstPerson1.add(new Person(i));
        }
//        BinaryTrees.println(bstPerson1); // 打印树

        // 匿名类比较器
        BinarySearchTree<Person> bstPerson2 = new BinarySearchTree<>(new Comparator<Person>() {
            public int compare(Person person, Person t1) {
                return person.getAge() - t1.getAge();
            }
        });
    }

    private static void test2() {
         /*
            rand.nextInt(num) 生成 [0, num) <-> [0, num - 1] 随机数
            生成 [begin, end] 随机数
                <-> 生成 [0, end - begin] + begin 然后把 end - begin == num - 1
                得到 num = end - begin + 1
                <-> rand.nextInt(num) + begin == rand.nextInt(end - begin + 1) + begin
         */
        BinarySearchTree<Integer> bstInteger = new BinarySearchTree<Integer>();
//        for (int begin = 0; begin < 5; begin++) {
//            // 生成 1 - 20 随机数
//            bstInteger.add(new Random().nextInt(20) + 1);
//        }
        Integer[] data = new Integer[]{8, 3, 10, 1, 6, 9};
        for (int i : data) bstInteger.add(i);
//        bstInteger3.print();
        BinaryTrees.println(bstInteger);

        System.out.print("\n" + "层序遍历 : ");
        bstInteger.levelOrderTraversal(new BinarySearchTree.Visitor<>() {
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return false;
            }
        });

        System.out.print("\n" + "前序遍历 : ");
        bstInteger.preOrderTraversal(new BinarySearchTree.Visitor<>() {
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return false;
            }
        });

        System.out.print("\n" + "中序遍历 : ");
        bstInteger.inorderTraversal(new BinarySearchTree.Visitor<>() {
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return false;
            }
        });

        System.out.print("\n" + "后续遍历 : ");
        bstInteger.postOrderTraversal(new BinarySearchTree.Visitor<>() {
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return false;
            }
        });

        System.out.println("\n" + bstInteger.heightRecursive());
        System.out.println(bstInteger.heightIteration());
        System.out.println(bstInteger.isComplete());
        System.out.println(bstInteger.isCompleteOptimization());

    }

    public static void main(String[] args) {

        test2();
        List<Integer> lsit = new ArrayList<>();


    }

}
