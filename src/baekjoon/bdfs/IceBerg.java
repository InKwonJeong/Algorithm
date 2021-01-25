package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IceBerg {

    private static int n, m;
    private static int[] dx, dy;
    private static int[][] graph;
    private static boolean[][] ocean;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};

        n = input.nextInt();
        m = input.nextInt();
        graph = new int[n][m];
        ocean = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                graph[i][j] = input.nextInt();
                if(graph[i][j] == 0)
                    ocean[i][j] = true;
            }
        }

        int year = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    meltIceberg(i, j);
                }
            }
            isOcean();
            int count = checkIceberg();
            year++;
            if(count > 1) {
                break;
            } else if(count == 0) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(year);
    }

    private static int checkIceberg() {
        boolean[][] visit = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!ocean[i][j] && !visit[i][j]) {
                    count++;
                    checkIceberg(i, j, visit);
                }
            }
        }
        return count;
    }

    private static void checkIceberg(int x, int y, boolean[][] visit) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if(!ocean[nx][ny] && !visit[nx][ny]) {
                    queue.offer(new Point(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }
    }

    private static void meltIceberg(int x, int y) {
        int count = 0;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;
            if(ocean[nx][ny])
                count++;
        }
        if(graph[x][y] > count)
            graph[x][y] -= count;
        else
            graph[x][y] = 0;
    }

    private static void isOcean() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!ocean[i][j] && graph[i][j] == 0)
                    ocean[i][j] = true;
            }
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
