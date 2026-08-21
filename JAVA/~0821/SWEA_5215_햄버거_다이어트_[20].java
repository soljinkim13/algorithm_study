	static int N;
	static int L;
	static int[] taste;
	static int[] kcal;
	static int ans;
	
	public static void burger (int idx,int totalTaste, int totalCalorie) {
		if(totalCalorie>L) {
			return;
		}
		if(idx==N) {
			ans = Math.max(ans, totalTaste);
			return;
		}
		burger(idx+1,totalTaste+taste[idx],totalCalorie+kcal[idx]);
		burger(idx+1,totalTaste,totalCalorie);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T;tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			taste = new int[N];
			kcal = new int[N];
			for(int i = 0;i<N;i++) {
				taste[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			}
			ans = 0;
			
			burger(0,0,0);
			
			System.out.println("#"+tc+" "+ans);
			
			
		}
		

	}

}

