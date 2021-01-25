package baekjoon.dynamic;

import java.util.Scanner;

public class ColorWheel {

    private static final int MOD = 1_000_000_003;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

        int[][] d = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            d[i][1] = i;
            d[i][0] = 1;
        }

        for(int i = 3; i <= n; i++) {
            for(int j = 2; j <= i / 2; j++) {
                d[i][j] = (d[i - 1][j] + d[i - 2][j - 1]) % MOD;
            }
        }

        System.out.println(d[n][k]);
    }
}
