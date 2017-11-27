package org.leetcode.LeetCode;

public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = l1;
		int carry = 0;
		while(null != l2){
			l1.val += l2.val + carry;
			if(l1.val > 9){
				l1.val -= 10;
				carry = 1;
			}else{
				carry = 0;
			}
			if(l1.next == null || l2.next == null){
				l1.next = (l1.next == null) ? l2.next : l1.next ;
				while(carry == 1){
					l1.next = l1.next == null ? new ListNode(0):l1.next;
					l1 = l1.next;
					l1.val = l1.val + 1;
					if(l1.val > 9){
						l1.val -= 10;
						carry = 1;
					}else{
						carry = 0;
					}
				}
				break;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		AddTwoNumbers add = new AddTwoNumbers();
		ListNode l1 = add.new ListNode(5);
//		l1.next = add.new ListNode(4);
//		l1.next.next = add.new ListNode(3);
		
		ListNode l2 = add.new ListNode(5);
//		l2.next = add.new ListNode(3);
//		l2.next.next = add.new ListNode(4);
		
		add.addTwoNumbers(l1, l2);
	}


}
