import java.util.Scanner;

public class Solution_5643_김진솔 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T;tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			boolean[][] connected = new boolean[N+1][N+1];
			
			for(int i = 0 ;i<M; i++) {
				int left = sc.nextInt();
				int right = sc.nextInt();
				connected[left][right] = true;
		
			}
			
			for(int i = 1; i<=N ; i++) {
				for(int j = 1; j<=N ; j++) {
					for(int k = 0; k<=N ; k++) {
						if(connected[i][j]&&connected[j][k]) {
							connected[i][k] = true;
						}
					}
				}
			}

			int ans = 0;
			for(int i = 1; i<=N; i++) {
				int count = 1;
				for(int j = 1 ; j<=N ; j++) {
					if(i==j) continue;
					if(connected[i][j]||connected[j][i]) count++;
				}
				if(count==N) ans++;
			}
			
			
			
			System.out.println("#"+tc+" "+ans);
			
		}
		
		
		
		

	}

}
