import generator.LinkedListRandom;
import generator.ListNode;

public class Solution4 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(10, 0, 1);
		System.out.println(numberOfNodes(input));
	}
	
	public static int numberOfNodes(ListNode head) {
		int num = 0;
		while(head != null) {
			num++;
			head = head.next;
		}
		return num;
	}
	//Time complexity: O(n)
	//Space complexity: O(1);

}
