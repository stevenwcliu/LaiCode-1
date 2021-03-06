import generator.TreeNode;
public class Solution6 {

	public static void main(String[] args) {
		TreeNode input1 = new TreeNode(1);
		input1.left = new TreeNode(2);
		input1.right = new TreeNode(3);
		input1.left.left = new TreeNode(4);
		input1.left.right = new TreeNode(5);
		input1.right.left = new TreeNode(6);
		input1.right.right = new TreeNode(7);
		lowestCommonAncestor(input1, input1.left.left, input1.left.right).print();
	}
	
	
	//what: to find the recent common parent for TreeNode one, and two
	//How: 
	//1. base case. if the current root is null || one || two ,then just return it.
	//2. if there both one/ two in the subtree, return the LCA
	//2.1 one is two`s descendant, return one.
	//2.2 two is one`s descendatn, return two.
	//2.3 otherwise, return the lowest node with one and tow in the tow different subtrees.
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		//1. base cases.
		if(root == null) {
			return null;
		}
		//2.1 
		if (root == one || root == two) {
			return root;
		}
		//2. get the TreeNode if there is one or two in the subtrees.
		TreeNode left = lowestCommonAncestor(root.left, one, two);
		TreeNode right = lowestCommonAncestor(root.right, one, two);
		//2.3. 
		if (left != null && right != null) {
			return root;
		}
		//2.2
		return left == null ? right : left;
	}
	//Time Complexity: O(N)
	//Space Complexity: O(1)
}

	
