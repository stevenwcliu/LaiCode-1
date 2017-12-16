import java.util.Arrays;

public class Solution3 {
	public static void main(String[] args) {
		int[] input = {2,3,4,3,5,6};
		System.out.println(Arrays.toString(quickSort(input)));
	}
	
	//what: quicksort is to choose a random number as pivot and to divide the array into two sub-arrays
	public static int[] quickSort(int[] array) {
		//how: 1. corner case
		if (array == null || array.length == 0) {
			return array;
		}
		divide(array, 0, array.length - 1);
		return array;
	}

	//3. recursively divide set to be subsets and check pivot position.
	private static void divide(int[] array, int left, int right) {
		if (left >= right) {
			return ;
		}
		int mid = pivot(array, left, right);
		divide(array, left, mid - 1);
		divide(array, mid + 1, right);
	}
	//2. randomly choose one number as a pivot number and put all smaller and equal numbers on left side and all bigger numbers on right side 
	private static int pivot(int[] array, int left, int right) {
		//2.1 randomly find the pivot and put it at the end position.
		int pivotIdx = left + (int) Math.random() * (right - left + 1);
		int pivot = array[pivotIdx];
		swap(array, pivotIdx, right);
		//2.2 compare all other numbers with the pivot and find the right positions
		int i = left;
		int j = right - 1;
		while (i <= j ) {
			if (array[i] < pivot) {
				i++;
			} else if (array[j] >= pivot) {
				j--;
			} else {
				swap(array, i++, j--);
			}
		}
		//2.3 put the pivot in the correct position.
		swap(array, i, right);
		return i;
	}
	
	private static void swap(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
	  	array[j] = temp;
	}
	// Time complexity: 
	// Divide: O(1) + O(2) + O(4) + ... + O(2logn) = O(n)
	// pivot: O(n) + O(n-1) + O(n-2) + ... O(1) = O(n*(n-1)/2) = O(n^2)
	// Space Complexity: O(1)  in-place
}