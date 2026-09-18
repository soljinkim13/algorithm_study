import java.util.Scanner;

public class Solution {
	public static long N;
	public static long ans;
	
	public static void cal(long N, long cnt) {
		if(N == (long)2) {
			ans = cnt;
			return;
		}
		long sqrt = (long) Math.sqrt(N);
		long check = sqrt*sqrt;
		
		if(check == N) {
			cal(sqrt,(long) (cnt+1));
		}else {
			long num = (long)((sqrt+1)*(sqrt+1))-N;
			cal(sqrt+1,cnt+num+1);
			
		}
		
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextLong();
			ans  = 0;
			
			
			cal(N,0);
			
				
		
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}