package twopointers;

import linkedlist.ListNode;

/**
 * 旋转链表
 */
public class RotatingLinkedList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode tempHead = head;
        ListNode tempHeadOne = head;
        int length = 1;

        while (fast.next != null) {
            length++;
            fast = fast.next;
        }
        fast.next = tempHead;
        int t = length - (k % length) - 1;
        while (t != 0) {
            tempHeadOne = tempHeadOne.next;
            t--;
        }
        tempHead = tempHeadOne.next;
        tempHeadOne.next = null;
        return tempHead;
    }

}
