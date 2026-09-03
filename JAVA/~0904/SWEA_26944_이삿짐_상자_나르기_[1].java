import java.util.Arrays;
import java.util.Scanner;

public class Solution_26944_김진솔 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] box = new int[N];
            int[] person = new int[M];
            int ans = 0;
            
            
            for(int i = 0; i<N; i++) {
            	box[i] = sc.nextInt();
            }
            for(int i = 0; i<M;i++) {
            	person[i] = sc.nextInt();
            }
            
            Arrays.sort(box);
            Arrays.sort(person);
            
            N -=1;
            M -=1;
            while(N>=0&&M>=0) {
            	if(box[N]<=person[M]) {
            		ans+=box[N];
            		N--;
            		M--;
            	}else if(box[N]>person[M]) {
            		N--;
            	}
            }
            
            


            System.out.println("#" + tc + " " + ans);
        }
		
		
		
	}
	
}
