import java.util.Scanner;

public class Solution_9229_김진솔 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1;tc<=T;tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int ans = -1;
			
			int[] arr = new int[N];
			
			for(int i = 0 ;i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i = N-1 ; i>=1;i--) {
				for(int j = i-1; j>=0;j--) {
					if(arr[i]+arr[j]<=M) {
						ans = Math.max(ans, arr[i]+arr[j]);
					}
				}
			}
			
			
			System.out.println("#"+tc+ " "+ans);
		}
		
	}
	
	
}
