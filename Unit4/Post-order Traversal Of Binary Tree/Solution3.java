import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;
import generator.TreeRandom;

public class Solution3 {

	public static void main(String[] args) {
		TreeNode input = TreeRandom.treeGenRange(3, null, 0, 10);
		input.print();
		System.out.println(postOrder(input));
		System.out.println(postOrder1(input));
	}
	
	//what: traversed order should be left sub-tree, right sub-tree, and root for each level.
	public static List<Integer> postOrder(TreeNode root) {
		//how: 1.corner case
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		//2. define a stack to do FILO
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.offerFirst(root);
		//3. traverse each level
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			if (cur.left != null) {
				stack.offerFirst(cur.left);
			}
			res.add(cur.key);
			if (cur.right != null) {
				stack.offerFirst(cur.right);
			}
		}
		Collections.reverse(res);
		return res;
	}
	//Time Complexity: O(n)
	//Space Complexity: O(n) 
	
	// What: to do in-order traverse with using previous node method.
	public static List<Integer> postOrder1(TreeNode root) {
		//how: 1. corner case
		List<Integer> res = new ArrayList<Integer>(); 
		if (root == null) {
			return res;
		}
		
		//2. create a previous node and a stack
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode pre = null;
		stack.offerFirst(root);
		
		//3. traverse all nodes in the tree;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			//3.1 previous node is null or parent -> going down
			if (pre == null || pre.left == cur || pre.right == cur) {
				if (cur.left != null) {
					stack.offerFirst(cur.left);
				} else if (cur.right != null) {
					stack.offerFirst(cur.right);
				} else {
					stack.pollFirst();
					res.add(cur.key);
				} //3.2 the left subtree has been visited 
			} else if (pre == cur.left) {
				if (cur.right != null) {
					stack.offerFirst(cur.right);
				} else {
					stack.pollFirst();
					res.add(cur.key);
				} // 3.3 all children has been visited.
			} else {
				stack.pollFirst();
				res.add(cur.key);
			}
			pre = cur;
		}
 		return res;
	}
	//Time complexity: O(n)
	//Space complexity: O(height) height could be n;
}
