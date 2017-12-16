import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {
	Deque<Integer> in;
	Deque<Integer> out;
	public Solution1() {
		in= new LinkedList<Integer>();
		out= new LinkedList<Integer>();
	}
	
	public Integer poll() {
		move();
		if (out.isEmpty()) {
			return null;
		} else 
		{
			return out.pollFirst();
		}
	}
	
	public void offer(int element) {
		in.offerFirst(element);
	}
	
	public Integer peek() {
		move();
		if (out.isEmpty()) {
			return null;
		} else 
		{
			return out.peekFirst();
		}
	}
	
	public int size() {
		return in.size() + out.size();
	}
	
	public boolean isEmpty() {
		return in.size() + out.size() == 0;
	}
	
	private void move() {
		if (out.isEmpty()) {
			while(!in.isEmpty()) {
				out.offerFirst(in.pollFirst());
			}
		}
	}
	
}