import generator.TreeNode;

public class Solution6 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		System.out.println(isTweakedIdentical(root.left, root.right));
	}
	//what: in each layer, to compare the left-subtree and right-subtree whether they are tweaked identically
	public static boolean isTweakedIdentical(TreeNode one, TreeNode two) {
		//how: 1. corner case
		if (one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if (one.key != two.key) {
			return false;
		}
		//2. compare the two situations 
		return isTweakedIdentical(one.left, two.right) &&
				isTweakedIdentical(one.right, two.left) ||
				isTweakedIdentical(one.left, two.left) &&
				isTweakedIdentical(one.right, two.right);
	}
	//Time Complexity: O(n)
	//Space Complexity: O(1)
}