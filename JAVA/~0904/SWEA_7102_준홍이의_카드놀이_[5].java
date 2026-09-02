import java.util.Arrays;
import java.util.Scanner;

public class Solution_7102_김진솔 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1;tc<=T;tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] ans = new int[M+N+2];
			
			
			for(int i = 1; i<=N;i++) {
				for(int j = 1; j<=M; j++) {
					ans[i+j]++;
				}
			}
			int max = Integer.MIN_VALUE;
			for(int i = 0; i<ans.length;i++) {
				max = Math.max(max, ans[i]);
			}
			
			System.out.print("#"+tc+" ");
			for(int i = 0; i < ans.length; i++) {
			    if(max == ans[i]) {
			        System.out.print(i + " ");
			    }
			}
			
			System.out.println();
		}
		
	}

	

}
