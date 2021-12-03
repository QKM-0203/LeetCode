package linkedlist;
/**
 * 思路：当找到快速和慢速节点相遇的节点时，通过相等的方式获得环形入口，从头部节点到环形入口以及从相遇节点到环形入口的距离是相等的
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
