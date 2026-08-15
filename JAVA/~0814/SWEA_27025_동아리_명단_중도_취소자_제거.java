//27025. 동아리 명단 중도 취소자 제거
//list.remove(Integer.valueOf(sc.nextInt())); 핵심 !! 인트 숫자 그대로 넣으면 인덱스 취급함

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_27025 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1;i<=T;i++) {
			int origin = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<Integer>();
			for(int j = 0;j<origin;j++) {
				list.add(sc.nextInt());
			}
			int remove = sc.nextInt();
			for(int j = 0;j<remove;j++) {
				list.remove(Integer.valueOf(sc.nextInt()));
			}
			
			System.out.print("#"+i);
			if(list.isEmpty()) {
				System.out.print(" empty");
			}else {
				for (int k : list) {
				System.out.print(" "+k);
				}
			}
			
			System.out.println();
			
		}

	}

}