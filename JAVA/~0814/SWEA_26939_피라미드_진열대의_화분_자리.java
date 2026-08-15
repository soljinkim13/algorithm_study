//SWEA_26939 피라미드 진열대의 화분 자리


import java.util.Scanner;

public class SWEA_26939 {
	static int tree[];
	static int N;
	static int number;
			
	public static void inorder(int idx) {
		if(idx>N) return;
		inorder(idx*2);
		tree[idx] = number++;
		inorder(idx*2+1);
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();

		for(int i = 1;i<=T;i++) {
			N = sc.nextInt();
			tree = new int[N+1];
			number = 1;
			
			inorder(1);
			System.out.println("#"+i+" "+tree[1]+" "+tree[N/2]);
		}
		


	}

}
