package linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode Head = head;
        ListNode tempHead = head;
        head = head.next;
        while (head != null) {
            ListNode remainingHead = head.next;
            head.next = Head;
            Head = head;
            head = remainingHead;
        }
        tempHead.next = null;
        return tempHead;
    }
}
