package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomatoes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] dx = {1, 0, -1, 0}; // 오른쪽, 아래, 왼쪽, 위
        int[] dy = {0, -1, 0, 1}; // 오른쪽, 아래, 왼쪽, 위

        int m = input.nextInt();
        int n = input.nextInt();
        int[][] tomatoes = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tomatoes[i][j] = input.nextInt();
            }
        }

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tomatoes[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            for(int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if(tomatoes[nx][ny] == 0) {
                    queue.offer(new Point(nx, ny));
                    tomatoes[nx][ny] = tomatoes[x][y] + 1;
                }
            }
        }

        int day = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tomatoes[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if(day < tomatoes[i][j])
                    day = tomatoes[i][j];
            }
        }
        System.out.println(day - 1);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
