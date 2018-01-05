import java.util.HashMap;
import java.util.Map;

public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int longestConsecutive(int[] array) {
		Map<Integer, Integer> ranges = new HashMap<>();
		int max = 0;
		for(int num : array) {
			if (ranges.containsKey(num)) {
				continue;
			}
			int left = ranges.getOrDefault(num -1, 0);
			int right = ranges.getOrDefault(num + 1, 0);
			int sum = left + right + 1;
			max = Math.max(max, sum);
			
			if (left > 0) ranges.put(num - left, sum);
		}
		
		return max;
		
	}

}
