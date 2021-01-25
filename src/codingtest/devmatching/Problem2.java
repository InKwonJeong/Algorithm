package codingtest.devmatching;

public class Problem2 {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 1, 1, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(new Problem2().solution(board));
    }

    private int[][] board;
    private boolean[][][] visit;

    public int solution(int[][] board) {
        this.board = board;
        visit = new boolean[15][15][4];

        int answer = 0;
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j++) {
                if(board[i][j] != 0) {
                    if(!visit[i][j][0]) {
                        if(check0(i, j, board[i][j]))
                            return board[i][j];
                    }
                    if(!visit[i][j][1]) {
                        if(check1(i, j, board[i][j]))
                            return board[i][j];
                    }
                    if(!visit[i][j][2]) {
                        if(check2(i, j, board[i][j]))
                            return board[i][j];
                    }

                    if(!visit[i][j][3]) {
                        if(check3(i, j, board[i][j]))
                            return board[i][j];
                    }
                }
            }
        }


        return answer;
    }

    private boolean check0(int x, int y, int color) { // 가로
        int count = 0;
        while (board[x][y] == color) {
            visit[x][y][0] = true;
            count++;
            y++;
            if(y >= 15)
                break;
        }
        return count == 5;
    }

    private boolean check1(int x, int y, int color) { // 세로
        int count = 0;
        while (board[x][y] == color) {
            visit[x][y][1] = true;
            count++;
            x++;
            if(x >= 15)
                break;
        }
        return count == 5;
    }

    private boolean check2(int x, int y, int color) { // 오른쪽 대각선
        int count = 0;
        while (board[x][y] == color) {
            visit[x][y][2] = true;
            count++;
            x++;
            y++;
            if(x >= 15 || y >= 15)
                break;
        }
        return count == 5;
    }

    private boolean check3(int x, int y, int color) { // 왼쪽 대각선
        int count = 0;
        while (board[x][y] == color) {
            visit[x][y][3] = true;
            count++;
            x++;
            y--;
            if(x >= 15 || y < 0)
                break;
        }
        return count == 5;
    }
}
