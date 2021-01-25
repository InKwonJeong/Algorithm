package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightsMove {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};

        int t = input.nextInt();
        while(t > 0) {
            int n = input.nextInt();
            int[][] graph = new int[n][n];

            int start_x = input.nextInt();
            int start_y = input.nextInt();
            int final_x = input.nextInt();
            int final_y = input.nextInt();

            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(start_x, start_y));
            graph[start_x][start_y] = 1;
            while (!queue.isEmpty()) {
                Point point = queue.poll();
                int x = point.x;
                int y = point.y;
                if(x == final_x && y == final_y)
                    break;

                for(int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                        continue;
                    if(graph[nx][ny] == 0) {
                        queue.offer(new Point(nx, ny));
                        graph[nx][ny] = graph[x][y] + 1;
                    }
                }
            }
            System.out.println(graph[final_x][final_y] - 1);

            t--;
        }
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
