
public class Solution7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  //Assumption: all numbers in cuts are smaller than length.
	  //Approach: solve the problem as a dynamic problem with an 2D dimension array.
	  //base rule;
	  //dp[0][1] = 0;
	  //dp[1][2] = 0;
	  //dp[2][3] = 0;
	  //dp[3][4] = 0;
	  //induction rule:
	  //dp[i][j] represents the minimum cost cutting the wood between index i and index j in the input array.
	  //the final solution return is the value of M[0][4];
	  //dp[i][j] = dp[i][k] + dp[k][j] + (array[j] - array[i]) where i< k < j;
	public int minCost(int[] cuts, int length) {
		//helper function to calculate the total cost;
		int[] helper = new int[cuts.length + 2];
		helper[0] = 0;
		for(int i = 0; i < cuts.length; i++) {
			helper[i + 1] = cuts[i];
		}
		helper[helper.length - 1] = length;
		int[][] dp = new int[helper.length][helper.length];
		for(int i = 1; i < helper.length; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(j+1 ==i) {
					dp[j][i] = 0;
				} else {
					dp[j][i] = Integer.MAX_VALUE;
					for(int k = j + 1; k <= i - 1; k++) {
						dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k][i]);
					}
					dp[j][i] += helper[i] - helper[j];
				}
			}
		}
		return dp[0][helper.length - 1];
	}

}