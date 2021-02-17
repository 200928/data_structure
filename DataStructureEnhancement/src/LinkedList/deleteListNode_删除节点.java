package LinkedList;

/**
 * @ Author: 范名辉
 * @ Date: 2021/2/16 - 16:44
 * @ Description: LinkedList
 * @ Version: 1.0
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//
class deleteListNode_删除节点 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 双指针优化
    public static ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head = head.next;
        }
        ListNode node = head;
        while (node.next != null && node.next.val != val) {
            node = node.next;
        }
        // 判断是否存在相等的 val 值，不存在则不赋值
        node.next = node.next != null ? node.next.next : node.next;
        return head;
    }
    // 双指针
    // public ListNode deleteNode(ListNode head, int val) {
    //     if (head.val == val) return head.next;
    //     ListNode node = head;
    //     ListNode tmp = head;
    //     while (node != null) {
    //         if (node.val == val) break;
    //         tmp = node; // 指向被删除节点的上一个节点
    //         node = node.next;
    //     }
    //     if (node != null) {
    //         tmp.next = node.next;
    //     }
    //     return head;
    // }

    public static void main(String[] args) {
        ListNode head = null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode _head = head;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
        ListNode delete_node = null;
        delete_node = deleteNode(_head, 1);
        delete_node = deleteNode(_head, 3);
        delete_node = deleteNode(_head, 5);

        while (_head != null) {
            System.out.print(_head.val + " ");
            _head = _head.next;
        }
        System.out.println();
        while (delete_node != null) {
            System.out.print(delete_node.val + " ");
            delete_node = delete_node.next;
        }
    }
}