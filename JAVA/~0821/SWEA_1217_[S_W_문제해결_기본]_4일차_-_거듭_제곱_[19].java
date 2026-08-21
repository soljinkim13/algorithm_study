import java.util.Scanner;

public class SWEA_1217 {
	static int N;
	static int M;
	public static int cal(int n, int m) {
		if(m==1) return n;
		return n*cal(n,m-1);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 0; tc<10; tc++) {
			int T = sc.nextInt();
			int ans = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			ans = cal(N,M);
			
			System.out.println("#"+T+" "+ans);
		}
	}

}