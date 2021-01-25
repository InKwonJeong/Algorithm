package baekjoon.dynamic;

import java.util.Scanner;

public class Decomposition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int[][] d = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++) {
            d[i][1] = 1;
        }

        for(int i = 0; i <= n; i++) {
            for(int j = 2; j <= m; j++) {
                for(int k = 0; k <= i; k++) {
                    d[i][j] += d[k][j - 1];
                    d[i][j] %= 1000000000;
                }
            }
        }

        System.out.println(d[n][m]);
    }
}
