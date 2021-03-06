
public class Solution15 {

	public static void main(String[] args) {
		System.out.println(numOfTrees(3));
	}

	/**
	 * Base Case:
	 * dp[0] = 1;
	 * dp[1] = 1;
	 * Induction Rule:
	 * dp[i] = represent the maximum number of different BST generated for i;
	 * dp[i] = dp[i-1] * dp[0] + dp[i-2] * dp[1] + .... dp[i - i] * dp[i]
	 * @param n
	 * @return
	 */
	public static int numOfTrees(int n) {
		if (n <= 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2 ; i <= n ; i++) {
			for(int j = 1; j <= i ; j++) {
				dp[i] += dp[j - 1] * dp[i - j] ;
			}
		}
		return dp[n];
	}

	//Time complexity: O(n^2)
	//Space complexity: O(n)
}
