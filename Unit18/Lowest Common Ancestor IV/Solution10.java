import java.util.List;

import generator.TreeNode;
public class Solution10 {

	public static void main(String[] args) {

	}
	  //Approach: recursively traverse all nodes in the tree with DFS.
	  //how many levels: it may be n levels. n is the number of nodes.
	  //how many branches: each node could have at most 2 nodes.
	  //left, right: they will check wheheter they could find nodes in subtress where they are the roots
	  //current level: compare the result from left and right;
	  //return: 
	  //1. left = null , right = null ==> return null
	  //2. left = one or two, right = one or two ==> return root
	  //3. only one child return non-null value ==> return non-null value.
	  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
	    //base case
	    if (root == null || nodes.contains(root)) {
	      return root;
	    }
	    TreeNode left = lowestCommonAncestor(root.left, nodes);
	    TreeNode right = lowestCommonAncestor(root.right, nodes);
	    if (left != null && right != null) {
	      return root;
	    }
	    return left == null ? right : left;
	  }
	  
	  //Time Complexity:O(n*k); where n is # of nodes in tree. k is # of nodes in list.
	  //Space Complexity: O(1);
}
