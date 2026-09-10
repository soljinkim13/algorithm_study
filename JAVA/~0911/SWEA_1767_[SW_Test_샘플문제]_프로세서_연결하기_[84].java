import java.util.Scanner;
import java.util.*;

public class Solution {
	public static int N;
	public static int[][] map;
	public static int[][] tmp;
	public static int ans;
	public static int line;
	public static int maxConnected;
	public static ArrayList<int []> core;
	
	public static void dfs(int idx, int connected, int line){

		if (idx == core.size()) {
            if (connected > maxConnected) {
                maxConnected = connected;
                ans = line;
            } else if (connected == maxConnected) {
                ans = Math.min(ans, line);
            }
        
            return;
        }
        
        int nowR = core.get(idx)[0];
		int nowC = core.get(idx)[1];
		
				
		int leftCheck = 0;
		for(int r = 0;r<nowR;r++){
			leftCheck += map[r][nowC];
		}
		
		int rightCheck = 0;
		for(int r = nowR+1;r<N;r++){
			rightCheck += map[r][nowC];
		}
		int downCheck = 0;
		for(int c = 0;c<nowC;c++){
			downCheck += map[nowR][c];
		}
		
		int upCheck = 0;
		for(int c = nowC+1;c<N;c++){
			upCheck += map[nowR][c];
		}
		
		
		int newLine = 0;
		
		
		if(leftCheck==0) {
			for(int r = 0;r<nowR;r++){
    			map[r][nowC] = 1;
    			newLine++;
    		}
    		dfs(idx+1,connected+1, line+newLine);
    		for(int r = 0;r<nowR;r++){
    			map[r][nowC] = 0;
    		}
    	}
    	newLine = 0;
    	if(rightCheck==0){
			for(int r = nowR+1 ;r<N;r++){
    			map[r][nowC] = 1;
    			newLine++;
    		}
    		dfs(idx+1,connected+1, line+newLine);
    		for(int r = nowR+1 ;r<N;r++){
    			map[r][nowC] = 0;
    		}
		}
		newLine = 0;
		if(downCheck==0){
			for(int c = 0;c<nowC;c++){
    			map[nowR][c] = 1;
    			newLine++;
    		}
    		dfs(idx+1,connected+1, line+newLine);
    		for(int c = 0;c<nowC;c++){
    			map[nowR][c] = 0;
    		}
		}
		newLine = 0;
		if(upCheck==0){
			for(int c = nowC+1 ;c<N;c++){
    			map[nowR][c] = 1;
    			newLine++;
    		}
    		dfs(idx+1,connected+1, line+newLine);
    		for(int c = nowC+1 ;c<N;c++){
    			map[nowR][c] = 0;
    		}
		}
		
		dfs(idx+1, connected, line);
		

		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			core = new ArrayList<>();
			
			for(int i = 0 ; i<N ;i++){
				for(int j = 0 ; j<N ; j++){
					map[i][j] = sc.nextInt();
                    if (map[i][j] == 1 && i>0 && i<N-1 && j>0&& j <N-1) {
                        core.add(new int[]{i, j});
                    }
				}
			}
			maxConnected = 0;
			ans = Integer.MAX_VALUE;
			dfs(0,0,0);
			
			System.out.println("#"+tc+" "+ans);
			

		}
	}
}