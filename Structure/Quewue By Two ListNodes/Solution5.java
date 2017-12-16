import generator.ListNode;
public class Solution5 {
	ListNode head;
	ListNode tail;
	public Solution5() {
		head = null;
		tail = null;
	}
	
	public Integer poll() {
		if (head == null) {
			return null;
		} else {
			ListNode temp = head;
			head = head.next;
			temp.next =null;
			if (head == null) {
				tail = null;
			}
			return temp.value;
		}
	}
	
	public Integer peek() {
		if (head == null) {
			return null;
		}
		return head.value;
	}
	
	public void push(Integer ele) {
		ListNode node = new ListNode(ele);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = tail.next;
		}
	}
	
}