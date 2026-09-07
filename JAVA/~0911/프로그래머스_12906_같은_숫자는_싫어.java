import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
		Deque<Integer> asdf = new ArrayDeque<Integer>();
		
		
		for(int i = 0 ; i< arr.length;i++) {
			if(asdf.isEmpty()||!asdf.peekLast().equals(arr[i])) asdf.add(arr[i]);
			
		}
        
        
		return asdf.stream().mapToInt(Integer::intValue).toArray();
    }
}