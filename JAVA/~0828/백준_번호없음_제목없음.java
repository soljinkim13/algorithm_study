import java.util.Scanner;

public class SWEA_1247 {
	public static int N;
	public static int ans;
	public static int companyX;
	public static int companyY;
	public static int homeX;
	public static int homeY;
	public static int[] dataX;
	public static int[] dataY;
	public static boolean[] visited;
	public static int total;
		
	public static int cal(int x1, int y1,int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
	
	public static void dfs(int depth, int x,int y,int total) {
		if(depth == N) {
			total += cal(x,y,homeX,homeY);
			ans = Math.min(ans, total);
			return;
		}
		
		for(int i =0;i<N;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			int next = cal(x,y,dataX[i],dataY[i]);
			dfs(depth+1,dataX[i],dataY[i],total+next);
			visited[i] = false;
		}

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc =1; tc<=T;tc++) {
			N = sc.nextInt();
			companyX = sc.nextInt();
			companyY = sc.nextInt();
			homeX = sc.nextInt();
			homeY = sc.nextInt();
			dataX = new int[N];
			dataY = new int[N];
			
			for(int i = 0;i<N;i++) {
				dataX[i] = sc.nextInt();
				dataY[i] = sc.nextInt();
			}
			
			visited = new boolean[N];
			ans = Integer.MAX_VALUE;
			
			dfs(0, companyX,companyY,0);
			System.out.println("#"+tc+" "+ans);
		}
	}
    
}

