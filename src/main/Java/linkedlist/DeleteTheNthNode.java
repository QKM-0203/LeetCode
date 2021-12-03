package linkedlist;

public class DeleteTheNthNode {
    /**
     * 思路：x+y=length,y==n,则fast先走y长度，也就是n,然后slow和fast一起走y,则第y+1就是倒数第n个元素
     */
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
