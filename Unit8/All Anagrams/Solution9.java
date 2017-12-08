import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution9 {

	public static void main(String[] args) {
		String input2 = "aaa";
		String input1 = "a";
		System.out.println(allAnagrams2(input1,input2));
	}
	//what: find each string permutation in s that is equal to l and get the index of the begining of the permutation.	
	public static List<Integer> allAnagrams(String s, String l) {
		List<Integer> res = new ArrayList<Integer>();
		//how: 1. corner case
		if (l.length() < s.length()) {
			return res;
		}
		//2. put all characters from l into hashmap and create a counter
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (Character c: s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int counter = 0;
		//3. check each character for s 
		for (int i = 0; i < l.length(); i++) {
			//3.1 handle a new character in the window
			char temp = l.charAt(i);
			counter = computer(map, temp, counter, false);
			//3.2 delete the front character in the window
			if(i >= s.length()) {
				temp = l.charAt(i-s.length());
				counter = computer(map,temp,counter,true);
			}
			//if the all character is zero.
			if(counter == map.size()) {
				res.add(i - s.length() + 1);
			}
		}
		return res;
	}
	private static int computer(Map<Character, Integer> map, char temp, int counter, boolean isAdd) {
		Integer count = map.get(temp);
		if (count != null)
		{
			if(isAdd) {
				map.put(temp, count + 1);
				if(count == 0) {
					counter--;
				}
			} else {
				map.put(temp, count - 1);
				if(count == 1) {
					counter++;
				}
			}
		}
		return counter;
		
	}
	
 	public static List<Integer> allAnagrams2(String s, String l) {
 	 	  List<Integer> res = new ArrayList<Integer>();
 	 	  if (s.length() > l.length()) {
 	 	    return res;
 	 	  }
 	 	  Map<Character, Integer> map = new HashMap<Character, Integer>();
 	 	  for(Character c : l.toCharArray()) {
 	 	    map.put(c, map.getOrDefault(c,0) + 1);
 	 	  }
 	 	  int counter = 0;
 	 	  //loop
 	 	  for (int i = 0 ; i < l.length() ; i ++) {
 	 	    Character temp = l.charAt(i);
 	 	    Integer num = map.get(temp);
 	 	    if (num != null) {
 	 	      map.put(temp, num - 1);
 	 	      if (num == 1) {
 	 	        counter++;
 	 	      }
 	 	    }
 	 	    
 	 	    if (i >= s.length()) {
 	 	      temp = l.charAt(i - s.length());
 	 	      num = map.get(temp);
 	 	      if (num != null) {
 	 	        map.put(temp, num + 1);
 	 	        if(num == 0) {
 	 	          counter--;
 	 	        }
 	 	      }
 	 	    }
 	 	    
 	 	    if (counter == map.size()) {
 	 	      res.add(i-s.length() + 1);
 	 	    }
 	 	  }
 	 	  return res;
 	 	}


}
