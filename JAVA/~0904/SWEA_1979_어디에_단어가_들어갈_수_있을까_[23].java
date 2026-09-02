import java.util.Scanner;

public class SWEA_1979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int ans = 0;
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] map = new int[N][N];
            for (int i=0;i<N; i++){
                for (int j=0;j<N; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i=0;i<N; i++){
                int count = 0;
                for (int j=0;j<N; j++){
                    if (map[i][j]==1) count++;
                    else {
                        if (count == K) {
                            ans++;
                        }

                        count = 0;
                    }
                }
                if (count ==K) {
                    ans++;
                }
            }
            for (int j=0;j<N; j++){
                int count = 0;
                for (int i=0;i<N; i++){
                    if (map[i][j]==1) count++;
                    else {
                        if (count == K) {
                            ans++;
                        }
                        count = 0;
                    }
                }
                if (count ==K) ans++;
                
            }

            
            
            System.out.println("#" + tc + " " + ans);
        }
    }
}