import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1226_김진솔 {

    static int[][] data;
    static int ans;
    static Queue<int[]> queue;
    static int[] dr = {-1, 1, 0 ,0};
    static int[] dc = {0,0, -1, 1};

    static void bfs(int checkR, int checkC) {
    	Queue<int[]> queue = new ArrayDeque<>();
    	queue.offer(new int[] {checkR,checkC});
    	data[checkR][checkC] = 1;
    	
    	while(!queue.isEmpty()) {
    		int[] now = queue.poll();
    		int r = now[0];
    		int c = now[1];
    		
    		for(int i = 0 ; i<4;i++) {
    			int nextR = r+dr[i];
    			int nextC = c+dc[i];
    			
    			if(nextR<0 || nextR>=16 || nextC<0 || nextC>=16) continue;
    			if(data[nextR][nextC]==1) continue;
    			if(data[nextR][nextC]==3) {
    				ans = 1;
    				return;
    			}
    			
    			data[nextR][nextC] = 1;
    			
    			queue.offer(new int[] {nextR, nextC});
    		}
    		
    	}
    	
    	
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int testCase = sc.nextInt();

            ans = 0;
            data = new int[16][16];
            
            int startY = 0;
            int startX = 0;
            
            for(int i = 0; i<16;i++) {
            	String line = sc.next();
            	for(int j = 0; j<16;j++) {
            		data[i][j] = line.charAt(j)-'0';
            		 if(data[i][j] == 2) {
                     	startY = i;
                     	startX = j;
                     }
            	}
            }
          
            bfs(startY,startX);
                

            System.out.println("#" + testCase + " " + ans);
        }

        sc.close();
    }
}









