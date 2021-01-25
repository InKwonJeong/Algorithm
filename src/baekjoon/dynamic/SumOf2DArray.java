package baekjoon.dynamic;

import java.util.Scanner;

public class SumOf2DArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int[][] graph = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                graph[i][j] = input.nextInt();
            }
        }

        int k = input.nextInt();
        while(k > 0) {
            int x1 = input.nextInt();
            int y1 = input.nextInt();
            int x2 = input.nextInt();
            int y2 = input.nextInt();

            int answer = 0;
            for(int i = x1; i <= x2; i++) {
                for(int j = y1; j <= y2; j++) {
                    answer += graph[i][j];
                }
            }

            System.out.println(answer);
            k--;
        }

    }
}
