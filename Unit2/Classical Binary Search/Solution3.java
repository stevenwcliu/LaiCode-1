public class Solution3 {

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5};
		System.out.println(binarySearch(input, 3));
	}
	//what: find the index of target with binary search on ordered data
	public static int binarySearch(int[] array, int target) {
		//how: 1. corner case
		if (array == null || array.length ==0) {
			return -1;
		}
		//2. find the mid check iteratively.
		int left = 0; 
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left + 1) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return  -1;
	}
	//Time Complexity: O(logn)
	//Space Complexity: O(1)
}
