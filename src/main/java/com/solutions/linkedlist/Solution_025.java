package main.java.com.solutions.linkedlist;

/**
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * <p>
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 */
public class Solution_025 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);

        Solution_025 solution_025 = new Solution_025();
        solution_025.reverseKGroup(a, 2);

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2 || head == null || head.next == null) {
            return head;
        }
        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        ListNode node = sentry;
        int i = 0;
        while (node.next != null) {
            ListNode tem = node;
            while (tem.next != null && i < k) {
                tem = tem.next;
                i++;
            }
            if (i == k) {
                ListNode next = tem.next; // 下次起点
                ListNode pre = node.next; // 反转后的终点
                tem.next = null;
                node.next = reverse(node.next);
                pre.next = next;
                node = pre;
                i = 0;
            } else {
                break;
            }
        }

        return sentry.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;

            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
