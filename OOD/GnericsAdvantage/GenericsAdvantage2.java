import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenericsAdvantage2 {

	public static void main(String[] args) {
		test2();
	}

	//1. syntax;
	public static void test1() {
		MyPair<String, Integer> p1 = new MyPair<>("a", 1);
		MyPair<String, Integer> p2 = new MyPair<String, Integer>("b", 2);
		MyPair<String, Integer> p3 = new MyPair<>("a", 1);
		
		System.out.println(p1 + " compares with " + p2 + " : " + Util.compare(p1, p2));
		System.out.println(p1 + " compares with " + p2 + " : " + Util.<String, Integer>compare(p1, p3));		
	}
	//2. number of generics
	public static <A, B, C> void printAll(A[] array, List<B> list, Queue<C> queue) {
		for (A a : array) {
			System.out.print(a + " ");
		}
		System.out.println();
		for(int i = 0 ; i < list.size() ; i++) {
			B b =list.get(i);
			System.out.print(b + " ");
		}
		System.out.println();
		while(!queue.isEmpty()) {
			C c = queue.poll();
			System.out.print(c + " ");
		}
	}
	//3. use cases
	public static <E> E findMiddle(E[] array) {
		int mid = array.length / 2;
		E midElem = array[mid];
		return midElem;
	}
	
	public static void test2() {
		Integer[] array = {1,2,3};
		List<Double> list = new ArrayList<>();
		list.add(1.5);
		list.add(2.5);
		list.add(3.5);
		Queue<String> queue = new LinkedList<>();
		queue.offer("c");
		queue.offer("o");
		queue.offer("o");
		queue.offer("l");
		printAll(array,list,queue);
	}
	
	public static void test3(){
		String[] array = {"Adama", "Bob","Cathy"};
		String mid = findMiddle(array);
		System.out.println(mid);
		
		
		//cannot be primitive, in order words, it should be object.
		Integer[] array1 = {1, 2,3};
		Integer mid1 = (int) findMiddle(array1);
		System.out.println(mid1);
	}
}