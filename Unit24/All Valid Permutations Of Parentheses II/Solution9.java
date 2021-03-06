import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution9 {
	public List<String> validParentheses(int l, int m, int n) {
	    //keep all permutations of valil Parentheses.
	    List<String> res = new ArrayList<>();
	    //save one possbile permutation
	    char[] array = new char[2 * (l + m + n)];
	    //use a stack to store the previous left parenthese
	    Deque<Character> stack = new LinkedList<>();
	    int[] left = new int[]{l,m,n};
	    int[] right = new int[]{l,m,n};
	    validParentheses(0, left, right, stack, array, res);    
	    return res;
	  }
	  
	  //case 1: left parenthese ==> insert stack
	  //case 2: check stack ==> check numbers
	  private void validParentheses(int index, int[] left, int[] right, Deque<Character> stack, char[] array, List<String> res) {
	    if (index == array.length) {
	      res.add(new String(array));
	      return;
	    }
	    
	    if (left[0] > 0) {
	      array[index] = '(';
	      stack.offerFirst(')');
	      left[0]--;
	      validParentheses(index + 1, left, right, stack, array, res);
	      left[0]++;
	      stack.pollFirst();
	    }
	    
	    if (left[1] > 0) {
	      array[index] = '[';
	      stack.offerFirst(']');
	      left[1]--;
	      validParentheses(index + 1, left, right, stack, array, res);
	      left[1]++;
	      stack.pollFirst();
	    }
	    
	    if (left[2] > 0) {
	      array[index] = '{';
	      stack.offerFirst('}');
	      left[2]--;
	      validParentheses(index + 1, left, right, stack, array, res);
	      left[2]++;
	      stack.pollFirst();
	    }
	    
	    if (!stack.isEmpty() && stack.peekFirst() == ')' && right[0] > left[0]) {
	      stack.pollFirst();
	      array[index] = ')';
	      right[0]--;
	      validParentheses(index + 1, left, right, stack, array, res);
	      right[0]++;
	      stack.offerFirst(')');
	    }
	    
	    if (!stack.isEmpty() && stack.peekFirst() == ']' && right[1] > left[1]) {
	      stack.pollFirst();
	      array[index] = ']';
	      right[1]--;
	      validParentheses(index + 1, left, right, stack, array, res);
	      right[1]++;
	      stack.offerFirst(']');
	    }
	    if (!stack.isEmpty() && stack.peekFirst() == '}' && right[2] > left[2]) {
	      stack.pollFirst();
	      array[index] = '}';
	      right[2]--;
	      validParentheses(index + 1, left, right, stack, array, res);
	      right[2]++;
	      stack.offerFirst('}');
	    }
	    
	  }
}
