/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 10, 2017 9:49:14 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */
package generator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class TreeRandom 
{
	private static final int MIN=0;
	private static final int MAX=100000;
	
	/**
	 * To return a random integer with minimum value and maximum value
	 */
	public static int range(int min,int max)
	{
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	/**
	 * To return a random integer with final minimum value and final maximum value
	 */
	public static int range()
	{
		return ThreadLocalRandom.current().nextInt(MIN, MAX);
	}
	
	/**
	 * To return a random binary tree with final minimum value and final maximum value
	 */
	public static TreeNode treeGen(int len, TreeNode root)
	{
		root = new TreeNode(range());
		
		if(len>1)
		{
			root.left = treeGen( len-1 , root);
			root.right = treeGen( len-1 ,  root);
		}
		
		return root;
	}
	
	/**
	 * To return a random binary tree with given minimum value and maximum value
	 */
	public static TreeNode treeGenRange(int len, TreeNode root, int min, int max)
	{
		root = new TreeNode(range(min,max));
		
		if(len>1)
		{
			root.left = treeGenRange( len-1 , root,min,max);
			root.right = treeGenRange( len-1 ,  root,min,max);
		}
		
		return root;
	}
	
	/**
	 * To return a random binary tree with given minimum value and maximum value
	 */
	public static TreeNode treeGenLeftRange(int len, TreeNode root, int min, int max)
	{
		root = new TreeNode(range(min,max));
		
		if(len>1)
		{
			root.left = treeGenLeftRange( len-1 , root,min,max);
		}
		
		return root;
	}
	
	public static TreeNode treeGen(String[] array) {
		if(array == null || array.length == 0 || array[0] == "#") {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(array[0]));
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		int pointer = 1;
		while (!que.isEmpty()) {
			TreeNode cur = que.poll();
			if (pointer < array.length && array[pointer] != "#") {
				cur.left = new TreeNode(Integer.parseInt(array[pointer]));
				que.offer(cur.left);
			}
			pointer++;
			if (pointer < array.length && array[pointer] != "#") {
				cur.right = new TreeNode(Integer.parseInt(array[pointer]));
				que.offer(cur.right);
			} 
			pointer++;
		}
		return root;
	}

    public static TreeNode createComplateTree(String[] str) {
        if (str[0].charAt(0) == '#') return null;
        return createComplateTree(str,0);
    }
    private static TreeNode createComplateTree(String[] str, int idx){
        if (idx >= str.length || str[idx].charAt(0) == '#') return null;
        TreeNode cur = new TreeNode(Integer.parseInt(str[idx]));
        cur.left = createComplateTree(str, 2*idx +1);
        cur.right = createComplateTree(str, 2*idx + 2);
        return cur;
    }

	
}
