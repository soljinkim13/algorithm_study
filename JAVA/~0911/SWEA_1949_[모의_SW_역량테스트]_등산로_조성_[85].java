import java.util.Scanner;

public class Solution_1949_김진솔 {
	public static int N;
	public static int K;
	public static int ans;
	public static int max;
	public static int[][] mountain;
	public static int[][] temp;
	public static boolean[][] visited;
	public static int[] dr = {-1,1,0,0};
	public static int[] dc = {0,0,-1,1};
	
	
	public static void climb(int prevR, int prevC, int k, int depth,int now) {

		ans = Math.max(ans, depth);
				
		visited[prevR][prevC] = true;
		for(int i = 0 ; i<4;i++) {
			int nextR = prevR +dr[i];
			int nextC = prevC +dc[i];			
			
			if(nextR<0||nextR>=N||nextC<0||nextC>=N||visited[nextR][nextC]) continue;
			
			if(mountain[nextR][nextC]<now) {
				climb(nextR,nextC,k,depth+1,mountain[nextR][nextC]);
			}else if(mountain[nextR][nextC]-k<now) {
				climb(nextR,nextC,0,depth+1,now -1);
			}
		}
		visited[prevR][prevC] = false;

		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T;tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			int top = Integer.MIN_VALUE;
			mountain = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0 ; i< N ; i++) {
				for(int j = 0 ; j<N ; j++) {
					mountain[i][j] = sc.nextInt();
					top = Math.max(top, mountain[i][j]);
				}
			}
			ans = 0;
			for(int i = 0 ; i< N ; i++) {
				for(int j = 0; j<N ; j++) {
					if(mountain[i][j]==top) {
						climb(i,j,K,1,top);
					}
					
				}
				ans = Math.max(ans, max);
			}
			
			
			System.out.println("#"+tc+" "+ans);
		}
	}

}
