
public class MergeSortTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortTest s1 = new MergeSortTest();
		int[] test = new int[55];
		for (int i = 0 ; i<55 ; i++) {
			test[i] = 55 - i;
		}		
		s1.mergeSort(test);
		for(int i = 1; i < test.length; i++) {
			if (test[i] < test[i - 1]) {
				System.out.println(false);
			}
		}
		System.out.println(true);
	}
	
	public void mergeSort(int[] array) {
		mergeSort(array,0,array.length - 1);
	}
	
	
//	public void swap(int[] array, int i1, int i2, int j1, int j2) {
//		reverse(array,i1,i2);
//		reverse(array,j1,j2);
//		reverse(array,i1,j2);
//	}
//	not useful in this case	
//	
	public void mergeSort(int[] array, int left, int right) {
		if(left >= right) {
			return;
		}
		int mid =  left + 1/2 * (right - left);
		mergeSort(array,left, mid);
		mergeSort(array, mid + 1, right);
		merge(array, left, mid, right);
	}
	public void merge(int[] array, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int id = j;
		while(i <= mid && array[i] < array[j]) {
			i++;
		}
		while(j <= right && array[i] > array[j] ) {
			j++;
		}
		reverse(array, i, id - 1);
		reverse(array, id, j - 1);
		reverse(array, i, j - 1);
		id = j;
	
	}
	//reverse array i to j
	public void reverse(int[] array, int i, int j) {
		if(i > j || i < 0 || j < 0) {
			
		}
		int temp;
		while(i < j) {
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}
	}

}
