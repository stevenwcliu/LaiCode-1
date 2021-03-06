
public class Solution1 {

	public static void main(String[] args) {
		int[] input = {5,3,1,4,6,2,3};
		System.out.println(maxTrapped(input));
	}
	
	/*
	Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.
	
	Assumptions
	
	The given array is not null
	Examples
	
	{ 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2 (at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)
	 */
	
	//approach: solve the problem as dynamic problem
	//dpLeft[0] = array[0];
	//dpLeft[i] represents the highest bar from 0th to ith elements.
	//dpRight[n-1] = array[n-1]
	//dpRight[i] represent the highest bar from n-1th to ith elements.
	public static int maxTrapped(int[] array) {
		//corner case;
		if (array.length <= 2) {
			return 0 ;
		}
		int len = array.length;
		int[] left = new int[len];
		left[0] = array[0];
		int[] right = new int[len];
		right[len - 1] = array[len - 1];
		//fill left array.
		for (int i = 1; i < len ; i++) {
			left[i] = Math.max(left[i - 1], array[i]);
		}
		//fill right array;
		for (int i = len - 2; i >= 0 ; i--) {
			right[i] = Math.max(right[i + 1], array[i]);
		}
		int total = 0;
		for (int i = 0; i < len ; i++) {
			total += Math.min(left[i], right[i]) - array[i];			
		}
		return total;
	}
	//Time complexity: O(n)
	//Space complexity: O(n)
	
	//optimize the problem as two pointers.
	public static int maxTrapped1(int[] array) {
		if (array.length <= 2) {
			return 0;
		}
		int left = 0;
		int right = array.length - 1;
		int leftMax= 0;
		int rightMax = 0;
		int total = 0;
		while (left < right) {
			if (array[left] > array[right]) {
				if (array[left] > leftMax) {
					leftMax = array[left];
				}
				total += leftMax - array[left];
				left++;
			} else {
				if (array[right] > rightMax) {
					rightMax = array[right];
				}
				total += rightMax - array[right];
				right--;
			}
		}
		if (array[left] < Math.min(leftMax, rightMax)) {
			total += Math.max(leftMax, rightMax) - array[left];
		}
		return total;
	}
	//Time complexity: O(n)
	//Space complexity: O(1)
}
