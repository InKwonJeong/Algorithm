package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MazeExploration {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] dx = {1, 0, -1, 0}; // 오른쪽, 아래, 왼쪽, 위
        int[] dy = {0, -1, 0, 1}; // 오른쪽, 아래, 왼쪽, 위

        int n = input.nextInt();
        int m = input.nextInt();
        int[][] maze = new int[n][m];
        boolean[][] check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = input.next();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        check[0][0] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if (!check[nx][ny] && maze[nx][ny] == 1) {
                    queue.offer(new Point(nx, ny));
                    maze[nx][ny] += maze[x][y];
                    check[nx][ny] = true;
                }
            }
        }

        System.out.println(maze[n - 1][m - 1]);

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


