package Twopointers;

/**
 * 旋转链表
 */
 class ListNode {
     int val;
     ListNode next;
     public  ListNode() {}
     public ListNode(int val) { this.val = val; }
     public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Hot61 {

    public ListNode rotateRight(ListNode head, int k) {
            if(head == null){
                return null;
            }
            ListNode fast = head;
            ListNode h = head;
            ListNode h1 = head;
            int length = 1;

            while(fast.next != null){
                length ++;
                fast = fast.next;
            }
            fast.next = h;
            int t = length-(k%length)-1;
            while(t != 0){
                h1 = h1.next;
                t--;
            }
            h = h1.next;
            h1.next = null;
            return h;
        }

    }
