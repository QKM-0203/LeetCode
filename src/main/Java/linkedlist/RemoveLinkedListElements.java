package linkedlist;

//Remove LinkedList Elements(newSpace and VirtualHeadNode)
public class RemoveLinkedListElements {

    public ListNode removeElementsVirtualHeadNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode temp = new ListNode();
        ListNode Head = temp;
        while (head.next != null) {
            if (head.val != val) {
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        if (head.val != val) {
            temp.next = head;
        } else {
            temp.next = null;
        }
        return Head.next;
    }

    public ListNode removeElementsCreateSpace(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode temp = new ListNode();
        ListNode Head = temp;
        while (head.next != null) {
            if (head.val != val) {
                ListNode listNode = new ListNode();
                listNode.val = head.val;
                temp.next = listNode;
                temp = listNode;
            }
            head = head.next;
        }
        if (head.val != val) {
            ListNode listNode = new ListNode();
            listNode.val = head.val;
            temp.next = listNode;
        }
        return Head.next;
    }
}
