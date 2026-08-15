//SWEA_26942 수위계의 이진 눈금

import java.util.Scanner;

public class SWEA_26943 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();

		for(int i = 1;i<=T;i++) {
			double water = sc.nextDouble();
			String ans = "";
			int count = 0;
			while(count<13&&water>0) {
				water = water*2;
				if(water>=1) {
					ans += 1;
					water -= 1;
				}else {
					ans+= 0;
				}
				count++;
				
			}
			
			if(water!=0) ans = "overflow";
			
			
			System.out.println("#"+i+" "+ans);
		}
		


	}

}
