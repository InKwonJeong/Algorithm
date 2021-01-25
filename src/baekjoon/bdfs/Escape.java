package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Escape {

    private static int n, m;
    private static int[] dx, dy;
    private static char[][] graph;
    private static boolean[][] visit;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};

        n = input.nextInt();
        m = input.nextInt();
        graph = new char[n][m];
        visit = new boolean[n][m];
        Pair start = new Pair();
        Pair end = new Pair();

        for (int i = 0; i < n; i++) {
            String str = input.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j);
                if (graph[i][j] == 'S') {
                    start.x = i;
                    start.y = j;
                } else if (graph[i][j] == 'D') {
                    end.x = i;
                    end.y = j;
                }
            }
        }

        int answer = 0;
        int level = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(start);
        visit[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if(p.x == end.x && p.y == end.y) {
                answer = p.dis;
                break;
            }

            if(level == p.dis) {
                flooding();
                level++;
            }

            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if(visit[nx][ny])
                    continue;

                if(graph[nx][ny] == '.' || graph[nx][ny] == 'D') {
                    queue.offer(new Pair(nx, ny, p.dis + 1));
                    visit[nx][ny] = true;
                }
            }
        }

        if(answer == 0)
            System.out.println("KAKTUS");
        else
            System.out.println(answer);
    }

    private static void flooding() {
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == '*') {
                    queue.offer(new Pair(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for(int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if(graph[nx][ny] == '.')
                    graph[nx][ny] = '*';
            }
        }
    }

    static class Pair {
        int x, y, dis;

        Pair() {}

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pair(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
