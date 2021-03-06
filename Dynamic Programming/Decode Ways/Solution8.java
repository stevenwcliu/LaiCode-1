
public class Solution8 {

	public static void main(String[] args) {
		String input = "212514";
		System.out.println(numDecodeWay(input));
	}

	  //approach: solve the problem with DFS.
	  public static int numDecodeWay(String s) {
	    if (s == null || s.length() == 0) {
	      return 0;
	    }
	    int[] res = new int[]{0};
	    checkChar(s, 0, res);
	    return res[0];
	  }
	  
	  private static void checkChar(String s, int index, int[] res) {
	    if (index == s.length()) {
	      res[0]++;
	      return;
	    }
	    //check the first character.
	    char single = s.charAt(index);
	    //check single character 
	    if(single > '0' && single <= '9') {
	      checkChar(s, index + 1, res);
	      //check the combination of two characters.
	      if (index < s.length() - 1) {
	    	  String str = "" + s.charAt(index) + s.charAt(index + 1) ;
	    	  if (Integer.valueOf(str) <= 26) {
	    		  checkChar(s, index + 2, res);
	    	  }
	      }
	    }
	  }
	  //Time complexity: O(n);
	  //Space complexity: O(n);
}
