package linkedlist;

//ReverseLinkedList
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        //首元素
        ListNode Head = head;
        //为了将首元素.next=null
        ListNode tempHead = head;
        head = head.next;
        while (head != null) {
            //留下之后的
            ListNode remainingHead = head.next;
            //头插
            head.next = Head;
            //更改头节点
            Head = head;
            //遍历留下之后的
            head = remainingHead;
        }
        //原先的首元素.next=null
        tempHead.next = null;
        return tempHead;
    }

    public static ListNode reverseListSimple(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        ListNode tempHead = head;
        head = head.next;
        while (head != null) {
            tempHead.next = head.next;
            head.next = newHead;
            newHead = head;
            head = tempHead.next;
        }
        return newHead;
    }
}
