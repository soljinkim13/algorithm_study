import java.util.Scanner;

public class Solution {
	public static int[] parent;
	
	public static int find(int x){
		if(parent[x] == x) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int a, int b){
		int rootA = find(a);
		int rootB = find(b);
		if(rootA==rootB) return;
		parent[rootA] = rootB;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			parent = new int[N+1];
			
			for(int i = 1; i<=N;i++){
				parent[i] = i;
			}
			for(int i = 0;i<M;i++){
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				union(A ,B);
				
			}
			
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
                if (parent[i] == i) {
                    cnt++;
                }
            }
			System.out.println("#"+tc+" "+cnt);
			
			
			
		}
	}
}