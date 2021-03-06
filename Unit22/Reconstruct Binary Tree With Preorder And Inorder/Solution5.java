import java.util.HashMap;
import java.util.Map;
import generator.TreeNode;

public class Solution5 {
	public static void main(String[] args) {
		int[] input1  = new int[]{2,5,8,3,6,1,10,4,9,7};
		int[] input2 = new int[]{3,8,5,2,4,1,6,10,9,7};
		Solution5 s = new Solution5();
		s.reconstruct(input1, input2);
	}
	
	 public TreeNode reconstruct(int[] in, int[] pre) {
		    if (in.length == 0) {
		      return null;
		    }
		    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		    for (int i = 0; i < in.length ; i++) {
		      map.put(in[i], i);
		    }
		    return reconstruct(map, 0, in.length - 1, pre, 0, pre.length - 1);
		  }
		  
		  public TreeNode reconstruct(Map<Integer, Integer> map, int inLeft, int inRight,
		                                    int[] pre, int preLeft, int preRight) {
		    if (inLeft > inRight ) {
		      return null;
		    }
		    TreeNode root = new TreeNode (pre[preLeft]);
		    int index = map.get(root.key);
		    root.left = reconstruct(map, inLeft, index -1, pre, preLeft + 1, preLeft + index - inLeft);
		    root.right = reconstruct(map, index + 1, inRight, pre, preRight + index - inRight + 1, preRight);
		    return root;
		  }
		  //Time complexity: O(n);
		  //Space complexity: O(n);
}
