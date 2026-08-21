        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
            	String line = sc.next();

                for(int j = 0; j<line.length();j++) {
                	arr[i][j] = line.charAt(j) - '0';
                }
                
            }
            int ans = 0;
            
            for (int i = 0; i <= N/2; i++) {
                for (int j = N/2-i; j <= N/2+i; j++) {
                    ans += arr[i][j];
                }
            }

            for (int i= N/2+1; i<N; i++) {
                int gap = i-N/2;
                for (int j = gap; j <N-gap; j++) {
                    ans += arr[i][j];
                }
            }

            System.out.println("#" + tc + " " + ans);
        }

    }
}