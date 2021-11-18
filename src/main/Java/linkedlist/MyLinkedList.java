package linkedlist;
//Design linked list
public class MyLinkedList {
    private ListNode head;
    private int length = 0;

    public MyLinkedList() {
    }

    public int get(int index) {
        if (index < 0 || index >= length || head == null) {
            return -1;
        }
        int i = 0;
        ListNode temp = head;
        while (i < index) {
            temp = temp.next;
            i++;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0 && head == null) {
            head = new ListNode();
            head.val = val;
            length++;
        } else if (index == 0) {
            ListNode newInsertNode = new ListNode();
            newInsertNode.val = val;
            newInsertNode.next = head;
            head = newInsertNode;
            length++;
        } else if (index <= length && head != null) {
            int key = 0;
            ListNode temp = head;
            ListNode pre = temp;
            while (key < index) {
                pre = temp;
                temp = temp.next;
                key++;
            }
            ListNode newInsertNode = new ListNode();
            newInsertNode.val = val;
            pre.next = newInsertNode;
            newInsertNode.next = temp;
            length++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
            length--;
        } else if (index < length && index > 0) {
            ListNode temp = head;
            ListNode pre = temp;
            int key = 0;
            while (key < index) {
                pre = temp;
                temp = temp.next;
                key++;
            }
            pre.next = temp.next;
            length--;
        }
    }
}
