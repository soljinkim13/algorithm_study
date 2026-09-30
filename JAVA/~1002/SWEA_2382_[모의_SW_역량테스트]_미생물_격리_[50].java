import java.util.Scanner;

public class Solution {
    public static int[] dr = {0, -1, 1, 0, 0};
    public static int[] dc = {0, 0, 0, -1, 1};

    public static int N;
    public static int M;
    public static int K;

    public static micros[][] map;

    public static class micros {
        int num;   
        int dir;
        int maxNum;
        micros(int num, int dir) {
            this.num = num;
            this.dir = dir;
            this.maxNum = num;
        }
    }

    public static void move() {

        // 이동 결과를 저장할 새로운 맵
        micros[][] nextMap = new micros[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {

                if (map[r][c] == null) {
                    continue;
                }

                micros cur = map[r][c];
                int nr = r + dr[cur.dir];
                int nc = c + dc[cur.dir];

                int num = cur.num;
                int dir = cur.dir;

                if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
                    num /= 2;
                    if (dir == 1) dir = 2;
                    else if (dir == 2) dir = 1;
                    else if (dir == 3) dir = 4;
                    else if (dir == 4) dir = 3;
                }

                if (num == 0)  continue;
              
                if (nextMap[nr][nc] == null) {
                    nextMap[nr][nc] = new micros(num, dir);
                } else {
                    micros target = nextMap[nr][nc];
                    if (num > target.maxNum) {
                        target.maxNum = num;
                        target.dir = dir;
                    }
                    target.num += num;
                }
            }
        }

        map = nextMap;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();

            map = new micros[N][N];

            for (int i = 0; i < K; i++) {

                int insertR = sc.nextInt();
                int insertC = sc.nextInt();
                int num = sc.nextInt();
                int dir = sc.nextInt();

                map[insertR][insertC] = new micros(num, dir);
            }

            for (int i = 0; i < M; i++) {
                move();
            }

            int ans = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] != null) {
                        ans += map[r][c].num;
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}