package LinkedList;

/**
 * @ Author: 范名辉
 * @ Date: 2021/2/22 - 19:01
 * @ Description: LinkedList
 * @ Version: 1.0
 */

// https://leetcode-cn.com/problems/partition-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class partitionList_分隔链表 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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

    static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode sH = null;     // 指向小于的头
        ListNode sT = null;     // 指向小于的尾
        ListNode bH = null;     // 指向等于大于的头
        ListNode bT = null;     // 指向等于大于的尾
        // 为了每一步的尾指针的next都指向null，为后续方便
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                if (sT == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else {
                if (bT == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        // 此时 sT 和 bT 两者中至少有一个不为空,因此有3种情况
        // 10   11   01
        if (sT == null) {
            return bH;
        } else {
            sT.next = bH;
            return sH;
        }
    }

    static ListNode partitionAdvanced(ListNode head, int x) {
        ListNode sH = null;     // 指向小于的头
        ListNode sT = null;     // 指向小于的尾
        ListNode eH = null;     // 指向等于的头
        ListNode eT = null;     // 指向等于的尾
        ListNode bH = null;     // 指向大于的头
        ListNode bT = null;     // 指向大于的尾
        // 保证每次的sT、eT、bT的next都指向null，为了后续方便
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.val == x) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        // 一共8种情况
        // 000  100
        // 001  101
        // 010  110
        // 011  111

        if (sT == null) {
            if (eT == null) {
                return bH;
            } else {
                eT.next = bH;
                return eH;
            }
        } else {
            if (eT == null) {
                sT.next = bH;
                return sH;
            } else {
                sT.next = eH;
                eT.next = bH;
                return sH;
            }
        }

//        if (sT != null) {   // 小于部分不为空
//            sT.next = eH;
//            // 如果 eT 为空指向小于头，不为空不处理
//            eT = eT == null ? sT : eT;
//        }
//        if (eT != null) {   // 等于部分不为空
//            eT.next = bH;
//        }
//        return sH != null ? sH : eH != null ? eH : bH;
    }


    public static void main(String[] args) {
        ListNode head = null;
        head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        printLinkedList(head);
        printLinkedList(partition(head, 2));
//        printLinkedList(partitionAdvanced(head, 2));

        head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(4);
        printLinkedList(head);
        printLinkedList(partition(head, 3));
//        printLinkedList(partitionAdvanced(head, 3));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        printLinkedList(head);
        printLinkedList(partition(head, 3));
//        printLinkedList(partitionAdvanced(head, 3));
    }
}
