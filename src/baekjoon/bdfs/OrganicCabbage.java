package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OrganicCabbage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        int t = input.nextInt();
        while(t > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            int count = input.nextInt();
            int answer = 0;

            int[][] field = new int[n][m];
            boolean[][] check = new boolean[n][m];

            for(int i = 0; i < count; i++) {
                int x = input.nextInt();
                int y = input.nextInt();
                field[x][y] = 1;
            }

            Queue<Point> queue = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(field[i][j] == 1 && !check[i][j]) {
                        queue.offer(new Point(i, j));
                        check[i][j] = true;
                        while(!queue.isEmpty()) {
                            Point point = queue.poll();
                            int x = point.x;
                            int y = point.y;
                            for(int k = 0; k < dx.length; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];

                                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                                    continue;

                                if(field[nx][ny] == 1 && !check[nx][ny]) {
                                    queue.offer(new Point(nx, ny));
                                    check[nx][ny] = true;
                                }
                            }
                        }
                        answer++;
                    }
                }
            }
            System.out.println(answer);

            t--;
        }
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
