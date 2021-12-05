package linkedlist;

//时间复杂度：o(n)
//空间复杂度：o(n)(包含返回的数组)
//逆序打印还可以想到栈
public class PrintLinkedListFromEndToEnd {
    public static int[] reversePrint(ListNode head) {
        ListNode tempHead = head;
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }

        int[] ints = new int[length];
        while (tempHead != null) {
            ints[length--] = tempHead.val;
            tempHead = tempHead.next;
        }
        return ints;
    }
}
