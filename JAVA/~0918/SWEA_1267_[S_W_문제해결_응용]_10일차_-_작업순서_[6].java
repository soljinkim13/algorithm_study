import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Solution_1267_김진솔 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc<=10;tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			ArrayList<Integer>[] list = new ArrayList[V+1];
			for(int i = 1; i<=V ; i++) {
				list[i] = new ArrayList<>();
			}
			
			int[] linked = new int[V+1];
			
			for(int i = 1;i<=E;i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				list[start].add(end);
				linked[end]++;
			}
			
			Deque<Integer> q = new ArrayDeque<>();
			
			for(int i = 1; i<=V;i++) {
				if(linked[i]==0) q.add(i); 
			}
			System.out.print("#"+tc+" ");
			while(!q.isEmpty()) {
				int check = q.poll();
				System.out.print(check+" ");
				for(int i : list[check]) {
					linked[i]--;
					if(linked[i]==0) q.add(i);
				}
				System.out.println();
			}
			
			
		}

	}

}
