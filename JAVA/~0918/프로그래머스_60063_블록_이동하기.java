import java.util.Scanner;

//좌표 두개를 로봇의 위치로 지정하고 푸는 방식
//움직일 수 있는 방향 8개
//축을 움직일땐 축의 대각선 블럭도 확인해야함

//의 방식으로 구현하려했으나 실패
//공부한 코드를 첨부합니다

public class Solution {

    static int N;
    static int[][] board;
    static boolean[][][] visited;

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Robot {
        int r, c, dir, cnt;

        Robot(int r, int c, int dir, int cnt) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    public int solution(int[][] input) {
        board = input;
        N = board.length;
        visited = new boolean[N][N][2];

        Queue<Robot> q = new ArrayDeque<>();

        // 처음에는 (0,0), (0,1)을 차지하는 가로 상태
        q.offer(new Robot(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Robot now = q.poll();

            int r = now.r;
            int c = now.c;
            int dir = now.dir;

            // 목적지 확인
            if (dir == 0) { // 가로
                if ((r == N - 1 && c == N - 1)
                        || (r == N - 1 && c + 1 == N - 1)) {
                    return now.cnt;
                }
            } else { // 세로
                if ((r == N - 1 && c == N - 1)
                        || (r + 1 == N - 1 && c == N - 1)) {
                    return now.cnt;
                }
            }

            // 1. 상하좌우 이동
            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (dir == 0) {
                    // 가로 : (nr,nc), (nr,nc+1)
                    if (canGo(nr, nc) && canGo(nr, nc + 1)) {
                        if (!visited[nr][nc][0]) {
                            visited[nr][nc][0] = true;
                            q.offer(new Robot(nr, nc, 0, now.cnt + 1));
                        }
                    }

                } else {
                    // 세로 : (nr,nc), (nr+1,nc)
                    if (canGo(nr, nc) && canGo(nr + 1, nc)) {
                        if (!visited[nr][nc][1]) {
                            visited[nr][nc][1] = true;
                            q.offer(new Robot(nr, nc, 1, now.cnt + 1));
                        }
                    }
                }
            }

            // 2. 회전
            if (dir == 0) {
                // 현재:
                // ■ ■
                //
                // 위 또는 아래 두 칸이 모두 비어있어야 회전 가능

                for (int d : new int[]{-1, 1}) {

                    int nr = r + d;

                    if (canGo(nr, c) && canGo(nr, c + 1)) {

                        if (d == -1) {
                            // 위로 회전

                            // 왼쪽 축
                            if (!visited[r - 1][c][1]) {
                                visited[r - 1][c][1] = true;
                                q.offer(new Robot(r - 1, c, 1, now.cnt + 1));
                            }

                            // 오른쪽 축
                            if (!visited[r - 1][c + 1][1]) {
                                visited[r - 1][c + 1][1] = true;
                                q.offer(new Robot(r - 1, c + 1, 1, now.cnt + 1));
                            }

                        } else {
                            // 아래로 회전

                            // 왼쪽 축
                            if (!visited[r][c][1]) {
                                visited[r][c][1] = true;
                                q.offer(new Robot(r, c, 1, now.cnt + 1));
                            }

                            // 오른쪽 축
                            if (!visited[r][c + 1][1]) {
                                visited[r][c + 1][1] = true;
                                q.offer(new Robot(r, c + 1, 1, now.cnt + 1));
                            }
                        }
                    }
                }

            } else {
                // 현재:
                // ■
                // ■
                //
                // 왼쪽 또는 오른쪽 두 칸이 모두 비어있어야 회전 가능

                for (int d : new int[]{-1, 1}) {

                    int nc = c + d;

                    if (canGo(r, nc) && canGo(r + 1, nc)) {

                        if (d == -1) {
                            // 왼쪽 회전

                            // 위쪽 축
                            if (!visited[r][c - 1][0]) {
                                visited[r][c - 1][0] = true;
                                q.offer(new Robot(r, c - 1, 0, now.cnt + 1));
                            }

                            // 아래쪽 축
                            if (!visited[r + 1][c - 1][0]) {
                                visited[r + 1][c - 1][0] = true;
                                q.offer(new Robot(r + 1, c - 1, 0, now.cnt + 1));
                            }

                        } else {
                            // 오른쪽 회전

                            // 위쪽 축
                            if (!visited[r][c][0]) {
                                visited[r][c][0] = true;
                                q.offer(new Robot(r, c, 0, now.cnt + 1));
                            }

                            // 아래쪽 축
                            if (!visited[r + 1][c][0]) {
                                visited[r + 1][c][0] = true;
                                q.offer(new Robot(r + 1, c, 0, now.cnt + 1));
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }

    static boolean canGo(int r, int c) {
        return r >= 0 && r < N
                && c >= 0 && c < N
                && board[r][c] == 0;
    }
}