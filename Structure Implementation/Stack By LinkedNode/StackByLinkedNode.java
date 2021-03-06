import generator.ListNode;

public class StackByLinkedNode {
	ListNode head;
	int size;
	public StackByLinkedNode() {
		head = null;
		size = 0;
	}
		
	public void push(Integer ele) {
		ListNode newHead = new ListNode(ele);
		newHead.next = head;
		head = newHead;
		size++;
	}
	public Integer peek() {
		if (size == 0) {
			return null;
		}
		return head.value;
	}
	public Integer pop() {
		if (size == 0) {
			return null;
		}
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		size--;
		return temp.value;
	}
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void print() {
		System.out.print("[");
		ListNode cur = head;
		while (cur != null) {
			if (cur.next == null) {
				System.out.print(cur.value);
			} else {
				System.out.print(cur.value + ", ");
			}
			cur = cur.next;
		}
		System.out.println("]");
	}
}
