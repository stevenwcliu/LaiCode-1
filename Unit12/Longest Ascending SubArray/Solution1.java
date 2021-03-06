
public class Solution1 {

	public static void main(String[] args) {
		int[] input = {1,23,4,567,74,2,4};
		System.out.println(longest(input));
	}
	
	/**
	 * Base case: M[0] = 0;
	 * Induction Rule: 
	 * 1. M[i] = represents the max length of ascending subset from 0th element and end at the ith element included ith element.
	 * 2. M[i] = M[i - 1] + 1 	where M[i] <= M[i - 1]
	 * 		   = 0 				otherwise
	 * @param array
	 * @return
	 */
	public static int longest(int[] array) {
		if (array.length <= 1) {
			return array.length;
		}
		int cur = 1; 
		int max = 1;
		for (int i = 1 ; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				cur++;
				max = Math.max(max, cur);
			} else {
				cur = 1;
			}
		}
		return max;
	}
	//Time complexity: O(n)
	//Space Complexity: O(n)

}
