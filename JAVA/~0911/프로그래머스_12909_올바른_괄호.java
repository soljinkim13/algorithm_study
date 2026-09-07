import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
		Deque<Character> check = new ArrayDeque<>();
				
		for(int i = 0; i<s.length();i++) {
            if(s.charAt(i)=='(') check.add(s.charAt(i));
            else{
                if(!check.isEmpty()&&check.peek().equals('(')) check.poll();
                else{
                    check.add('a');
                    answer = false;
                }
            }			
		}
		
		answer = check.isEmpty();     
        if(s.charAt(0)==')') answer = false;
        return answer;
    }
}