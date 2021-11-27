package linkedlist;

//SwapPairs
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode headNext = head.next;
        ListNode headNextNext = headNext.next;
        headNext.next = head;
        head.next = headNextNext;
        head = headNext;
        ListNode temp = head.next;
        while (temp.next != null) {
            ListNode temp1 = temp.next;
            if (temp1.next == null) {
                return head;
            }
            ListNode temp2 = temp1.next;
            ListNode temp3 = temp2.next;
            temp2.next = temp1;
            temp1.next = temp3;
            temp.next = temp2;
            temp = temp1;
        }
        return head;
    }
}
