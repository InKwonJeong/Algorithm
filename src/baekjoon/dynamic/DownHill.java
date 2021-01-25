package baekjoon.dynamic;

import java.util.Scanner;

public class DownHill {

    private static int[] dx, dy;
    private static int n, m;
    private static int[][] graph, d;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};

        n = input.nextInt();
        m = input.nextInt();
        graph = new int[n][m];
        d = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = input.nextInt();
                d[i][j] = -1;
            }
        }

        System.out.println(dfs(n - 1, m - 1));
    }

    private static int dfs(int x, int y) {
        if(x == 0 && y == 0)
            return 1;

        if(d[x][y] == -1) {
            d[x][y] = 0;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if(graph[x][y] < graph[nx][ny])
                    d[x][y] += dfs(nx, ny);
            }
        }
        return d[x][y];
    }
}
