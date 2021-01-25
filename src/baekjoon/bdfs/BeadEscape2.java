package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BeadEscape2 {

    private static int[] dx, dy;
    private static int n, m;
    private static char[][] graph;
    private static boolean[][][][] check;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};

        n = input.nextInt();
        m = input.nextInt();
        graph = new char[n][m];
        check = new boolean[n][m][n][m];

        Point point = new Point();

        for (int i = 0; i < n; i++) {
            String str = input.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j);
                if(graph[i][j] == 'R') {
                    point.rx = i;
                    point.ry = j;
                } else if(graph[i][j] == 'B') {
                    point.bx = i;
                    point.by = j;
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            check[p.rx][p.ry][p.bx][p.by] = true;

            if(p.count >= 10) {
                System.out.println(-1);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int rx = p.rx;
                int ry = p.ry;
                while(graph[rx + dx[i]][ry + dy[i]] != '#') {
                    rx += dx[i];
                    ry += dy[i];
                    if(graph[rx][ry] == 'O')
                        break;
                }

                int bx = p.bx;
                int by = p.by;
                while(graph[bx + dx[i]][by + dy[i]] != '#') {
                    bx += dx[i];
                    by += dy[i];
                    if(graph[bx][by] == 'O')
                        break;
                }

                if(graph[bx][by] == 'O')
                    continue;

                if(graph[rx][ry] == 'O') {
                    System.out.println(p.count + 1);
                    return;
                }

                if(rx == bx && ry == by) {
                    switch (i) {
                        case 0:
                            if(p.rx < p.bx)
                                rx -= 1;
                            else
                                bx -= 1;
                            break;
                        case 1:
                            if(p.ry < p.by)
                                ry -= 1;
                            else
                                by -= 1;
                            break;
                        case 2:
                            if(p.rx > p.bx)
                                rx += 1;
                            else
                                bx += 1;
                            break;
                        case 3:
                            if(p.ry > p.by)
                                ry += 1;
                            else
                                by += 1;
                            break;
                    }
                }

                if(!check[rx][ry][bx][by])
                    queue.offer(new Point(rx, ry, bx, by, p.count + 1));
            }
        }
        System.out.println(-1);
    }

    static class Point {
        int rx, ry, bx, by, count;

        public Point() {}

        public Point(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }
}
