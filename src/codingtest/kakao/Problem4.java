package codingtest.kakao;

public class Problem4 {
    public static void main(String[] args) {
        int[][][] boards = {
                {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}},
                {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}},
                {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}}
        };
        for (int[][] board : boards)
            System.out.println(new Problem4().solution(board));
    }

    private int n, answer;
    private boolean[][] visit;
    private int[][] board;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public int solution(int[][] board) {
        this.board = board;
        n = board.length;
        visit = new boolean[n][n];
        answer = Integer.MAX_VALUE;
        dfs(0, 0, 0, 2);

        return answer;
    }

    private void dfs(int x, int y, int cost, int direction) {
        if(answer <= cost)
            return;

        if(x == n - 1 && y == n - 1) {
            answer = cost;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;

            if(!visit[nx][ny] && board[nx][ny] == 0) {
                visit[nx][ny] = true;
                if(direction == 2) {
                    dfs(nx, ny, cost + 100, i / 2);
                } else if(i / 2 == 0) {
                    if(direction == 0) {
                        dfs(nx, ny, cost + 100, i / 2);
                    } else {
                        dfs(nx, ny, cost + 600, i / 2);
                    }
                } else {
                    if(direction == 0) {
                        dfs(nx, ny, cost + 600, i / 2);
                    } else {
                        dfs(nx, ny, cost + 100, i / 2);
                    }
                }
                visit[nx][ny] = false;
            }
        }
    }
}
