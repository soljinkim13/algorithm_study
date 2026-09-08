import java.util.Scanner;

public class Solution_1873_김진솔 {
	public static Character[][] map;
	public static String user;
	
	
	static int nowR;
	static int nowC;
	static int H;
	static int W;
	
	static char tank;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void bullet(int prevR, int prevC, int dir) {
		int nextR = prevR +dr[dir];
		int nextC = prevC +dc[dir];
		
		if(nextR<0||nextR>=H||nextC<0||nextC>=W||map[nextR][nextC].equals('#')) {
			return;
		}
		
		if(map[nextR][nextC].equals('*')) {
			map[nextR][nextC] = '.';
			return;
		}		
		
		bullet(nextR, nextC, dir);
		
	}
	
	
	public static void shoot() {
		switch(tank) {
			case '^':
				bullet(nowR,nowC, 0);
				break;

			case 'v':
				bullet(nowR,nowC, 1);
				break;

			case '<':
				bullet(nowR,nowC, 2);
				break;

			case '>':
				bullet(nowR,nowC, 3);
				break;

		}
	}
	
	
	public static void move(int idx) {
		switch(user.charAt(idx)) {
			case 'S':
				shoot();
				break;
			case 'U':
				tank = '^';
				map[nowR][nowC] = tank;
				if (nowR-1>=0&&map[nowR-1][nowC].equals('.')) {
					map[nowR][nowC] ='.';
					nowR-=1;
					map[nowR][nowC] = tank;
				}
				
				
				break;
				
			case 'D':
				tank = 'v';
				map[nowR][nowC] = tank;
				if (nowR+1<H&&map[nowR+1][nowC].equals('.')) {
					map[nowR][nowC] ='.';				
					nowR+=1;
					map[nowR][nowC] = tank;
					
				}
				break;
				
			case 'L':
				tank ='<';
				map[nowR][nowC] = tank;
				if (nowC-1>=0&&map[nowR][nowC-1].equals('.')) {
					map[nowR][nowC] = '.';							
					nowC-=1;
					map[nowR][nowC] = tank;
				}
				break;
				
				

			case 'R':
				tank = '>';
				map[nowR][nowC] = tank;
				if (nowC+1<W&&map[nowR][nowC+1].equals('.')) {
					map[nowR][nowC] ='.';							
					nowC+=1;
					map[nowR][nowC] = tank;
					
				}
				
				break;

			default:
				return;
		}
			
				
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<= T ; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new Character[H][W];
			
			
			nowR = 0;
			nowC = 0;
			
			
			tank = ' '; 
			
			for(int i = 0 ; i<H ;i++) {
				String line = sc.next();

				for (int j = 0; j < W; j++) {
				    map[i][j] = line.charAt(j);
					if(map[i][j].equals('^')||map[i][j].equals('v')||map[i][j].equals('<')||map[i][j].equals('>')){
						nowR = i;
						nowC = j;
						tank = map[i][j];
					}
				}
//				sc.nextLine();
			}
			
			int N = sc.nextInt();
			
			user = sc.next();
			
			int num = 0;
			
			while(num<N) {
				move(num);
				num++;
			}
			
			
			
			System.out.print("#"+tc+" ");
			
			for(int i = 0 ; i<H ;i++) {
				for(int j = 0 ; j<W;j++) {
					System.out.print(map[i][j]);
				}System.out.println();
			}
			
		}
		
	}

}


