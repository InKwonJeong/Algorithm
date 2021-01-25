package baekjoon.dynamic;

import java.util.Scanner;

public class NumberOfAscent {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[][] d = new int[n + 1][10];

        for(int i = 0; i <= 9; i++)
            d[1][i] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int k = 0; k <= j; k++) {
                    d[i][j] += d[i - 1][k];
                }
                d[i][j] %= 10007;
            }
        }

        int answer = 0;
        for(int i = 0; i <= 9; i++) {
            answer += d[n][i];
        }
        System.out.println(answer % 10007);
    }
}
