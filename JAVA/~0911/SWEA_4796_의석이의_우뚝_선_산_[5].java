import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int mountain = sc.nextInt();
			int[] arr = new int[mountain+1];
			
			int left = 0 ;
			int top = 0;
			int right = 0;
			int ans = 0;
			
			for(int i = 0 ; i< mountain; i++){
				arr[i] = sc.nextInt();
			}
			
			for(int i = 0; i<mountain;i++){
				
				if(top==0){
					if(arr[left]<arr[i]) top = i;
					if(arr[left]>arr[i]) left = i;
				}else{
					if(arr[top]<arr[i]) top = i;
					if(arr[top]>arr[i]){
						if(arr[i-1]<arr[i]){
							right = i-1;
							ans += (top-left) * (right - top);
							left = i-1;
							top = i;
							right = 0;
						}
						
						if(i!=mountain-1&&arr[i-1] > arr[i] && arr[i]<arr[i+1]){
							right = i;
							ans += (top-left) * (right - top);
							left = i;
							top = 0;
							right = 0;
						}
						if(i==mountain-1&&arr[i-1] > arr[i]){
							right = i;
							ans += (top-left) * (right - top);

						}
						
					}				
				}				
			}
			
			System.out.println("#"+tc+" "+ans);

		}
	}
}