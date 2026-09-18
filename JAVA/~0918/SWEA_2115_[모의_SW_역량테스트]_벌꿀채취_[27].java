import java.util.Scanner;

public class Solution {
	public static int[][] honey;
	public static int N;
	public static int M;
	public static int C;
	
	public static int first;
	public static int second;
	public static int ans;
	
	public static void cal(int firstR, int firstC, int secondR, int secondC) {
		first = 0;
		second = 0;
		
		findmax(firstR, firstC, 0, 0, 0, 1);
		findmax(secondR, secondC, 0, 0, 0, 2);
		
		ans = Math.max(ans, first + second);
	}
	
	public static void findmax(int R, int startC, int idx, int sum, int num, int worker) {
		if(idx == M) {
			if(worker == 1) first = Math.max(first, sum);
			else second = Math.max(second, sum);
			return;
		}
		
		int checknum = honey[R][startC + idx];
		
		if(num + checknum <= C) {
			findmax(R, startC, idx + 1, sum + checknum * checknum, num + checknum, worker);
		}
		
		findmax(R, startC, idx + 1, sum, num, worker);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			
			honey = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					honey[i][j] = sc.nextInt();
				}
			}
			
			ans = 0;
			
			for(int firstR = 0; firstR < N; firstR++) {
				for(int firstC = 0; firstC <= N - M; firstC++) {
					
					for(int secondC = firstC + M; secondC <= N - M; secondC++) {
						cal(firstR, firstC, firstR, secondC);
					}
					
					for(int secondR = firstR + 1; secondR < N; secondR++) {
						for(int secondC = 0; secondC <= N - M; secondC++) {
							cal(firstR, firstC, secondR, secondC);
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		
		sc.close();
	}
}