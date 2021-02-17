package LinkedList;

/**
 * @ Author: 范名辉
 * @ Date: 2021/2/16 - 14:49
 * @ Description: LinkedList
 * @ Version: 1.0
 */

//*
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }
//
// https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
class reverseLinkedList_反转链表 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

//    // 法一：栈
//    public static ListNode reverseList(ListNode head) {
//        ListNode node = head;
//        Stack<Integer> stack = new Stack<>();   // 将节点的 val 值存到栈中
//        // 入栈
//        while (node != null) {
//            stack.push(node.val);
//            node = node.next;
//        }
//        node = head;
//        // 覆盖值
//        while (!stack.isEmpty()) {
//            node.val = stack.pop();
//            node = node.next;
//        }
//        return head;
//    }

    // 法二：用两个指针
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode list = head.next;
        ListNode tmp;
        pre.next = null;
        while (list != null) {
             tmp = list.next;
             list.next = pre;
             pre = list;
             list = tmp;
        }
        return pre;
    }

    // 测试
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        ListNode head = reverseList(list);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}