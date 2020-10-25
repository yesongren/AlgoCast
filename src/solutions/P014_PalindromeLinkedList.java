package solutions;

import common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yesongren on 2020/10/22
 * 234. Palindrome Linked List
 */
public class P014_PalindromeLinkedList {
    public boolean isPalindromeStack(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (ListNode p = head; p != null; p = p.next) {
            stack.push(p.val);
        }
        for (ListNode p = head; p != null; p = p.next) {
            if (p.val != stack.pop()) return false;
        }
        return true;
    }

    public boolean isPalindromeReverseHalf(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        ListNode cur = head, pre = null;
        for (int i = 0; i < len / 2; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (len % 2 != 0) cur = cur.next;
        while (pre != null && cur != null) {
            if (pre.val != cur.val) return false;
            pre = pre.next;
            cur = cur.next;
        }
        return true;
    }
}
