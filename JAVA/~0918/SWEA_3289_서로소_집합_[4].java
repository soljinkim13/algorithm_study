import java.util.Scanner;

public class Solution {
	static int[] parent;
	public static void set(int N){
		for(int i = 1 ; i<=N;i++){
			parent[i] = i;
		}
	};
	
	public static int find(int a){
		if(parent[a]==a) return a;
		return parent[a] = find(parent[a]);
	}
	
	public static void union(int a, int b){
		int nodeA = find(a);
		int nodeB = find(b);
		if(nodeA == nodeB) return;
		parent[nodeB] = nodeA;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			parent = new int[N+1];
			set(N);
			System.out.print("#"+tc+" ");
			for(int i = 0; i<M ; i++){
				int todo = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(todo == 0){
					union(a,b);
				}else{
					if(find(a)==find(b)) System.out.print("1");
					else System.out.print("0");
				}
			}
			System.out.println();
		}
	}
}