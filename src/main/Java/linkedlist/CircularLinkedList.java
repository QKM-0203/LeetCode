package linkedlist;

/**
 * Circular linked list
 */
public class CircularLinkedList {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) break;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow != fast) return null;
        ListNode p = new ListNode(0);
        p.next = head;
        while (p != slow) {
            p = p.next;
            assert slow != null;
            slow = slow.next;
        }
        return p;
    }
}
