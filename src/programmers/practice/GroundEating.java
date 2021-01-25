package programmers.practice;

public class GroundEating {
    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println(new GroundEating().solution(land));
    }

    int solution(int[][] land) {
        int n = land.length;
        int m = 4;
        int[][] d = new int[n][m];

        d[0][0] = land[0][0];
        d[0][1] = land[0][1];
        d[0][2] = land[0][2];
        d[0][3] = land[0][3];

        for(int i = 1; i < n; i++) {
            d[i][0] = land[i][0] + max(d[i - 1][1], d[i - 1][2], d[i - 1][3]);
            d[i][1] = land[i][1] + max(d[i - 1][0], d[i - 1][2], d[i - 1][3]);
            d[i][2] = land[i][2] + max(d[i - 1][0], d[i - 1][1], d[i - 1][3]);
            d[i][3] = land[i][3] + max(d[i - 1][0], d[i - 1][1], d[i - 1][2]);
        }

        return max(d[n - 1][0], d[n - 1][1], d[n - 1][2], d[n - 1][3]);
    }

    private int max(int... value) {
        int max = value[0];
        for(int i = 1; i < value.length; i++) {
            if (max < value[i])
                max = value[i];
        }
        return max;
    }
}
