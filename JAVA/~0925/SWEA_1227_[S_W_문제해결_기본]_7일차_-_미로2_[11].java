import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Solution
{
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static Queue<int[]> q;
	public static int ans;

	public static void bfs(int startR, int startC) {
		q = new ArrayDeque<>();
		q.add(new int[] {startR, startC});
		visited[startR][startC] = true;
		ans = 0;

		while(!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];

			for(int i = 0; i < 4; i++) {
				int nextR = r + dr[i];
				int nextC = c + dc[i];

				if(nextR < 0 || nextC < 0 || nextR >= 100 || nextC >= 100) continue;
				if(visited[nextR][nextC] || map[nextR][nextC] == 1) continue;

				if(map[nextR][nextC] == 3) {
					ans = 1;
					return;
				}

				q.add(new int[] {nextR, nextC});
				visited[nextR][nextC] = true;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int t = 0; t < 10; t++) {
			int tc = sc.nextInt();
			map = new int[100][100];
			visited = new boolean[100][100];
			int startR = 0;
			int startC = 0;

			for(int i = 0; i < 100; i++) {
				String line = sc.next();

				for(int j = 0; j < 100; j++) {
					map[i][j] = line.charAt(j) - '0';

					if(map[i][j] == 2) {
						startR = i;
						startC = j;
					}
				}
			}

			bfs(startR, startC);
			System.out.println("#" + tc + " " + ans);
		}
}
}

