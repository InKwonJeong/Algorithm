package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RedGreenColorWeakness {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int n = input.nextInt();
        char[][] graph = new char[n][n];

        int a = 0;
        int b = 0;

        for(int i = 0; i < n; i++) {
            String str = input.next();
            for(int j = 0; j < n; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        Queue<Point> queue = new LinkedList<>();
        boolean[][] check = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!check[i][j]) {
                    a++;
                    queue.offer(new Point(i, j));
                    check[i][j] = true;
                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        int x = point.x;
                        int y = point.y;
                        for(int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                                continue;

                            if(graph[x][y] == graph[nx][ny] && !check[nx][ny]) {
                                check[nx][ny] = true;
                                queue.offer(new Point(nx, ny));
                            }
                        }
                    }
                }
            }
        }

        check = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!check[i][j]) {
                    b++;
                    queue.offer(new Point(i, j));
                    check[i][j] = true;
                    while (!queue.isEmpty()) {
                        Point point = queue.poll();
                        int x = point.x;
                        int y = point.y;
                        for(int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                                continue;

                            if(graph[x][y] == 'R' || graph[x][y] == 'G') {
                                if((graph[nx][ny] == 'R' || graph[nx][ny] == 'G') && !check[nx][ny]) {
                                    check[nx][ny] = true;
                                    queue.offer(new Point(nx, ny));
                                }
                            } else {
                                if(graph[x][y] == graph[nx][ny] && !check[nx][ny]) {
                                    check[nx][ny] = true;
                                    queue.offer(new Point(nx, ny));
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.printf("%d %d", a, b);
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
