import java.util.Arrays;
import java.util.Scanner;

public class SWEA_19646 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T;tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] ans = new int[n];
			for(int i = 0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			int num = 0;
			System.out.print("#"+tc+" ");
			for(int j = 0;j<5;j++) {
				System.out.print(arr[n-1-j]+" ");
				System.out.print(arr[j]+" ");
				
			}
			
			System.out.println();
		}

	}

}
