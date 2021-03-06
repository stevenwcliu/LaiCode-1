import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {
	public static void main(String[] args){
		Solution3  s = new Solution3();
		int[] input = new int[]{5,2,1,4,3,6,2,8,3,1,4};
		System.out.println(s.maxWindows(input, 4));
	}
	  //approach: moving sliding window and only record a decending order to find the maximum numbers
	  //use deque structure: add delete first, add delete second.
	  public List<Integer> maxWindows(int[] array, int k) {
	    Deque<Integer> deque = new LinkedList<Integer>();
	    List<Integer> res = new LinkedList<Integer>();
	    for ( int i = 0 ; i < array.length ; i++) {
	      while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
	        deque.pollLast();
	      }
	      if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
	        deque.pollFirst();
	      }
				deque.offerLast(i);
	      if (i >= k - 1) {
	        res.add(array[deque.peekFirst()]);
	      }
	    }
	    return res;
	  }
	  //Time Complexity: O(n);
	  //Space Complexity: O(k);
}
