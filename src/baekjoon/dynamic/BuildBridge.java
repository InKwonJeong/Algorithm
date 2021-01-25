package baekjoon.dynamic;

import java.util.Scanner;

public class BuildBridge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();
        while(t > 0) {
            int n = input.nextInt();
            int m = input.nextInt();

            int[][] d = new int[n + 1][m + 1];
            for(int i = 1; i <= m; i++)
                d[1][i] = i;

            for(int i = 2; i <= n; i++) {
                for(int j = i; j <= m; j++) {
                    int value = 0;
                    for(int k = 0; k <= j - i; k++) {
                        value += d[i - 1][j - 1 - k];
                    }
                    d[i][j] = value;
                }
            }

            System.out.println(d[n][m]);
            t--;
        }
    }
}
