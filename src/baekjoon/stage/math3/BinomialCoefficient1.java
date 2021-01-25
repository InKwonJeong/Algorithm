package baekjoon.stage.math3;

import java.util.Scanner;

public class BinomialCoefficient1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();
        int[][] d = new int[n + 1][n + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= i; j++) {
                if(i == j || j == 0)
                    d[i][j] = 1;
                else
                    d[i][j] = (d[i - 1][j - 1] + d[i - 1][j]) % 10007;
            }
        }

        System.out.println(d[n][k]);
    }
}
