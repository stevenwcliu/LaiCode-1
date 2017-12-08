import java.util.Arrays;

public class Solution4 {

	public static void main(String[] args) {
		int[] input = {0,1,1,1,-1,-1,1,0};
		System.out.println(Arrays.toString(rainbowSort(input)));
	}

	//what:  find -1s put in left side, find 1s and put them in right side. others in mid. 
	public static int[] rainbowSort(int[] array) {
		//how: 1. corner case
		if (array == null || array.length <= 1) {
			return array;
		}
		//2. traverse all numbers 
		int neg = 0;
		int zero = 0;
		int pos = array.length - 1; 
		while (zero <= pos) {
			if (array[zero] == -1) {
				swap(array, neg++, zero++);
			} else if (array[zero] == 0) {
				zero++;
			} else if (array[zero] == 1) {
				//zero without ++ because I do not know what zero in pos.
				swap(array, pos--, zero);
			}
		}
		return array;
	}

	private static void swap(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
	  	array[j] = temp;
	}
	//Time Complexity: O(n)
	//Space Complexity: O(1)
}
