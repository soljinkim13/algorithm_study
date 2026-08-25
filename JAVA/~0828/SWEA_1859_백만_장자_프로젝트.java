	public static int left;
	public static int[] arr;
	public static long ans;
	public static int max;
	
	public static void cal(int piv) {
		max = arr[piv];
		for(int i = left;i<piv;i++) {
			if(arr[i]<max) ans += (max-arr[i]);
		}
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			left=0;
			ans = 0;
			arr = new int[N];
			for(int i = 0; i<N;i++) {
				arr[i] = sc.nextInt();
			}
			while(left<N) {
				int maxIdx = left;
				for(int i= left;i<N;i++) {
					if(arr[maxIdx]<arr[i]) maxIdx = i;
				}
				cal(maxIdx);
				left = maxIdx+1;
			}

			System.out.println("#"+tc+" "+ans);
			
		}
	

	}

}
