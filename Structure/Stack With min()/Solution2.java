import java.util.Stack;

public class Solution2 {
	Stack<Integer> set = new Stack<Integer>();
	Stack<Integer> minSet = new Stack<Integer>();
	public Solution2() {
		
	}
	
	public int pop() {
		if (set.isEmpty()) {
			return -1;
		}
		int res = set.pop();
		if (minSet.peek().equals(res)) {
			minSet.pop();
		}
		return res;
	}
	
	public void push(int element) {
		set.push(element);
		if (minSet.isEmpty() || minSet.peek() >= element) {
			minSet.push(element);
		}
	}

	public int min() {
		if (minSet.isEmpty()) {
			return -1;
		}
		return minSet.peek();
	}
	
	public int top() {
		if (set.isEmpty()) {
			return -1;
		}
		return set.peek();
	}
}