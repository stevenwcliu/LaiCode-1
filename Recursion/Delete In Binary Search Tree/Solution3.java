import generator.TreeNode;
public class Solution3 {

	public static void main(String[] args) {
//		TreeNode input = new TreeNode(5);
//		input.left = new TreeNode(3);
//		input.left.left = new TreeNode(2);
//		input.left.right = new TreeNode(4);
//		input.right = new TreeNode(9);
//		input.right.left = new TreeNode(6);
//		input.right.right = new TreeNode(10);		
//		input.print();
		TreeNode input = new TreeNode(2);
		
		System.out.println();
		delete1(input, 2).print();	
	}
	
	public static TreeNode delete(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		
		if (root.key > key) {
			root.left = delete(root.left, key);
		} else if (root.key < key) {
			root.right = delete(root.right, key);
		}
		if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			return root.left;
		}
		
		if (root.right.left == null) {
			return root.right;
		}
		TreeNode smallest = moveSmallest(root.right);
		smallest.left = root.left;
		smallest.right = root.right;
		return smallest;
	}
	
	public static TreeNode delete1(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		TreeNode cur = root;
		TreeNode previous = new TreeNode(-1);
		previous.left = root;
		boolean isLeft = true;
		while(cur != null) {
		  if (cur.key < key) {
		    if (cur.right != null) {
		      previous = cur;
		      isLeft = false;
		      cur = cur.right;
		      continue;
		    } else {
		      break;
		    }
		  } else if (cur.key > key) {
		    if (cur.left != null) {
		      previous = cur;
		      cur = cur.left;
		      isLeft = true;
		      continue;
		    } else {
		      break;
		    }
		  }
		  
		  if (cur.left == null) {
		    if (isLeft){
		      previous.left = cur.right;
		    } else {
		      previous.right = cur.right;
		    }
		    break;
		  } else if (cur.right == null) {
		    if (isLeft){
		      previous.left = cur.left;
		    } else {
		      previous.right = cur.left;
		    }
		    break;
		  }
		  
		  if (cur.right.left == null) {
		    cur.right.left = cur.left;
		    if (isLeft) {
		      previous.left = cur.right;
		    } else {
		      previous.right = cur.right;
		    }
		    break;
		  }
		  
		  TreeNode smallest = moveSmallest(cur.right);
		  smallest.left = cur.left;
		  smallest.right = cur.right;
		  if (previous.left != null && previous.left == root) {
		    return smallest;
		  }
		  if(isLeft) {
		    previous.left = smallest;
		  } else {
		    previous.right = smallest;
		  }
		  break;
		}
		if (previous.key == -1) {
			return previous.left;
		}
		return root;
	}

	
	private static TreeNode moveSmallest(TreeNode root) {
		TreeNode previous = root;
		root = root.left;
		while (root.left != null) {
			previous = root;
			root = root.left;
		}
		previous.left = root.right;
		return root;
	}

}
