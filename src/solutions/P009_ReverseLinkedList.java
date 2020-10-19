package solutions;

import common.ListNode;

/**
 * Created by yesongren on 2020/10/20
 * 206. Reverse Linked List
 */
public class P009_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
