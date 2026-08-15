import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;


public class SWEA_1225 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		for(int i = 1;i<=10;i++) {
			Deque<Integer> deque = new ArrayDeque<>();
			int tc = sc.nextInt();
			for(int j = 0; j<8;j++) {
				deque.add(sc.nextInt());
			}
			
			int num = 1;
			
			while(deque.getLast()>0) {
				int target = deque.getFirst();
				deque.removeFirst();
				target -= num;
				deque.add(target);
				num++;
				if(num>5) num%=5;
			}
			deque.removeLast();
			deque.add(0);
			
			
			
			System.out.print("#"+i+" ");
			for (int item : deque) {
	            System.out.print(item + " ");
	        }
	        System.out.println();
		}
		


	}

}
