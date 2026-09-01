import java.util.Scanner;

public class Solution_3499_김진솔 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
        	int N = sc.nextInt();
        	String[] arr = new String[N];
        	for(int i = 0; i< N; i++) {
        		arr[i] = sc.next();
        	}
        	int half = (N+1)/2;
        	
        	System.out.print("#"+tc+" ");
			for(int i = 0; i < N/2; i++) {
			   System.out.print(arr[i]+" "+arr[half+i]+" ");
			}
        	if(N%2!=0) System.out.print(arr[half-1]);
        	

			
			System.out.println();
        }
	}

}
