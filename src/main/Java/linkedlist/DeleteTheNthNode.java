package linkedlist;

//removeNthFromEnd
public class DeleteTheNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempHead = new ListNode();
        tempHead.next = head;
        ListNode fast = tempHead;
        ListNode slow = tempHead;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return tempHead.next;
    }
}
