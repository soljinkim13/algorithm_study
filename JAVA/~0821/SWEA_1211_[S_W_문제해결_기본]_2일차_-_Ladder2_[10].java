import java.util.Scanner;

public class SWEA_1211 {
    static int[][] ladder;
    static int count;

    public static void move(int x, int y, int beforeY) {
        if (x == 99) return;
        count++;
        if (y>0 &&ladder[x][y-1]==1&&y-1 != beforeY) {
            move(x, y - 1, y);
        }else if (y < 99 && ladder[x][y + 1] == 1 && y + 1 != beforeY){
        	move(x, y + 1, y);
        }else {move(x + 1, y, y);}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int T = sc.nextInt();
            ladder = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = sc.nextInt();
                }
            }

            int min = Integer.MAX_VALUE;
            int start = 0;
            for (int i = 0; i < 100; i++) {
                if (ladder[0][i] == 1) {
                    count = 0;
                    move(0, i, -1);
                    if (count <= min) {
                        min = count;
                        start = i;
                    }
                }
            }

            System.out.println("#"+T+" " + start);
        }
    }
}