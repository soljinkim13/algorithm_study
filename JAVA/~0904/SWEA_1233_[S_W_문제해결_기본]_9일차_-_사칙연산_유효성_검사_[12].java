import java.util.Scanner;

public class Solution_1233_김진솔 {
	static int ans;
	static boolean isNum;
	public static void num(String s) {
		try {
			int check = Integer.parseInt(s);
			isNum = true;
		}catch(Exception e){
			isNum = false;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1;tc<=10;tc++) {
			int node = sc.nextInt();
			sc.nextLine();
			
			int ans = 1;
			int i = 0;

			if(node%2==0) {
				ans = 0;				
			}
			isNum = true;
			
			while (i<node) {
				String line = sc.nextLine();
				
				if(ans==1) {
					String[] one = line.split(" ");

					String check = one[1];
					if (one.length == 4) {
						num(check);
						if(isNum) ans = 0;
					    
					} else {
						num(check);
						if(!isNum) ans = 0;
					}
				}
				
				
				i++;
				
			}
			

			
			System.out.println("#"+tc+" "+ans);
		}
	}

}
