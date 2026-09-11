import java.util.Scanner;

public class Solution_5644_김진솔 {
	public static int[][] map;
	public static int M;
	public static int A;
	public static int ans;
	
	public static int[] moveA;
	public static int[] moveB;
	
	public static int[] dr = {0,-1,0,1,0};
	public static int[] dc = {0,0,1,0,-1};
	
	public static BC[] bc;
	
	public static class BC{
		int BCrow;
		int BCcol;
		int range;
		int power;
		
		BC(int BCrow, int BCcol, int range, int power){
			this.BCrow = BCrow;
			this.BCcol = BCcol;
			this.range = range;
			this.power = power;
		}
		
	}
	
	public static boolean canUse(int BCrow, int BCcol, int idx) {
	    BC charger = bc[idx];

	    int distance = Math.abs(BCrow-charger.BCrow)+ Math.abs(BCcol-charger.BCcol);
	    if(distance <=charger.range) return true;
	    else return false;
	}

	public static int charge(int AnowR, int AnowC, int BnowR, int BnowC) {
	    int max = 0;

	    for (int i = -1; i < A; i++) {
	   
	    	
	        if (i != -1 && !canUse(AnowR, AnowC, i)) continue;
	        
	        for (int j = -1; j < A; j++) {	        	
	            if (j != -1 && !canUse(BnowR, BnowC, j))continue;

	            int sum = 0;
	            
	            
	            
	            if (i == -1 && j == -1) {
	                sum = 0;
	            }else if (j == -1) {
	                sum = bc[i].power;
	            }else if (i == -1) {
	                sum = bc[j].power;
	            }else if (i == j) {
	                sum = bc[i].power;
	            }else {
	                sum = bc[i].power + bc[j].power;
	            }

	            max = Math.max(max, sum);
	        }
	    }

	    return max;
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T;tc++) {
			M = sc.nextInt();
			A = sc.nextInt();
			moveA = new int[M];
			moveB = new int[M];
			map = new int[10][10];
			for(int i = 0; i<M;i++) {
				moveA[i] = sc.nextInt();
			}
			for(int i = 0; i<M;i++) {
				moveB[i] = sc.nextInt();
			}
			bc = new BC[A];
			
			for (int i = 0; i < A; i++) {

	            int x = sc.nextInt();
	            int y = sc.nextInt();
	            int range = sc.nextInt();
	            int power = sc.nextInt();

	            bc[i] = new BC(y, x, range, power);
	        }

	        int AnowR = 1;
	        int AnowC = 1;

	        int BnowR = 10;
	        int BnowC = 10;

	        int answer = 0;
	        answer += charge(AnowR,AnowC, BnowR, BnowC);

	        for (int time = 0; time < M; time++) {
	        	AnowR += dr[moveA[time]];
	        	AnowC += dc[moveA[time]];

	        	BnowR += dr[moveB[time]];
	        	BnowC += dc[moveB[time]];

	            answer += charge(AnowR,AnowC, BnowR, BnowC);
	        }

	        System.out.println("#" + tc + " " + answer);
		}

}}
	


