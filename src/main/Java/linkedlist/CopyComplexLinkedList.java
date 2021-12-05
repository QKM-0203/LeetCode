package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyComplexLinkedList {
    /**
     * 回溯的解决办法，将旧的节点和新的节点以map的形式存储，然后一边创建新的链表，
     * 同时利用（创建新链表）结束来给新的random赋值（通过旧的节点获取新的节点）
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     */
    Map<ListNode, ListNode> nodeMap = new HashMap<>();

    public ListNode copyRandomListToFlashBack(ListNode head) {
        if (head == null) {
            return null;
        }
        if (!nodeMap.containsKey(head)) {
            ListNode headNew = new ListNode(head.val);
            nodeMap.put(head, headNew);
            headNew.next = copyRandomListToFlashBack(head.next);
            headNew.random = copyRandomListToFlashBack(head.random);
        }
        return nodeMap.get(head);
    }

    /**
     * 同样是将旧的节点和新的节点以map的形式存储，首先创建新链表，创建的同时put节点进map.因为random的
     * 指向是链表中的节点或者null,所以重点就是怎末获取到random指向哪个节点（新链表），而这个节点可以根据旧链表
     * 的random的指向在map中找到，所以最终遍历一遍旧链表和新链表通过 新.random = map.get(旧.random)
     * 在旧链表当中指向的是7,在新链表当中指向的还是7。
     * 时间复杂度：o(n)（最终还循环了一遍）
     * 空间复杂度：o(n)
     */
    public ListNode copyRandomList(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>();
        if (head == null) {
            return null;
        }
        ListNode tempHead = new ListNode(0);
        ListNode newHead = tempHead;
        ListNode Head = newHead;
        ListNode temp = head;
        while (head != null) {
            ListNode listListNode = new ListNode(head.val);
            map.put(head, listListNode);
            tempHead.next = listListNode;
            tempHead = tempHead.next;
            head = head.next;
        }
        tempHead.next = null;
        while (temp != null && newHead.next != null) {
            newHead.next.random = map.get(temp.random);
            temp = temp.next;
            newHead = newHead.next;
        }
        return Head.next;
    }
}
