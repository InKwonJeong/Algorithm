package baekjoon.dynamic;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int[][] graph = new int[n + 1][m + 1];
        int[][] d = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                graph[i][j] = input.nextInt();
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                int value = 0;
                if(i > 1 && value < d[i - 1][j])
                    value = d[i - 1][j];
                if(j > 1 && value < d[i][j - 1])
                    value = d[i][j - 1];

                d[i][j] = value + graph[i][j];
            }
        }

        System.out.println(d[n][m]);
    }
}
