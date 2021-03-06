import generator.ListNode;

public class Solution5 {

	public static void main(String[] args) {
		ListNode input1 = new ListNode(1);
		input1.next = new ListNode(3);
		ListNode input2 = new ListNode(2);
		input2.next = new ListNode(4);
		ListNode output  = merge2(input1, input2);
		output.print();
	}
	//what: find the smaller number form one and two and more it to the end of listNode, and do it iteratively.
	public static ListNode merge(ListNode one, ListNode two) {
		//how: 1. corner case
		if (one == null) {
			return two;
		}
		if (two == null) {
			return one;
		}
		//2. define a new ListNode 
		ListNode newHead = new ListNode(-1);
		ListNode cur = newHead;
		//3. find the smaller number from one and two;
		while(one != null && two != null) {
			if (one.value < two.value) {
				cur.next = one;
				one = one.next;
			} else {
				cur.next = two;
				two = two.next;
			}
			cur = cur.next;
		}
		//4. find the remaining from one or two.
		if (one != null) {
			cur.next = one;
		}
		if (two != null) {
			cur.next = two;
		}
		return newHead.next;
	}

	//what: find the smaller number form one and two and more it to the end of listNode, and do it iteratively.
	public static ListNode merge2(ListNode one, ListNode two) {
		//how: 1. corner case
		if (one == null) {
			return two;
		}
		if (two == null) {
			return one;
		}
		//2. find the smaller node recursively 
		if (one.value < two.value) {
			one.next = merge(one.next, two);
			return one;
		} else {
			two.next = merge(one, two.next);
			return two;
		}
	}
	//Time Complexity: O(n + m);
	//Space Complexity: O(n);
}
