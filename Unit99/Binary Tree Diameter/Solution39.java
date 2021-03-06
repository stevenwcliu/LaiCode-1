import generator.TreeNode;
public class Solution39 {

	public static void main(String[] args) {
		TreeNode input = new TreeNode(1);
		input.left = new TreeNode(2);
		input.right = new TreeNode(6);
		input.left.left = new TreeNode(3);

		System.out.println(diameter(input));
	}

	public static int diameter(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] max = new int[1];
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		if (left == 0 || right == 0) {
			return 0;
		}
		return Math.max(max[0], left + right + 1);	
	}
	
	private static int helper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int leftHeight = helper(root.left, max);
		int rightHeight = helper(root.right, max);
		max[0] = Math.max(max[0], leftHeight + rightHeight);
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
