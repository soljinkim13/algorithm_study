import java.util.*;

public class Solution_5648_김진솔 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static final int LIMIT = 2000;
    static final int OFFSET = 2000;

    static int[][] map = new int[4001][4001];

    static class Atom {
        int x;
        int y;
        int dir;
        int energy;

        Atom(int x, int y, int dir, int energy) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.energy = energy;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            
            ArrayList<Atom> atoms = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt()*2;
                int y = sc.nextInt()*2;
                int dir = sc.nextInt();
                int energy = sc.nextInt();

                atoms.add(new Atom(x, y, dir, energy));
            }

            int ans = 0;

            while (!atoms.isEmpty()) {
                ArrayList<Atom> moved = new ArrayList<>();

                // 모든 원자 이동 하면서
                for (Atom atom : atoms) {

                    atom.x += dx[atom.dir];
                    atom.y += dy[atom.dir];

                    // 영역 밖으로 나가면 컨티뉴
                    if (atom.x < -LIMIT || atom.x > LIMIT || atom.y < -LIMIT || atom.y > LIMIT) {
                        continue;
                    }
                    moved.add(atom);

                    map[atom.y + OFFSET][atom.x + OFFSET]++;
                }
                // 충돌하지 않은 원자만 다시
                ArrayList<Atom> next = new ArrayList<>();

                for (Atom atom : moved) {
                    int count=map[atom.y + OFFSET][atom.x + OFFSET];
                    // 두개 이상이면 충동했다는 의미
                    if (count >= 2) ans += atom.energy;
                    else next.add(atom);
                    
                }

                // 다시 map 초기화
                for (Atom atom : moved) {
                    map[atom.y + OFFSET][atom.x + OFFSET] = 0;
                }

                atoms = next;
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}