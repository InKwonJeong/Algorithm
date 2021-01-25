package programmers.dynamic;

import java.util.LinkedList;
import java.util.Queue;

public class HeavyRain {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        System.out.println(new HeavyRain().solution(m, n, puddles));
    }

    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    public int solution(int m, int n, int[][] puddles) {
        int[][] graph = new int[m][n];
        int[][] d = new int[m][n];

        for(int[] puddle : puddles)
            graph[puddle[0] - 1][puddle[1] - 1] = -2;

        d[0][0] = 1;
        graph[0][0] = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;
                if(graph[nx][ny] == 0 || graph[nx][ny] == graph[x][y] + 1) {
                    d[nx][ny] += d[x][y];
                    d[nx][ny] %= 1000000007;
                }

                if(graph[nx][ny] == 0) {
                    queue.offer(new Point(nx, ny));
                    graph[nx][ny] = graph[x][y] + 1;
                }
            }
        }

        return d[m - 1][n - 1];
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
