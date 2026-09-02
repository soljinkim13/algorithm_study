import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_26956_김진솔 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1;tc<=T;tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			LinkedList<Integer> luck = new LinkedList<Integer>();
			for(int i = 0;i<N;i++) luck.add(sc.nextInt());
			
			
			int now = 0;

			for (int i = 0; i < K; i++) {
			    now += M;
			    while (now > luck.size()) {
			        now -= luck.size();
			    }
			    
			    int newLuck;
			    if (now == luck.size()) {
			        newLuck = luck.get(now-1) + luck.get(0);
			    } else {
			        newLuck = luck.get(now-1) + luck.get(now);
			    }

			    luck.add(now, newLuck);
			}
		

            System.out.print("#" + tc);

            for (int i = luck.size()-1; i> luck.size()-11 &&i>=0; i--) {
                System.out.print(" " + luck.get(i));
            }

            System.out.println();
		}
	}

}