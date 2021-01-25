package baekjoon.dynamic;

import java.util.Scanner;

public class Jump {

    private static int n;
    private static int[][] graph;
    private static long[][] d;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        graph = new int[n][n];
        d = new long[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = input.nextInt();
                d[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static long dfs(int x, int y) {
        if(x == n - 1 && y == n - 1)
            return 1;

        if(d[x][y] == -1) {
            d[x][y] = 0;

            if(x + graph[x][y] < n)
                d[x][y] += dfs(x + graph[x][y], y);
            if(y + graph[x][y] < n)
                d[x][y] += dfs(x, y + graph[x][y]);
        }

        return d[x][y];
    }
}
