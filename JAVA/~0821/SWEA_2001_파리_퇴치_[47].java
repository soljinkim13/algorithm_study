//SWEA_2001_파리퇴치
//4중 포문.. 더 나은 방식 있을듯

import java.util.Scanner;

public class SWEA_2001_파리퇴치 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N][N];

            int now;
            int max = 0;
            for (int i = 0; i < N; i++) {
            	for(int j = 0; j<N; j++) {
            		arr[i][j] = sc.nextInt();            		
            	}
            }
            
            for (int i = 0; i <= N-M; i++) {
            	for(int j = 0; j<= N-M; j++) {
            		now = 0;
            		for (int k = i; k < i+M; k++) {
                    	for(int l = j; l<j+M; l++) {
                    		            	now+=arr[k][l];	
                    	}
                    }
            		if(max<now) max = now;
            	}
            }
            
            

            System.out.println("#" + tc + " " + max);
        }

	}
}
