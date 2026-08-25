package programmers;

import java.util.Arrays;

public class 쿼드압축후개수세기 {
	public static void main(String[] args) {

        Solution sol = new Solution();

        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[][] arr2 = {
        		{1,1,1,1,1,1,1,1},
        		{0,1,1,1,1,1,1,1},
        		{0,0,0,0,1,1,1,1},
        		{0,1,0,0,1,1,1,1},
        		{0,0,0,0,0,0,1,1},
        		{0,0,0,0,0,0,0,1},
        		{0,0,0,0,1,0,0,1},
        		{0,0,0,0,1,1,1,1}
        		};
        int[] result = sol.solution(arr);

        System.out.println(Arrays.toString(result));
    }
}

class Solution {
	
	public static int[] ans;
	public static void check(int iStart, int iEnd, int jStart, int jEnd, int[][] arr) {
		
		int num = 0;
		int count = 0;
		for(int i = iStart;i<=iEnd;i++) {
			for(int j = jStart;j<=jEnd;j++) {
				num+= arr[i][j];
				count++;
			}
		}
		if(num==0) {
			ans[0]++;
			return;
		}
		if(num==count) {
			ans[1]++;
			return;
		}

		int iMid = (iStart+iEnd)/2;
		int jMid = (jStart+jEnd)/2;


		check(iStart, iMid, jStart, jMid, arr);
		check(iStart, iMid, jMid+1, jEnd, arr);
		check(iMid+1, iEnd, jStart, jMid, arr);
		check(iMid+1, iEnd, jMid+1, jEnd, arr);

		
	}
    public int[] solution(int[][] arr) {
        int[] answer = {};
        ans = new int[2];
        
        check(0,arr.length-1,0,arr.length-1,arr);
        return ans;
    }
}