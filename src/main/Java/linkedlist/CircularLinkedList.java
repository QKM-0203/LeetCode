package linkedlist;
/**
 * CircularLinkedList
 * <p>when finding the node where the fast and slow nodes meet, the ring entrance is obtained by equal
 * distances from the head node to the ring entrance and from the meeting node to the ring entrance</p>
 */
public class CircularLinkedList {
    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }
}
