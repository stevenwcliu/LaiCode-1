
public class Solution6 {
	int head;
	int tail;
	int size;
	Integer[] array;
	public Solution6(int cap) {
		array = new Integer[cap];
		head = 0;
		tail = 0;
		size = 0;
	}
	
	public boolean offer(Integer ele) {
		if (size == array.length) {
			return false;
		}
		size++;
		array[tail] = ele;
		tail = (tail + 1) % array.length;
		return true;		
	}
	
	public Integer peek() {
		if (size == 0) {
			return null;
		}
		return array[head];
	}
	
	public Integer poll() {
		if (size == 0) {
			return null;
		} else {
			size--;
			Integer res = array[head];
			array[head] = null; // clearly show that is cleaned. 
			head = (head + 1) % array.length;
			return res;
		}
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}
