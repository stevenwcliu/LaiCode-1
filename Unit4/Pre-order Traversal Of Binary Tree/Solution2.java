import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;
import generator.TreeRandom;

public class Solution2 {

	public static void main(String[] args) {
		TreeNode input = TreeRandom.treeGenRange(3, null, 0, 10);
		input.print();
		System.out.println(preOrder(input));
	}
	
	//what: traversed order should be root, left sub-tree, and right sub-tree for each level.
	public static List<Integer> preOrder(TreeNode root) {
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
			res.add(cur.key);
			if (cur.right != null) {
				stack.offerFirst(cur.right);
			}
			if (cur.left != null) {
				stack.offerFirst(cur.left);
			}
		}
		return res;
	}
	//Time Complexity: O(n)
	//Space Complexity: O(n) 
}
