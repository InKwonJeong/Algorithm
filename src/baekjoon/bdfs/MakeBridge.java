package baekjoon.bdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MakeBridge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int n = input.nextInt();
        boolean[][] visit = new boolean[n][n];
        int[][] graph = new int[n][n];
        int[][] d = new int[n][n];
        int[][] a = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = input.nextInt();
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visit[i][j] && graph[i][j] == 1) {
                    count++;
                    queue.offer(new Pair(i, j));
                    visit[i][j] = true;
                    a[i][j] = count;
                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        for(int k = 0; k < 4; k++) {
                            int nx = pair.x + dx[k];
                            int ny = pair.y + dy[k];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                                continue;
                            if(!visit[nx][ny] && graph[nx][ny] == 1) {
                                queue.offer(new Pair(nx, ny));
                                visit[nx][ny] = true;
                                a[nx][ny] = count;
                            }
                        }
                    }
                }
            }
        }

        int answer = 0;
        for(int c = 1; c <= count; c++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    d[i][j] = graph[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (d[i][j] == 1 && a[i][j] == c) {
                        queue.offer(new Pair(i, j));
                    }
                }
            }

            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = pair.x + dx[k];
                    int ny = pair.y + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                        continue;
                    if (d[nx][ny] == 0) {
                        queue.offer(new Pair(nx, ny));
                        d[nx][ny] = d[pair.x][pair.y] + 1;
                    } else if (d[nx][ny] == 1 && a[nx][ny] != c) {
                        if (answer == 0 || answer > d[pair.x][pair.y] - 1)
                            answer = d[pair.x][pair.y] - 1;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
