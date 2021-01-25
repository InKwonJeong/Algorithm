package baekjoon.stage.math1;

import java.util.Scanner;

public class WomenPresident {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t > 0) {
            int k = input.nextInt();
            int n = input.nextInt();
            int[][] d = new int[k + 1][n + 1];
            for(int i = 1; i <= n; i++)
                d[0][i] = i;

            for(int i = 1; i <= k; i++) {
                for(int j = 1; j <= n; j++) {
                    d[i][j] = d[i - 1][j] + d[i][j - 1];
                }
            }

            System.out.println(d[k][n]);

            t--;
        }
    }
}
