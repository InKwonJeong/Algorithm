package programmers.practice;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(new NQueen().solution(n));
    }

    private int n, answer;
    private boolean[] row, cross1, cross2;
    public int solution(int n) {
        this.n = n;
        row = new boolean[n + 1];
        cross1 = new boolean[2 * n];
        cross2 = new boolean[2 * n];

        permutation(1);

        return answer;
    }

    private void permutation(int column) {
        if(column > n) {
            answer++;
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!row[i] && !cross1[i + column - 1] && !cross2[n - column + i]) {
                row[i] = true;
                cross1[i + column - 1] = true;
                cross2[n - column + i] = true;
                permutation(column + 1);
                row[i] = false;
                cross1[i + column - 1] = false;
                cross2[n - column + i] = false;
            }
        }
    }
}
