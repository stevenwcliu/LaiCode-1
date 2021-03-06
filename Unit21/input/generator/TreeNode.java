/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 10, 2017 9:48:06 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */
package generator;

public class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x)
	{
		key=x;
	}
	
	public void print()
	{
		System.out.print(this.key);
		if(this.left != null) {
			printRest(this.left);
		}
		if(this.right != null) {
			printRest(this.right);
		}
		
	}
	public void printRest(TreeNode root){
		System.out.print("(");
		System.out.print(root.key);
		if(root.left!=null)
		{
			root.left.print();
		}
		else {
			System.out.print("(#)");
		}
		if(root.right!=null)
		{
			root.right.print();
		}
		else {
			System.out.print("(#)");
		}
		System.out.print(")");
	}
}
