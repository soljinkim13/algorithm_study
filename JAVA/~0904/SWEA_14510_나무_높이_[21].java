		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1; t<=tc;t++) {
			int n = 0;
			n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i<n ; i++) {
				arr[i] = sc.nextInt();
				
			}
			Arrays.sort(arr);
			int max = arr[n-1];
			int one = 0;
			int two = 0;
			for(int i = 0; i<n-1;i++) {
				int water = max - arr[i];
				two+=water/2;
				
				if(water%2!=0) one+=1;
				
			}
			while((one+1)<two) {
				two-=1;
				one+=2;
			}
			
		int ans = two*2;

        if (one>two) {
            ans = one*2 - 1;
        }
        System.out.println("#" + t + " " + ans);
		
			
		}
	
	}

}