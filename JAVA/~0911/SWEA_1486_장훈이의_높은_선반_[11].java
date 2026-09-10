import java.util.Scanner;

public class Solution {
	public static int[] S;
	public static int N;
	public static int B;
	public static int ans;
	
	
	public static void sum(int idx,int total){
		if(total>=B){
		ans = Math.min(ans, total-B);	
		}
		
		if(idx+1>N) return;
		
		//n번째 사람이 함께 탑을 쌓는 경우
		sum(idx+1,total + S[idx]);
		//n번째 사람은 빠지는 경우
		sum(idx+1,total);
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			S = new int[N];
			for(int i = 0 ; i< N ; i++){
				S[i] = sc.nextInt();
			}			
			
			ans = Integer.MAX_VALUE;			
			sum(0,0);
			
			System.out.println("#"+tc+" "+ans);

		}
	}
}