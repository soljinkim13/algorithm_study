
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public static String[] mapdata;
		public static boolean[][] visited;
		public static int sizeR;
		public static int sizeC;
		public static ArrayList<Integer> ans;
		
		public static void bfs(int row, int col) {
			Deque<int[]> deque = new ArrayDeque<>();			
					
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			
			visited[row][col] = true;
			deque.offer(new int[] {row,col});
			int total = mapdata[row].charAt(col) - '0';
			
			while(!deque.isEmpty()) {
				int[] now = deque.poll();
				int nowR = now[0];
				int nowC = now[1];
				
				for(int i = 0 ; i<4;i++) {
					int nextR = nowR + dr[i];
					int nextC = nowC + dc[i];
					
					if(nextR<0||nextR>=sizeR||nextC<0||nextC>=sizeC) continue;
					if(mapdata[nextR].charAt(nextC)=='X') continue;
					if(visited[nextR][nextC]) continue;
					
					visited[nextR][nextC] = true;
					total += mapdata[nextR].charAt(nextC) - '0';
					
					deque.offer(new int[] {nextR,nextC});
				
				}
								
				
			}
			
			ans.add(total);
			
			
			
		}
		
		
	    public int[] solution(String[] maps) {
	        int[] answer = {};
	        mapdata = maps;
	        sizeR = maps.length;
	        sizeC = maps[0].length();
	        visited = new boolean[sizeR][sizeC];
	        ans = new ArrayList<>();
	        
	        for(int i = 0 ;i < sizeR ; i++) {
	        	for(int j = 0 ; j < sizeC ; j++) {
	        		if(maps[i].charAt(j) != 'X' && !visited[i][j]) bfs(i,j);
	        	}
	        }
	        if (ans.isEmpty()) return new int[]{-1};
	        
	        
	        ans.sort(null);
	        	        
	        return ans.stream()
	                .mapToInt(Integer::intValue)
	                .toArray();
	    }
	}
