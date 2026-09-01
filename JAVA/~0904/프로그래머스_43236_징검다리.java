import java.util.Arrays;


class Solution {
   public int solution(int distance, int[] rocks, int n) {
	    	int ans = 0;
			int min = 1;
			int max = distance/(rocks.length-n+1);
			
			while(min<=max) {
				int check = (max+min)/2;
				int countRemove = 0;
				int before = 0;
				
				Arrays.sort(rocks);
				
				int[] arr = Arrays.copyOf(rocks, rocks.length+1);
				arr[arr.length-1] = distance;
				
				for(int i : arr) {
					if(i - before<check) {
						countRemove++;
					}else {
						before = i;
					}
				}
				
				if(countRemove<=n) {
					min = check+1;
					ans = check;
				}else {
					max = check-1;
					
				}
				
				
			}
			
			return ans;
	    }
	}


