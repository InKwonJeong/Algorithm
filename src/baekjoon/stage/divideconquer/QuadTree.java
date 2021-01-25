package baekjoon.stage.divideconquer;

import java.util.Scanner;

public class QuadTree {

    private static int[][] graph;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        graph = new int[n][n];

        for(int i = 0; i < n; i++) {
            String line = input.next();
            for(int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(divide(0, 0, n));
    }

    private static String divide(int r, int c, int n) {
        if(n == 1) {
            return String.valueOf(graph[r][c]);
        }

        boolean finish = true;
        int color = graph[r][c];
        for(int i = r; i < r + n; i++) {
            for(int j = c; j < c + n; j++) {
                if(color != graph[i][j]) {
                    finish = false;
                    break;
                }
            }
            if(!finish)
                break;
        }

        if(finish) {
            return String.valueOf(color);
        } else {
            return String.format(
                    "(%s%s%s%s)",
                    divide(r, c, n / 2),
                    divide(r, c + n / 2, n / 2),
                    divide(r + n / 2, c, n / 2),
                    divide(r + n / 2, c + n / 2, n / 2)
            );
        }
    }
}
