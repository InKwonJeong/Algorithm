package baekjoon.stage.shortestpath;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AlgoSpot {

    private static final int INF = 987654321;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int[][] graph;
    private static int n, m;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        m = input.nextInt();
        n = input.nextInt();
        graph = new int[n][m];
        for(int i = 0; i < n; i++) {
            String str = input.next();
            for(int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(dijkstra(0, 0, n - 1, m - 1));
    }

    private static int dijkstra(int x1, int y1, int x2, int y2) {
        int[][] distance = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for(int i = 0; i < n; i++)
            Arrays.fill(distance[i], INF);

        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        distance[x1][y1] = 0;

        priorityQueue.add(new Point(x1, y1, 0));
        while (!priorityQueue.isEmpty()) {
            Point point = priorityQueue.poll();

            if(visit[point.x][point.y]) continue;
            visit[point.x][point.y] = true;

            for(int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if(graph[nx][ny] == 1) {
                    if(distance[nx][ny] > distance[point.x][point.y] + 1) {
                        distance[nx][ny] = distance[point.x][point.y] + 1;
                        priorityQueue.add(new Point(nx, ny, distance[nx][ny]));
                    }
                } else {
                    if(distance[nx][ny] > distance[point.x][point.y]) {
                        distance[nx][ny] = distance[point.x][point.y];
                        priorityQueue.add(new Point(nx, ny, distance[nx][ny]));
                    }
                }
            }
        }

        return distance[x2][y2];
    }

    static class Point {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
