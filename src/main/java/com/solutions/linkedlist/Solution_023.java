package main.java.com.solutions.linkedlist;

import java.util.List;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 */
public class Solution_023 {

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        while (length > 1) {
            for (int i = 0; i < length / 2; i++) {
                lists[i] = mergeTwoNodeList(lists[i], lists[length - i - 1]);
            }
            length = length / 2 + length % 2;
        }
        return lists[0];
    }

    // 两个合并为一个
    private static ListNode mergeTwoNodeList(ListNode l1, ListNode l2) {
        // 哨兵
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                pre.next = l2;
                return head.next;
            }
            if (l2 == null) {
                pre.next = l1;
                return head.next;
            }
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
