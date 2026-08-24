import java.util.Scanner;

public class SWEA_2070 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T;tc++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			System.out.print("#"+tc);
			if(n1>n2) System.out.println(" >");
			else if(n1==n2) System.out.println(" =");
			else if(n1<n2) System.out.println(" <");
		}
			
		
	}

}
