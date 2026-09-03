class Solution {
    public static boolean[] visited;
		public static String[] temp;
		public static String[] ans;
		public static int target;
		public static String[][] ticket;
		public static void dfs(int n, String find) {
			if(n == target) {
				if(ans == null) ans = temp.clone();
				for (int i = 0; i < temp.length; i++) {
				    int check = temp[i].compareTo(ans[i]);
				    
				    if (check < 0) {
				    	ans = temp.clone();
				        break;
				    }else if(check>0) {
				    	break;
				    }
				}
				
				return;
			}
						
			for(int i = 0;i<ticket.length;i++) {
				if (!visited[i] && ticket[i][0].equals(find)) {
		            visited[i] = true;
		            temp[n] = ticket[i][1];
		            
		            dfs(n + 1, ticket[i][1]);

		            visited[i] = false;
		        }
			}
			
		}
		
		
	    public String[] solution(String[][] tickets) {
	    	ticket = tickets;
	    	target = tickets.length+1;
	    	
	    	
	    	visited = new boolean[tickets.length];
	    	ans = new String[target];
	    	temp = new String[target];
	    	temp[0] = "ICN";

            ans = null;

            dfs(1, "ICN");

            return ans;


	    }
	}