//SWEA_26938 하위 조직 인원수 세기
//케챱고백 : 트리 문제 잘 몰라서 검색 많이함
//겸사 dfs 공부를 했고 -> 복습도 해야
//구글링을많이했음

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_26938 {
	static ArrayList<Integer>[] tree;
	static int count;
	
	public static void dfs(int node) {
		count++;
		for(int next:tree[node]) {
			dfs(next);
		}
	}
				
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();

		for(int i = 1;i<=T;i++) {
			int E = sc.nextInt();
			int N = sc.nextInt();
			tree = new ArrayList[E+2];
			
			for(int j = 0;j<tree.length;j++) {
				tree[j]= new ArrayList<>();
			}
			for(int j = 0;j<E;j++) {
				int boss = sc.nextInt();
				int emp = sc.nextInt();
				tree[boss].add(emp);
			}
			count = 0;
			dfs(N);
			
			System.out.println("#"+i+" "+count);
			
		}

	}

}
