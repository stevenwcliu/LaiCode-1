
public class Solution2 {

	public static void main(String[] args) {
		System.out.println(power(2,4));
	}
	//what: calculate a to the power of b with recursive function
	public static long power(int a, int b) {
		//how: 1. corner case
		if (b == 1) {
			return a;
		} else if (b == 0) {
			return 1;
		}
		//2. change it as the production of two numbers
		long half = power (a, b/2);
		return b % 2 == 0 ? half * half : half * half * a; 
	}
	//Time Complexity: log(b)
	//Space Complexity: O(1)
}