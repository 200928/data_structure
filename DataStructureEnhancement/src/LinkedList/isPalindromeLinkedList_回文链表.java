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

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    static void printLinkedList(ListNode head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // 把整个链表压栈，然后遍历链表和弹栈结果是否一致
    public static boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        while (head != null && stack.pop().val == head.val) {
            head = head.next;
        }
        return head == null ? true : false;
    }

    // 半个链表压栈
    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head.next;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 此时slow指向中点或者对称轴的下一个
        Stack<ListNode> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
//            System.out.print(slow.val + "_");
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 用偶数个举例，如链表为 1 -> 2 -> 3 -> 4 -> 5 -> 6
    public static boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) return true;

        // step1：找到中点位置，偶数为对称轴前一个，奇数为中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // step2：反转后半部分链表
        // 此时 slow 指向中点或者对称轴的前一个，也就是相当于反转部分的头结点
        // 即 slow 指向 3，接下来要反转后面部分得到：1 -> 2 -> 3 <- 4 <- 5 <- 6
        fast = slow.next;
        ListNode tmp = null;
        slow.next = null;
        while (fast != null) {
            tmp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = tmp;
        }
        tmp = slow; // 指向最后一个节点（或者后部分链表的头结点）这里后面会用到

        // step3：将两边链表分别遍历比对
        // 此时slow指向反转链表的首节点，也就是原链表的最后一个
        // 1 -> 2 -> 3 <- 4 <- 5 <- 6 slow 指向 6
        // 然后我们依次遍历两边的链表
        fast = head;
        boolean ans = true;
        while (fast != null && slow != null) {
//            System.out.print("fast:" + fast.val + ",slow:" + slow.val + "\n");
            if (fast.val != slow.val) {
                ans = false;
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }

        // step4：链表复原
        // 此时 slow 指向 3，fast 指向 null
        // 如果是奇数个 slow、fast 都指向 null，所以要重新赋值
        slow = tmp;
        fast = slow.next;
        while (fast != null) {
            tmp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head));

    }
}
