package programmers.practice;

public class FindTheLargestSquare {
    public static void main(String[] args) {
        int[][][] boards = {
                {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}},
                {{0, 0, 1, 1}, {1, 1, 1, 1}}
        };
        for(int[][] board : boards)
            System.out.println(new FindTheLargestSquare().solution(board));
    }

    public int solution(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int answer = 0;

        int[][] d = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(board[i - 1][j - 1] == 1) {
                    d[i][j] = 1 + min(d[i - 1][j], d[i][j - 1], d[i - 1][j - 1]);
                    if(answer < d[i][j])
                        answer = d[i][j];
                }
            }
        }

        return answer * answer;
    }

    private int min(int... nums) {
        int min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(min > nums[i])
                min = nums[i];
        }
        return min;
    }
}
