package LinkedList;

import java.util.Stack;

/**
 * @ Author: 范名辉
 * @ Date: 2021/2/10 - 13:19
 * @ Description: LinkedList
 * @ Version: 1.0
 */
// https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
public class isPalindromeLinkedList_回文链表 {

    //Linked List:
    //1 2 3 null
    //null
    //true

    // 把整个链表压栈，然后遍历链表和弹栈结果是否一致
    public static <E> boolean isPalindrome0(LinkedList<E> head) {
        if (head == null || head.root == null) return false;
        LinkedList<E> node = head;
        Stack<E> stack = new Stack<>();
        while (node.root != null) {
            stack.push((E) node.root.element);
            node.root = node.root.next;
        }

        System.out.println(head.root);
        System.out.println(node.root);
        while (node.root != null) {
            if (node.root.element != stack.pop()) {
                return false;
            }
            node.root = node.root.next;
        }
        return true;
    }

    // ======================================链表建立
    static class LinkedList<E> {

        Node root = null;

        int size = 0;

        public class Node<E> {
            E element;
            Node next;

            public Node(E element) {
                this.element = element;
            }
        }

        public int size() {
            return size;
        }

        public void add(E element) {
            add(element, size);
        }

        public void add(E element, int index) {
            Node<E> prev = root;
            if (index == 0) {
                root = new Node(element);
//                prev = new Node(element); // 这样写不能讲新节点加到 root 下
            } else {
                prev = node(index - 1);
                Node<E> newnode = new Node(element);
                newnode.next = prev.next;
                prev.next = newnode;
            }
            size++;
        }

        private Node<E> node(int index) {
            if (index < 0 || index > size) {
                return null;
            }
            Node<E> node = root;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }

        public void printLinkedList() {
            Node<E> node = root;
            if (node == null) {
                System.out.println("The list is empty");
                return;
            }
            System.out.println("Linked List: ");
            while (node != null) {
                System.out.print(node.element + " ");
                node = node.next;
            }
            return;
        }
        // ======================================链表建立完成
    }


    public static void main(String[] args) {
        LinkedList<Integer> head = new LinkedList<>();
        head.add(1);
        head.add(2);
        head.add(3);
        head.printLinkedList();
        System.out.println(isPalindrome0(head));
    }


}
