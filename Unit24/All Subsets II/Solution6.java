import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution6 {

	public static void main(String[] args) {
		System.out.println(subSets("aab"));
	}

	  public static List<String> subSets(String set) {
		    List<String> res = new ArrayList<String>();
		    if (set == null) {
		      return res;
		    }
		    char[] array = set.toCharArray();
		    Arrays.sort(array);
		    StringBuilder sb = new StringBuilder();
		    subSets(array, sb, 0, res);
		    return res;
		  }
		  
		  public static void subSets(char[] array, StringBuilder sb, int index, List<String> res) {
		    if (index == array.length) {
		      res.add(sb.toString());
		      return;
		    } 
		    subSets(array, sb.append(array[index]), index + 1, res);
		    sb.deleteCharAt(sb.length() - 1);
		    while (index + 1 < array.length && array[index] == array[index + 1]) {
		      index++;
		    }
		    subSets(array, sb, index + 1, res);
		  }
		  //Time complexity: O(n)
		  //Space complexity: O(n)
}
