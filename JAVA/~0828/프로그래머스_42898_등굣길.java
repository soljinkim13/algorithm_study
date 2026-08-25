class Solution {
    public int solution(int[][] triangle) {
    	int N = triangle.length;
    	int[][] dp = new int[N][N];
    	
    	dp[0][0] = triangle[0][0];
    	for(int i = 1; i< N;i++) {
    		for(int j = 0;j<=i;j++) {
    			if(j == 0) dp[i][j] = dp[i-1][0] + triangle[i][0];
    			else if (j== i) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
    			else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+triangle[i][j];
    		}
    	}
    	int ans = 0;
    	for(int check : dp[N-1]) {
    		ans = Math.max(ans, check);
    	}
        
       
        return ans;
    }
}
