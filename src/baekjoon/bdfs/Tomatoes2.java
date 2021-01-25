package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomatoes2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] dx = {1, 0, -1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        int m = input.nextInt();
        int n = input.nextInt();
        int h = input.nextInt();

        int[][][] graph = new int[n][m][h];

        for(int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    graph[i][j][k] = input.nextInt();
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();
        for(int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j][k] == 1)
                        queue.offer(new Point(i, j, k));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            int z = point.z;
            for(int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h)
                    continue;
                if(graph[nx][ny][nz] == 0) {
                    graph[nx][ny][nz] = graph[x][y][z] + 1;
                    queue.offer(new Point(nx, ny, nz));
                }
            }
        }

        int answer = 0;
        boolean done = false;
        for(int k = 0; k < h; k++) {
            if(done)
                break;

            for (int i = 0; i < n; i++) {
                if(done)
                    break;

                for (int j = 0; j < m; j++) {
                    if (graph[i][j][k] == 0) {
                        answer = -1;
                        done = true;
                        break;
                    }

                    if(answer < graph[i][j][k] - 1)
                        answer = graph[i][j][k] - 1;
                }
            }
        }

        System.out.println(answer);
    }

    static class Point {
        int x, y, z;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
