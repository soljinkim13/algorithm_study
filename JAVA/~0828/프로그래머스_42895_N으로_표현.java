import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


class Solution {

    public int solution(int N, int number) {

        Set<Integer>[] dp = new HashSet[9];
        for (int i = 1; i<= 8; i++) { dp[i] = new HashSet<>(); }

        for(int i = 1; i<= 8; i++) {
        	
        	int pureNum = 0;
        	for(int j =0;j<i;j++) {
        		pureNum = pureNum*10+N;
        	}
        	dp[i].add(pureNum);
        	
        	for(int j = 1; j<i;j++) {
        		for(int a : dp[j]) {
        			for(int b : dp[i-j]) {
        				dp[i].add(a+b);
        				dp[i].add(a-b);
        				dp[i].add(a*b);
        				if(b!=0) dp[i].add(a/b);
        			}
        		}
        	}
        	
        	

            if (dp[i].contains(number)) {
                return i;
            }
        }

        return -1;
    }
}