import java.util.Scanner;

public class Solution_2112_김진솔 {

    public static int D;
    public static int W;
    public static int K;

    public static int[][] film;

    public static int ans;

    public static boolean check() {
        for (int c = 0; c < W; c++) {
            int count = 1;
            boolean pass = false;

            for (int r = 1; r < D; r++) {
                if (film[r][c] == film[r-1][c]) {
                    count++;
                } else {
                    count = 1;
                }

                if (count >= K) {
                    pass = true;
                    break;
                }
            }
            if (!pass) {
                return false;
            }
        }

        return true;
    }


    public static void potion(int row, int count) {
        if (count >= ans) {
            return;
        }
        if (check()) {
            ans = count;
            return;
        }
        if (row == D) {
            return;
        }

        int[] backup = film[row].clone();

        potion(row + 1, count);

        for (int c = 0; c < W; c++) {
            film[row][c] = 0;
        }

        potion(row + 1, count + 1);

        film[row] = backup.clone();

        for (int c = 0; c < W; c++) {
            film[row][c] = 1;
        }

        potion(row + 1, count + 1);

        film[row] = backup;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();

            film = new int[D][W];

            for (int r = 0; r < D; r++) {
                for (int c = 0; c < W; c++) {
                    film[r][c] = sc.nextInt();
                }
            }


            ans = K;

            if (check()) {
                ans = 0;
            } else {
                potion(0, 0);
            }


            System.out.println("#" + tc + " " + ans);
        }

        sc.close();
    }
}