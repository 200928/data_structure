package LinkedList;

/**
 * @ Author: 范名辉
 * @ Date: 2021/3/2 - 16:13
 * @ Description: LinkedList
 * @ Version: 1.0
 */

public class intersectLinkedList_相交链表相关问题 {

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

    // 判断单链表是否有环，有返回入环节点，无返回 null
    static ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != slow) {  // 相遇跳出
            // 遍历到末尾都还不相遇
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;    // 快指针重新指向头结点
        // 都走一步 相遇的节点即为入环节点
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    // 都无环情况
    static ListNode noLoop(ListNode head1, ListNode head2) {
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int len = 0;
        while (cur1.next != null) {
            len++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            len--;
            cur2 = cur2.next;
        }
        // 不相交
        if (cur1 != cur2) {
            return null;
        }
        // 相交
        // cur1 指向长链表   cur2 指向短链表
        cur1 = len > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        len = Math.abs(len);
        while (len-- != 0) {
            cur1 = cur1.next;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    // 都有环
    static ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
        // 相交并且相交点不在环上
        if (loop1 == loop2) {
            ListNode cur1 = head1;
            ListNode cur2 = head2;
            int len = 0;
            while (cur1 != loop1) {
                len++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                len--;
                cur2 = cur2.next;
            }
            cur1 = len > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            len = Math.abs(len);
            while (len-- != 0) {
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {   // 相交且在环上 或 不相交
            ListNode tmp = loop1.next;
            while (tmp != loop1) {
                if (tmp == loop2) { // 相交且在环上
                    return loop1;
                }
                tmp = tmp.next;
            }
            // 不相交
            return null;
        }
    }

    // 一起处理三种情况
    static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);
        // 都无环
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        // 都有环
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        // 只有一个无环或有环
        return null;
    }

    public static void main(String[] args) {
        ListNode head1 = null;
        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
//        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next = head1.next.next.next;

        ListNode head2 = null;
        head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = head1.next;
//        head2.next.next.next = new ListNode(4);
//        head2.next.next.next.next = new ListNode(5);
//        head2.next.next.next.next.next = new ListNode(6);
//        head2.next.next.next.next.next.next = new ListNode(7);
        System.out.println(getIntersectionNode(head1, head2).val);

    }
}

