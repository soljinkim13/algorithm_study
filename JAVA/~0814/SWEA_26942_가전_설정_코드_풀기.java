//SWEA_26942 가전 설정 코드 풀기

import java.util.Scanner;

public class SWEA_26942 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();

		for(int i = 1;i<=T;i++) {
			int toggle = sc.nextInt();
			String beforAns = sc.next();
			String n = "";
			for(int j = 0;j<toggle;j++) {
				char target = beforAns.charAt(j);
				int integerAns = Integer.parseInt(String.valueOf(target),16);
				String binaryAns = Integer.toBinaryString(integerAns);
				
				while(binaryAns.length()<4) {
					binaryAns="0"+binaryAns;
				}
				n+=binaryAns;
			}
			
			
			System.out.println("#"+i+" "+n);
		}
		


	}

}
