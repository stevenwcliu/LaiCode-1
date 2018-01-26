import generator.TreeNode;

public class Solution7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	  public TreeNode reverse(TreeNode root) {
		    if (root == null || root.left == null) {
		      return root;
		    }
		    TreeNode newRoot = reverse(root.left);
		    root.left.left = root;
		    root.left.right = root.right;
		    root.left = null;
		    root.right = null;
		    return newRoot;
		  }
}
