import java.util.Scanner;

public class Solution_6808_김진솔 {
	public static int[] combCard;
	public static int win;
	public static int lose;
	public static boolean[] visited;
	public static int[] cardA;
	public static int[] cardB;
	
	
	public static void dfs(int A, int B, int count) {
		if(count == 9) {
			if(A>B) win++;
			else if(A<B) lose++;
			return;
		}
		
		for(int i = 0; i<9 ; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			int sum = cardA[count] +cardB[i];
			
			if(cardA[count]>cardB[i]) dfs(A+sum,B,count+1);
			else if(cardA[count]<cardB[i]) dfs(A,B+sum,count+1);
			
			visited[i] = false;			
		}				
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1;tc<=T;tc++) {
			boolean[] card = new boolean[19];
			cardA = new int[9];
			cardB = new int[9];
			
			for(int i = 0;i<9;i++) {
				card[sc.nextInt()] = true;
			}
			int numA = 0;
			int numB = 0;
			for(int i = 1;i<=18;i++) {
				if(card[i] == true) cardA[numA++] = i;
				else cardB[numB++] = i;
			}
			win = 0;
			lose = 0;
			visited = new boolean[9];
			
			dfs(0,0,0);

			System.out.println("#"+tc+" "+win+" "+lose);
		}
	
	}

}


