package programmers.kakao;


public class PedestrianParadise {
    public static void main(String[] args) {
        int[] m = {3, 3};
        int[] n = {3, 6};
        int[][][] cityMap = {
                {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}
        };
        for(int i = 0; i < m.length; i++)
            System.out.println(new PedestrianParadise().solution(m[i], n[i], cityMap[i]));
    }

    private final int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] d = new int[m + 1][n + 1][2];
        d[1][1][0] = 1;
        d[1][1][1] = 1;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(cityMap[i - 1][j - 1] == 0) {
                    d[i][j][0] += (d[i - 1][j][0] + d[i][j - 1][1]) % MOD;
                    d[i][j][1] += (d[i - 1][j][0] + d[i][j - 1][1]) % MOD;
                } else if(cityMap[i - 1][j - 1] == 2) {
                    d[i][j][0] = (d[i - 1][j][0]) % MOD;
                    d[i][j][1] = (d[i][j - 1][1]) % MOD;
                } else {
                    d[i][j][0] = 0;
                    d[i][j][1] = 0;
                }
            }
        }

        return (d[m - 1][n][0] + d[m][n - 1][1]) % MOD;
    }
}
