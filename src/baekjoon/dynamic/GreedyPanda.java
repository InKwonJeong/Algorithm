package baekjoon.dynamic;

import java.util.Scanner;

public class GreedyPanda {

    private static int n;
    private static int[] dx, dy;
    private static int[][] graph, d;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};

        n = input.nextInt();
        graph = new int[n][n];
        d = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = input.nextInt();
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int day = dfs(i, j);
                if(answer < day)
                    answer = day;
            }
        }
        System.out.println(answer);
    }

    private static int dfs(int x, int y) {
        if(d[x][y] > 0)
            return d[x][y];

        int day = 0;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                continue;

            if(graph[x][y] < graph[nx][ny]) {
                int d = dfs(nx, ny);
                if (day < d)
                    day = d;
            }
        }
        d[x][y] = day + 1;
        return d[x][y];
    }
}
