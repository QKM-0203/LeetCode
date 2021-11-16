package linkedlist;

/**
 * Merge ascending linked list
 */
public class MergeAscendingLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pc = new ListNode();
        ListNode p = pc;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pc.next = l1;
                l1 = l1.next;
            } else {
                pc.next = l2;
                l2 = l2.next;
            }
            pc = pc.next;
        }
        if (l1 == null) {
            pc.next = l2;
        } else {
            pc.next = l1;
        }
        return p.next;
    }

    //合并k个升序列表，0和1 2和3 最终还是两两合并，每次改变len就行
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        while (len > 1) {
            int k = 0;
            for (int i = 0; i < len; i += 2) {
                lists[k++] = i + 1 < len ? mergeTwoLists(lists[i], lists[i + 1]) : lists[i];
            }
            len = k;
        }
        return lists[0];
    }
}
